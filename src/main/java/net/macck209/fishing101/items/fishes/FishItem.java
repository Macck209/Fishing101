package net.macck209.fishing101.items.fishes;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TextColor;
import org.jetbrains.annotations.Nullable;

public class FishItem extends Item implements PolymerItem {
    private final Item polymerItem;
    public static final TextColor ORDINARY;
    public static final TextColor GRAY;
    public static final TextColor DEFORMED;
    public static final TextColor TROPICAL;
    public static final TextColor MUDDY;
    public static final TextColor DIVINE;
    public static final TextColor LUMINOUS;
    public static final TextColor MANGROVE;
    public static final TextColor JELLYFISH;
    public static final TextColor END;
    public static final TextColor ANGLER;


    public FishItem(Settings settings, Item polymerItem) {
        super(settings);
        this.polymerItem = polymerItem;
    }
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return this.polymerItem;}


    static{
        ORDINARY=TextColor.parse("#ffffff");
        GRAY=TextColor.parse("#aaaaaa");
        DEFORMED=TextColor.parse("#596c3d");
        TROPICAL=TextColor.parse("#88c720");
        MUDDY=TextColor.parse("#7f4721");
        DIVINE=TextColor.parse("#ffe558");
        LUMINOUS=TextColor.parse("#00cda0");
        MANGROVE=TextColor.parse("#773731");
        JELLYFISH=TextColor.parse("#00e3e0");
        END=TextColor.parse("#e0e49e");
        ANGLER=TextColor.parse("#1d3b6d");
    }
}
