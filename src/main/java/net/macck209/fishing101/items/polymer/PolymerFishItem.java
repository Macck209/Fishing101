package net.macck209.fishing101.items.polymer;

import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PolymerFishItem extends Item implements PolymerAutoItem {
    private final Item polymerItem;
    private final TextColor color;
    private final Boolean isChorus;
    private final Boolean isCharged;
    private final Boolean isChilly;
    private final Item returnItem;

    public PolymerFishItem(Properties settings, Item polymerItem, TextColor color) {
        this(settings, polymerItem, color, false, false, false, Items.EGG);
    }

    public PolymerFishItem(Properties settings, Item polymerItem, TextColor color, Boolean isChorus, Boolean isCharged, Boolean isChilly, Item returnItem) {
        super(settings);
        this.polymerItem = polymerItem;
        this.color = color;
        this.isChorus = isChorus;
        this.isCharged = isCharged;
        this.isChilly = isChilly;
        this.returnItem = returnItem;
    }

    private PolymerFishItem(Builder builder) {
        super(builder.settings);
        this.polymerItem = builder.polymerItem;
        this.color = builder.color;
        this.isChorus = builder.isChorus;
        this.isCharged = builder.isCharged;
        this.isChilly = builder.isChilly;
        this.returnItem = builder.returnItem;
    }

    public static class Builder {
        private final Properties settings;
        private final Item polymerItem;
        private final TextColor color;
        private Boolean isChorus = false;
        private Boolean isCharged = false;
        private Boolean isChilly = false;
        private Item returnItem = Items.EGG;

        public Builder(Properties settings, Item polymerItem, TextColor color) {
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
            return new PolymerFishItem(this);
        }
    }

    // Drops beside the user like the old dropItem(stack, false, false); 26.3's drop() also swings the arm.
    public static void dropAtUser(LivingEntity user, ItemStack stack) {
        ItemEntity entity = user.createItemStackToDrop(stack, false, false);
        if (entity != null) {
            user.level().addFreshEntity(entity);
        }
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(this.getDescriptionId()).setStyle(Style.EMPTY.withColor(color));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return this.polymerItem;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        Consumable consumable = stack.get(DataComponents.CONSUMABLE);

        if (!world.isClientSide() && user instanceof Player) {
            if (isChorus) {
                new TeleportRandomlyConsumeEffect().apply(world, stack, user);
            }
            if (isCharged) {
                this.startThunder(world, user);
            }

            if (isChilly) {
                user.setTicksFrozen(200);
            }

            if (returnItem != Items.EGG && world instanceof ServerLevel) {
                dropAtUser(user, returnItem.getDefaultInstance());
            }
        }
        return consumable != null ? consumable.onConsume(world, user, stack) : stack;
    }

    private void startThunder(Level world, LivingEntity user) {
        if (!(world instanceof ServerLevel serverWorld)) {
            return;
        }

        BlockPos bp = user.blockPosition();

        serverWorld.setThunderLevel(1F);
        // Weather is server-wide in 26.x; 1.21.x ignored this call outside the overworld.
        if (serverWorld.dimension() == Level.OVERWORLD) {
            serverWorld.getServer().setWeatherParameters(0, 9600, true, true);
        }

        if (serverWorld.canSeeSky(bp)) {
            LightningBolt lightningEntity = EntityTypes.LIGHTNING_BOLT.create(serverWorld, EntitySpawnReason.EVENT);
            if (lightningEntity != null) {
                lightningEntity.snapTo(Vec3.atBottomCenterOf(bp));
                lightningEntity.setCause(user instanceof ServerPlayer ? (ServerPlayer) user : null);
                serverWorld.addFreshEntity(lightningEntity);
            }
        }
        serverWorld.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.WEATHER, 10000.0F, 0.95F);
        serverWorld.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.WEATHER, 2.0F, 0.7F);

    }
}
