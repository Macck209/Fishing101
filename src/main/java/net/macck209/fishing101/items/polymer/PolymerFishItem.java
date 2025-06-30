package net.macck209.fishing101.items.polymer;

import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.Objects;

public class PolymerFishItem extends Item implements PolymerAutoItem {
    private final Item polymerItem;
    private final TextColor color;
    private final Boolean isChorus;
    private final Boolean isCharged;
    private final Boolean isChilly;
    private final Item returnItem;

    public PolymerFishItem(Settings settings, Item polymerItem, TextColor color) {
        this(settings, polymerItem, color, false, false, false, Items.EGG);
    }

    public PolymerFishItem(Settings settings, Item polymerItem, TextColor color, Boolean isChorus, Boolean isCharged, Boolean isChilly, Item returnItem) {
        super(settings);
        this.polymerItem = polymerItem;
        this.color = color;
        this.isChorus = isChorus;
        this.isCharged = isCharged;
        this.isChilly = isChilly;
        this.returnItem = returnItem;
    }

    private PolymerFishItem(Item polymerItem, Builder builder) {
        super(builder.settings);
        this.polymerItem = polymerItem;
        this.color = builder.color;
        this.isChorus = builder.isChorus;
        this.isCharged = builder.isCharged;
        this.isChilly = builder.isChilly;
        this.returnItem = builder.returnItem;
    }

    public static class Builder {
        private final Settings settings;
        private final Item polymerItem;
        private final TextColor color;
        private Boolean isChorus = false;
        private Boolean isCharged = false;
        private Boolean isChilly = false;
        private Item returnItem = Items.EGG;

        public Builder(Settings settings, Item polymerItem, TextColor color) {
            this.settings = settings;
            this.polymerItem = polymerItem;
            this.color = color;
        }

        public Builder isChorus() {
            this.isChorus = true;
            return this;
        }

        public Builder isCharged() {
            this.isCharged = true;
            return this;
        }

        public Builder isChilly() {
            this.isChilly = true;
            return this;
        }

        public Builder returnItem(Item returnItem) {
            this.returnItem = returnItem;
            return this;
        }

        public PolymerFishItem build() {
            return new PolymerFishItem(Items.STICK, this);
        }
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey()).setStyle(Style.EMPTY.withColor(color));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return this.polymerItem;
    }

    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context){
        return PolymerTextures.MODELS.get(this);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ConsumableComponent consumableComponent = stack.get(DataComponentTypes.CONSUMABLE);

        if (!world.isClient && user instanceof PlayerEntity) {
            if (isChorus) {
                this.teleportRandomly(world, user);
            }
            if (isCharged) {
                this.startThunder(world, user);
            }

            if (isChilly) {
                user.setFrozenTicks(200);
            }

            if (returnItem != Items.EGG && world instanceof ServerWorld serverWorld) {
                user.dropItem(serverWorld, returnItem, 0);
            }
        }
        return consumableComponent != null ? consumableComponent.finishConsumption(world, user, stack) : stack;
    }

    private void startThunder(World world, LivingEntity user) {
        if (!(world instanceof ServerWorld serverWorld)) {
            return;
        }
        
        BlockPos bp = user.getBlockPos();

        world.setThunderGradient(1F);
        RegistryKey<World> registryKey = world.getRegistryKey();
        Objects.requireNonNull(Objects.requireNonNull(world.getServer()).getWorld(registryKey)).setWeather(0, processDuration(world, 9600, ServerWorld.THUNDER_WEATHER_DURATION_PROVIDER), true, true);

        if (world.isSkyVisible(bp)) {
            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, serverWorld);
            if (lightningEntity != null) {
                lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(bp));
                lightningEntity.setChanneler(user instanceof ServerPlayerEntity ? (ServerPlayerEntity) user : null);
                world.spawnEntity(lightningEntity);
            }
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER, 10000.0F, 0.95F);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.WEATHER, 2.0F, 0.7F);

    }

    private static int processDuration(World world, int duration, IntProvider provider) {
        return duration == -1 ? provider.get(world.getRandom()) : duration;
    }

    private void teleportRandomly(World world, LivingEntity user) {
        if (!(world instanceof ServerWorld serverWorld)) {
            return;
        }
        
        boolean bl = false;

        for(int i = 0; i < 16; ++i) {
            double d = user.getX() + (user.getRandom().nextDouble() - 0.5) * (double)16.0F;
            double e = MathHelper.clamp(user.getY() + (user.getRandom().nextDouble() - 0.5) * (double)16.0F, world.getBottomY(), world.getBottomY() + serverWorld.getLogicalHeight() - 1);
            double f = user.getZ() + (user.getRandom().nextDouble() - 0.5) * (double)16.0F;
            if (user.hasVehicle()) {
                user.stopRiding();
            }

            Vec3d vec3d = user.getPos();
            if (user.teleport(d, e, f, true)) {
                world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(user));
                SoundCategory soundCategory;
                SoundEvent soundEvent;
                if (user instanceof FoxEntity) {
                    soundEvent = SoundEvents.ENTITY_FOX_TELEPORT;
                    soundCategory = SoundCategory.NEUTRAL;
                } else {
                    soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    soundCategory = SoundCategory.PLAYERS;
                }

                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, soundCategory);
                user.onLanding();
                bl = true;
                break;
            }
        }

        if (bl && user instanceof PlayerEntity playerEntity) {
            playerEntity.clearCurrentExplosion();
        }
    }
}
