package net.macck209.fishing101.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.macck209.fishing101.Fishing101Initializer;
import net.macck209.fishing101.items.fishes.AutoFishItem;
import net.macck209.fishing101.items.fishes.FishItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ItemRegistry {
    // Raw fish
    public static final Item ORDINARY_CARP = registerItem("ordinary_carp", new AutoFishItem(
            new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F).build()), Items.TROPICAL_FISH,
            "Carp",
            FishItem.ORDINARY
    ));
    public static final Item DEFORMED_CARP = registerItem("deformed_carp", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(-1F)
                .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            "Deformed Carp",
            FishItem.DEFORMED
    ));
    public static final Item LUMINOUS_CARP = registerItem("luminous_carp", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            "Luminous Carp",
            FishItem.LUMINOUS
    ));
    public static final Item ORDINARY_CATFISH = registerItem("ordinary_catfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            "Catfish",
            FishItem.ORDINARY
    ));
    public static final Item MUDDY_CATFISH = registerItem("muddy_catfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            "Muddy Catfish",
            FishItem.MUDDY
    ));
    public static final Item TROPICAL_CATFISH = registerItem("tropical_catfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            "Tropical Catfish",
            FishItem.TROPICAL
    ));
    public static final Item DIVINE_CATFISH = registerItem("divine_catfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.5F)
                .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 5 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600 * 20,1), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600 * 20,4), 1).build()), Items.TROPICAL_FISH,
            "Divine Catfish",
            FishItem.DIVINE
    ));
    public static final Item ORDINARY_MACKEREL = registerItem("ordinary_mackerel", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            "Mackerel",
            FishItem.ORDINARY
    ));
    public static final Item LUMINOUS_MACKEREL = registerItem("luminous_mackerel", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            "Luminous Mackerel",
            FishItem.LUMINOUS
    ));
    public static final Item MANGROVE_JACK = registerItem("mangrove_jack", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).build()), Items.TROPICAL_FISH,
            "Mangrove Jack",
            FishItem.MANGROVE
            ));
    public static final Item ORDINARY_SHRIMP = registerItem("ordinary_shrimp", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F).build()), Items.TROPICAL_FISH,
            "Shrimp",
            FishItem.ORDINARY
    ));
    public static final Item LUMINOUS_SHRIMP = registerItem("luminous_shrimp", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            "Luminous Shrimp",
            FishItem.LUMINOUS
    ));
    public static final Item JELLYFISH = registerItem("jellyfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.4F)
                .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 8 * 20,1), 0.25F)
                .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 150 * 20), 0.25F)
                .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 150 * 20), 0.25F)
                .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 150 * 20), 0.25F).build()), Items.TROPICAL_FISH,
            "Jellyfish",
            FishItem.JELLYFISH
    ));


    // Smoked fish
    public static final Item SMOKED_ORDINARY_CARP = registerItem("smoked_ordinary_carp", new AutoFishItem(
            new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8F).build()), Items.TROPICAL_FISH,
            "Smoked Carp",
            FishItem.ORDINARY
    ));
    public static final Item SMOKED_DEFORMED_CARP = registerItem("smoked_deformed_carp", new AutoFishItem(
            new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
                .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            "Smoked Deformed Carp",
            FishItem.DEFORMED
    ));
    public static final Item SMOKED_LUMINOUS_CARP = registerItem("smoked_luminous_carp", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH,
            "Smoked Luminous Carp",
            FishItem.LUMINOUS
    ));
    public static final Item SMOKED_ORDINARY_CATFISH = registerItem("smoked_catfish", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5F).build()), Items.TROPICAL_FISH,
            "Smoked Catfish",
            FishItem.ORDINARY
    ));
    public static final Item SMOKED_ORDINARY_MACKEREL = registerItem("smoked_ordinary_mackerel", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.7F).build()), Items.TROPICAL_FISH,
            "Smoked Mackerel",
            FishItem.ORDINARY
    ));
    public static final Item SMOKED_LUMINOUS_MACKEREL = registerItem("smoked_luminous_mackerel", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.7F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH,
            "Smoked Luminous Mackerel",
            FishItem.LUMINOUS
    ));
    public static final Item SMOKED_MANGROVE_JACK = registerItem("smoked_mangrove_jack", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(8).saturationModifier(1F).build()), Items.TROPICAL_FISH,
            "Smoked Mangrove Jack",
            FishItem.MANGROVE
    ));
    public static final Item SMOKED_ORDINARY_SHRIMP = registerItem("smoked_ordinary_shrimp", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F).build()), Items.TROPICAL_FISH,
            "Cooked Shrimp",
            FishItem.ORDINARY
    ));
    public static final Item SMOKED_LUMINOUS_SHRIMP = registerItem("smoked_luminous_shrimp", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH,
            "Cooked Luminous Shrimp",
            FishItem.LUMINOUS
    ));



    public static Item registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Fishing101Initializer.MOD_ID, name), item);
        PolymerTextures.requestModel(new Identifier(Fishing101Initializer.MOD_ID, "item/" + name), item);
        return item;
    }

    public static void register() {
    }

}
