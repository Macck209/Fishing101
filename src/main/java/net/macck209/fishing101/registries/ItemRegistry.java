package net.macck209.fishing101.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.macck209.fishing101.Fishing101Initializer;
import net.macck209.fishing101.items.CopperFishingRodItem;
import net.macck209.fishing101.items.fishes.carp.*;
import net.macck209.fishing101.items.fishes.catfish.*;
import net.macck209.fishing101.items.fishes.mackerel.LuminousMackerelItem;
import net.macck209.fishing101.items.fishes.mackerel.OrdinaryMackerelItem;
import net.macck209.fishing101.items.fishes.mackerel.SmokedLuminousMackerelItem;
import net.macck209.fishing101.items.fishes.mackerel.SmokedOrdinaryMackerelItem;
import net.macck209.fishing101.items.fishes.other.MangroveJackItem;
import net.macck209.fishing101.items.fishes.other.SmokedMangroveJackItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ItemRegistry {
    public static final Item COPPER_FISHING_ROD = registerItem("copper_fishing_rod", new CopperFishingRodItem(new FabricItemSettings().maxCount(1).maxDamage(200), Items.FISHING_ROD));
    // Raw fish
    public static final Item ORDINARY_CARP = registerItem("ordinary_carp", new OrdinaryCarpItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F).build()), Items.TROPICAL_FISH));
    public static final Item DEFORMED_CARP = registerItem("deformed_carp", new DeformedCarpItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(-1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 30 * 20), 1).build()), Items.TROPICAL_FISH));
    public static final Item LUMINOUS_CARP = registerItem("luminous_carp", new LuminousCarpItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH));
    public static final Item ORDINARY_CATFISH = registerItem("ordinary_catfish", new OrdinaryCatfishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH));
    public static final Item MUDDY_CATFISH = registerItem("muddy_catfish", new MuddyCatfishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH));
    public static final Item TROPICAL_CATFISH = registerItem("tropical_catfish", new TropicalCatfishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH));
    public static final Item DIVINE_CATFISH = registerItem("divine_catfish", new DivineCatfishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5 * 20), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 5 * 20), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600 * 20,1), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600 * 20,4), 1).build()), Items.TROPICAL_FISH));
    public static final Item ORDINARY_MACKEREL = registerItem("ordinary_mackerel", new OrdinaryMackerelItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F).build()), Items.TROPICAL_FISH));
    public static final Item LUMINOUS_MACKEREL = registerItem("luminous_mackerel", new LuminousMackerelItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH));
    public static final Item MANGROVE_JACK = registerItem("mangrove_jack", new MangroveJackItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).build()), Items.TROPICAL_FISH));

    // Smoked fish
    public static final Item SMOKED_ORDINARY_CARP = registerItem("smoked_ordinary_carp", new SmokedOrdinaryCarpItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8F).build()), Items.TROPICAL_FISH));
    public static final Item SMOKED_DEFORMED_CARP = registerItem("smoked_deformed_carp", new SmokedDeformedCarpItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 30 * 20), 1).build()), Items.TROPICAL_FISH));
    public static final Item SMOKED_LUMINOUS_CARP = registerItem("smoked_luminous_carp", new SmokedLuminousCarpItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH));
    public static final Item SMOKED_ORDINARY_CATFISH = registerItem("smoked_catfish", new SmokedCatfishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5F).build()), Items.TROPICAL_FISH));
    public static final Item SMOKED_ORDINARY_MACKEREL = registerItem("smoked_ordinary_mackerel", new SmokedOrdinaryMackerelItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.7F).build()), Items.TROPICAL_FISH));
    public static final Item SMOKED_LUMINOUS_MACKEREL = registerItem("smoked_luminous_mackerel", new SmokedLuminousMackerelItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.7F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH));
    public static final Item SMOKED_MANGROVE_JACK = registerItem("smoked_mangrove_jack", new SmokedMangroveJackItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(8).saturationModifier(1F).build()), Items.TROPICAL_FISH));


    public static Item registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Fishing101Initializer.MOD_ID, name), item);
        PolymerTextures.requestModel(new Identifier(Fishing101Initializer.MOD_ID, "item/" + name), item);
        return item;
    }

    public static void register() {
    }

}
