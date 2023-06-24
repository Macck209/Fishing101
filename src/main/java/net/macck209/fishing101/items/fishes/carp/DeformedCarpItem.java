package net.macck209.fishing101.items.fishes.carp;

import net.macck209.fishing101.items.fishes.AutoFishItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class DeformedCarpItem extends AutoFishItem {
    public DeformedCarpItem(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("Deformed Carp").setStyle(Style.EMPTY.withColor(AutoFishItem.DEFORMED));
    }
}