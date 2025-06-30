package net.macck209.fishing101.mixin;

import net.macck209.fishing101.registries.ItemRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Shadow
    public abstract Item asItem();

    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void modifyFinishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (this.asItem() == Items.COD || this.asItem() == Items.SALMON || this.asItem() == Items.TROPICAL_FISH || this.asItem() == Items.PUFFERFISH
                || this.asItem() == Items.COOKED_COD || this.asItem() == Items.COOKED_SALMON) {
            if (!world.isClient && world instanceof ServerWorld serverWorld) {
                user.dropItem(serverWorld, ItemRegistry.FISH_BONES, 0);
            }
        }
        cir.setReturnValue(stack);
    }
}
