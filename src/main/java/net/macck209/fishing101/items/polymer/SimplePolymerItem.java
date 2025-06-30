package net.macck209.fishing101.items.polymer;

import net.macck209.fishing101.Fishing101Initializer;
import net.minecraft.text.TextColor;

public class SimplePolymerItem {
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
    public static final TextColor SOLAR;
    public static final TextColor WITCH;
    public static final TextColor FLOWER;
    public static final TextColor PANDA;
    static{
        ORDINARY=getTextColor("#ffffff");
        GRAY=getTextColor("#aaaaaa");
        DEFORMED=getTextColor("#596c3d");
        TROPICAL=getTextColor("#88c720");
        MUDDY=getTextColor("#7f4721");
        DIVINE=getTextColor("#ffe558");
        LUMINOUS=getTextColor("#00cda0");
        MANGROVE=getTextColor("#773731");
        JELLYFISH=getTextColor("#00e3e0");
        END=getTextColor("#e0e49e");
        ANGLER=getTextColor("#1d3b6d");
        SOLAR=getTextColor("#c0973c");
        WITCH=getTextColor("#5e8a39");
        FLOWER=getTextColor("#f8848d");
        PANDA=getTextColor("#dbd7cf");
    }

    private static TextColor getTextColor(String name) {
        return TextColor.parse(name).getOrThrow(message -> {
            Fishing101Initializer.LOGGER.error("Something went wrong when creating TextColor's for FishItem: {}", message);
            return new IllegalStateException("Failed to parse TextColor: " + message);
        });
    }

}
