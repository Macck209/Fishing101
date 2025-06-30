package net.macck209.fishing101.items.polymer;

import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

public class PolymerSwordItem extends Item implements PolymerAutoItem {

    public PolymerSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial
                .applyToolSettings(settings, BlockTags.SHOVEL_MINEABLE, attackDamage, attackSpeed, 0)
                .enchantable(1)
        );
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.IRON_SWORD;
    }

    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context){
        return PolymerTextures.MODELS.get(this);
    }
}
