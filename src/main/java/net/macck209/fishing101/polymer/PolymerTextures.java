package net.macck209.fishing101.polymer;


import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.IdentityHashMap;
import java.util.Map;

public class PolymerTextures {
    public static final Map<Item, PolymerModelData> MODELS = new IdentityHashMap<>();

    public static void setup(String MOD_ID) {
        PolymerResourcePackUtils.addModAssets(MOD_ID);
    }

    public static void requestModel(Identifier identifier, Item item) {
        MODELS.put(item, PolymerResourcePackUtils.requestModel(((PolymerItem) item).getPolymerItem(item.getDefaultStack(), null), identifier));
    }
}
