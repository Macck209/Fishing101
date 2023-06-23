package net.macck209.fishing101.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.macck209.fishing101.Fishing101Initializer;
import net.macck209.fishing101.items.CopperFishingRodItem;
import net.macck209.fishing101.items.fishes.carp.DeformedCarpItem;
import net.macck209.fishing101.items.fishes.carp.LuminousCarpItem;
import net.macck209.fishing101.items.fishes.carp.OrdinaryCarpItem;
import net.macck209.fishing101.items.fishes.catfish.DivineCatfishItem;
import net.macck209.fishing101.items.fishes.catfish.MuddyCatfishItem;
import net.macck209.fishing101.items.fishes.catfish.OrdinaryCatfishItem;
import net.macck209.fishing101.items.fishes.catfish.TropicalCatfishItem;
import net.macck209.fishing101.items.fishes.mackerel.LuminousMackerelItem;
import net.macck209.fishing101.items.fishes.mackerel.OrdinaryMackerelItem;
import net.macck209.fishing101.items.fishes.other.MangroveJackItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ItemRegistry {
    public static final Item COPPER_FISHING_ROD = registerItem("copper_fishing_rod", new CopperFishingRodItem(new FabricItemSettings().maxCount(1).maxDamage(200), Items.FISHING_ROD));
    public static final Item ORDINARY_CARP = registerItem("ordinary_carp", new OrdinaryCarpItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item DEFORMED_CARP = registerItem("deformed_carp", new DeformedCarpItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item LUMINOUS_CARP = registerItem("luminous_carp", new LuminousCarpItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item ORDINARY_CATFISH = registerItem("ordinary_catfish", new OrdinaryCatfishItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item MUDDY_CATFISH = registerItem("muddy_catfish", new MuddyCatfishItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item TROPICAL_CATFISH = registerItem("tropical_catfish", new TropicalCatfishItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item DIVINE_CATFISH = registerItem("divine_catfish", new DivineCatfishItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item ORDINARY_MACKEREL = registerItem("ordinary_mackerel", new OrdinaryMackerelItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item LUMINOUS_MACKEREL = registerItem("luminous_mackerel", new LuminousMackerelItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));
    public static final Item MANGROVE_JACK = registerItem("mangrove_jack", new MangroveJackItem(new FabricItemSettings().maxCount(64), Items.TROPICAL_FISH));

    public static Item registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Fishing101Initializer.MOD_ID, name), item);
        PolymerTextures.requestModel(new Identifier(Fishing101Initializer.MOD_ID, "item/" + name), item);
        return item;
    }

    public static void register() {
    }

}
