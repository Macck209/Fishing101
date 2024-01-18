package net.macck209.fishing101.items.fishes;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AutoPolymerSwordItem extends SwordItem implements PolymerItem {
    private final String name;
    private final List<Block> suitableMiningBlocks;
    private final boolean crabClawEnchantments;

    public AutoPolymerSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, String name, List<Block> suitableMiningBlocks, boolean crabClawEnchantments) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.name = name;
        this.suitableMiningBlocks = suitableMiningBlocks;
        this.crabClawEnchantments = crabClawEnchantments;
    }
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player)
    {
        return Items.STICK;
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public boolean isSuitableFor(BlockState state) {
        return suitableMiningBlocks.stream().anyMatch(block -> state.isOf(block));
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (isSuitableFor(state)) {
            return 6F;
        } else {
            return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }
}
