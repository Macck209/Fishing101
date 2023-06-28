package net.macck209.fishing101.items.fishes;

import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import org.jetbrains.annotations.Nullable;

public class AutoFishItem extends FishItem {
    private final String name;
    private final TextColor color;
    public AutoFishItem(Settings settings, Item polymerItem, String name, TextColor color) {
        super(settings, polymerItem);
        this.name = name;
        this.color = color;
    }
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(name).setStyle(Style.EMPTY.withColor(color));
    }
}
