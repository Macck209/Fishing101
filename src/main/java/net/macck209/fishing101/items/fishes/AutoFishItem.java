package net.macck209.fishing101.items.fishes;

import net.macck209.fishing101.polymer.PolymerTextures;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AutoFishItem extends FishItem {
    private final TextColor color;
    private final Boolean isChorus;
    private final Boolean isCharged;
    private final Item returnItem;

    public AutoFishItem(Settings settings, Item polymerItem, TextColor color) {
        this(settings, polymerItem, color, false, false, Items.EGG);
    }

    public AutoFishItem(Settings settings, Item polymerItem,TextColor color, Boolean isChorus, Boolean isCharged, Item returnItem) {
        super(settings, polymerItem);
        this.color = color;
        this.isChorus = isChorus;
        this.isCharged = isCharged;
        this.returnItem = returnItem;
    }

    private AutoFishItem(Builder builder) {
        super(builder.settings, builder.polymerItem);
        this.color = builder.color;
        this.isChorus = builder.isChorus;
        this.isCharged = builder.isCharged;
        this.returnItem = builder.returnItem;
    }

    public static class Builder {
        private Settings settings;
        private Item polymerItem;
        private TextColor color;
        private Boolean isChorus = false;
        private Boolean isCharged = false;
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

        public Builder returnItem(Item returnItem) {
            this.returnItem = returnItem;
            return this;
        }

        public AutoFishItem build() {
            return new AutoFishItem(this);
        }
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey()).setStyle(Style.EMPTY.withColor(color));
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (!world.isClient) {
            double d = user.getX();
            double e = user.getY();
            double f = user.getZ();

            if(isChorus) {
                for (int i = 0; i < 16; ++i) {
                    double g = user.getX() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                    double h = MathHelper.clamp(user.getY() + (double) (user.getRandom().nextInt(16) - 8), (double) world.getBottomY(), (double) (world.getBottomY() + ((ServerWorld) world).getLogicalHeight() - 1));
                    double j = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                    if (user.hasVehicle()) {
                        user.stopRiding();
                    }

                    Vec3d vec3d = user.getPos();
                    if (user.teleport(g, h, j, true)) {
                        world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(user));
                        SoundEvent soundEvent = user instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        world.playSound(null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        user.playSound(soundEvent, 1.0F, 1.0F);
                        break;
                    }
                }

                if (user instanceof PlayerEntity) {
                    ((PlayerEntity) user).getItemCooldownManager().set(this, 20);
                }
            } else if (isCharged) {
                BlockPos bp = user.getBlockPos();

                world.setThunderGradient(1F);
                RegistryKey<World> registryKey = world.getRegistryKey() ;
                Objects.requireNonNull(Objects.requireNonNull(world.getServer()).getWorld(registryKey)).setWeather(0, processDuration(world, 9600, ServerWorld.THUNDER_WEATHER_DURATION_PROVIDER), true, true);

                if (world.isSkyVisible(bp)) {
                    LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
                    if (lightningEntity != null) {
                        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(bp));
                        lightningEntity.setChanneler(user instanceof ServerPlayerEntity ? (ServerPlayerEntity)user : null);
                        world.spawnEntity(lightningEntity);
                    }
                }
                world.playSound(d, e, f, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER, 10000.0F, 0.95F, false);
                world.playSound(d, e, f, SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.WEATHER, 2.0F, 0.7F, false);
            }

            //TODO re-implement this
            /*
            if(name.equals("Ice Cod")){
                user.setFrozenTicks(200);
            }*/

            if(returnItem!=Items.EGG){
                user.dropItem(returnItem, 0);
            }
        }
        return itemStack;
    }

    private static int processDuration(World world, int duration, IntProvider provider) {
        return duration == -1 ? provider.get(world.getRandom()) : duration;
    }
}
