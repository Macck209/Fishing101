package net.macck209.fishing101.items.polymer;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface PolymerAutoItem extends PolymerItem {
    @Override
    default @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context, HolderLookup.Provider lookup) {
        return PolymerResourcePackUtils.hasMainPack(context)
                ? PolymerItem.super.getPolymerItemModel(stack, context, lookup)
                : null
                ;
    }
}
