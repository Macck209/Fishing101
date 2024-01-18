package net.macck209.fishing101.registries;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.macck209.fishing101.Fishing101Initializer;
import net.macck209.fishing101.items.FishBookItem;
import net.macck209.fishing101.items.MealBookItem;
import net.macck209.fishing101.items.fishes.AutoFishItem;
import net.macck209.fishing101.items.fishes.AutoPolymerSwordItem;
import net.macck209.fishing101.items.fishes.FishItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ItemRegistry {
    private static final List<Block> SUITABLE_CRAB_CLAW_BLOCKS = Arrays.asList(
            Blocks.SAND,
            Blocks.RED_SAND,
            Blocks.SOUL_SAND,
            Blocks.SUSPICIOUS_SAND,
            Blocks.SUSPICIOUS_GRAVEL,
            Blocks.GRAVEL,
            Blocks.PINK_CONCRETE_POWDER,
            Blocks.BLACK_CONCRETE_POWDER,
            Blocks.BLUE_CONCRETE_POWDER,
            Blocks.BROWN_CONCRETE_POWDER,
            Blocks.CYAN_CONCRETE_POWDER,
            Blocks.GRAY_CONCRETE_POWDER,
            Blocks.GREEN_CONCRETE_POWDER,
            Blocks.LIGHT_BLUE_CONCRETE_POWDER,
            Blocks.LIGHT_GRAY_CONCRETE_POWDER,
            Blocks.LIME_CONCRETE_POWDER,
            Blocks.MAGENTA_CONCRETE_POWDER,
            Blocks.WHITE_CONCRETE_POWDER,
            Blocks.RED_CONCRETE_POWDER,
            Blocks.PURPLE_CONCRETE_POWDER,
            Blocks.ORANGE_CONCRETE_POWDER,
            Blocks.YELLOW_CONCRETE_POWDER
    );

    private static final Set<Item> fishingItems = new HashSet<>();
    //private static final Identifier GROUP_TITLE_TRANSLATION_KEY = new Identifier(Fishing101Initializer.MOD_ID, "fishing_101");


    //--------------------------------------------------
    // Raw fish
    public static final Item FISH_BONES = registerItem("fish_bones", new AutoFishItem(new FabricItemSettings().maxCount(64),
            Items.BONE, FishItem.ORDINARY
    ));
    // Raw fish
    public static final Item ORDINARY_CARP = registerItem("ordinary_carp", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item DEFORMED_CARP = registerItem("deformed_carp", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(-1F)
                .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.DEFORMED).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item LUMINOUS_CARP = registerItem("luminous_carp", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.LUMINOUS).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ORDINARY_CATFISH = registerItem("ordinary_catfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item MUDDY_CATFISH = registerItem("muddy_catfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            FishItem.MUDDY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item TROPICAL_CATFISH = registerItem("tropical_catfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            FishItem.TROPICAL).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item DIVINE_CATFISH = registerItem("divine_catfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(1.5F)
                .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 5 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600 * 20,1), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300 * 20,4), 1).build()), Items.TROPICAL_FISH,
            FishItem.DIVINE).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ORDINARY_MACKEREL = registerItem("ordinary_mackerel", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item LUMINOUS_MACKEREL = registerItem("luminous_mackerel", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.LUMINOUS).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item MANGROVE_JACK = registerItem("mangrove_jack", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).build()), Items.TROPICAL_FISH,
            FishItem.MANGROVE).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ORDINARY_SHRIMP = registerItem("ordinary_shrimp", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY
    ));
    public static final Item LUMINOUS_SHRIMP = registerItem("luminous_shrimp", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.LUMINOUS
    ));
    public static final Item JELLYFISH = registerItem("jellyfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.4F)
                .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 150 * 20), 0.5F)
                .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 150 * 20), 0.5F).build()), Items.TROPICAL_FISH,
            FishItem.JELLYFISH
    ));
    public static final Item END_JELLYFISH = registerItem("end_jellyfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.4F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 150 * 20,2), 0.25F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 150 * 20,2), 0.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150 * 20,2), 0.5F).build()), Items.TROPICAL_FISH,
            FishItem.END
    ));
    public static final Item DIVINE_JELLYFISH = registerItem("divine_jellyfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(1.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5 * 20), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 5 * 20), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 600 * 20), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 600 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.DIVINE).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ANGLERFISH = registerItem("anglerfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 8 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.ANGLER).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item RED_KOI = registerItem("red_koi", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item YELLOW_KOI = registerItem("yellow_koi", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item THUNDERFIN = registerItem("thunderfin", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item STARFISH = registerItem("starfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY
    ));
    public static final Item END_STARFISH = registerItem("end_starfish", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0F).build()), Items.TROPICAL_FISH,
            FishItem.END
    ));
    public static final Item ICE_COD = registerItem("ice_cod", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SOLARFISH = registerItem("solarfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 40 * 20,2),1).build()),
            Items.TROPICAL_FISH, FishItem.SOLAR).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item WITCHFISH = registerItem("witchfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 60 * 20,0,false,false),1).build()),
            Items.TROPICAL_FISH, FishItem.WITCH).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item FLOWERFISH = registerItem("flowerfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 60 * 20,2),1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20,1),1).build()),
            Items.TROPICAL_FISH, FishItem.FLOWER).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item PANDAFISH = registerItem("pandafish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 60 * 20,0),1).build()),
            Items.TROPICAL_FISH, FishItem.PANDA).returnItem(ItemRegistry.FISH_BONES).build()
    );


    //--------------------------------------------------
    // Smoked fish
    public static final Item SMOKED_ORDINARY_CARP = registerItem("smoked_ordinary_carp", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_DEFORMED_CARP = registerItem("smoked_deformed_carp", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
                .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 30 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.DEFORMED).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_LUMINOUS_CARP = registerItem("smoked_luminous_carp", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.8F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.LUMINOUS).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_ORDINARY_CATFISH = registerItem("smoked_catfish", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_ORDINARY_MACKEREL = registerItem("smoked_ordinary_mackerel", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.7F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_LUMINOUS_MACKEREL = registerItem("smoked_luminous_mackerel", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.7F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.LUMINOUS).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_MANGROVE_JACK = registerItem("smoked_mangrove_jack", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(8).saturationModifier(1F).build()), Items.TROPICAL_FISH,
            FishItem.MANGROVE).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_ORDINARY_SHRIMP = registerItem("smoked_ordinary_shrimp", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY
    ));
    public static final Item SMOKED_LUMINOUS_SHRIMP = registerItem("smoked_luminous_shrimp", new AutoFishItem(
            new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300 * 20), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.LUMINOUS
    ));
    public static final Item SMOKED_ANGLERFISH = registerItem("smoked_anglerfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(7).saturationModifier(0.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 90 * 20), 1).build()), Items.TROPICAL_FISH,
            FishItem.ANGLER).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item CHARGED_THUNDERFIN = registerItem("charged_thunderfin", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).alwaysEdible().build()), Items.TROPICAL_FISH,
            FishItem.DIVINE).isCharged().returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_KOI = registerItem("smoked_koi", new AutoFishItem.Builder(
            new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(9).saturationModifier(1F).build()), Items.TROPICAL_FISH,
            FishItem.ORDINARY).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_SOLARFISH = registerItem("smoked_solarfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 90 * 20,4),1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 90 * 20,0),1).build()),
            Items.TROPICAL_FISH, FishItem.SOLAR).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_WITCHFISH = registerItem("smoked_witchfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 180 * 20,0,false,false),1).build()),
            Items.TROPICAL_FISH, FishItem.WITCH).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_FLOWERFISH = registerItem("smoked_flowerfish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 90 * 20,3),1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 90 * 20,0),1).build()),
            Items.TROPICAL_FISH, FishItem.FLOWER).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_PANDAFISH = registerItem("smoked_pandafish", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 180 * 20,0),1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 180 * 20,2),1).build()),
            Items.TROPICAL_FISH, FishItem.PANDA).returnItem(ItemRegistry.FISH_BONES).build()
    );


    //--------------------------------------------------
    // Other food related items
    public static final Item DOUGH = registerItem("dough", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(0).saturationModifier(0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10 * 20), 0.3F).build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY
    ));
    public static final Item NOODLES = registerItem("noodles", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5F).build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY
    ));
    public static final Item CHICKEN_BROTH = registerItem("chicken_broth", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(8).saturationModifier(1F).alwaysEdible().build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY).returnItem(Items.BOWL).build()
    );
    public static final Item SPAGHETTI_FRUTTI_DI_MARE = registerItem("spaghetti_frutti_di_mare", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(10).saturationModifier(1.5F).alwaysEdible().build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY).returnItem(Items.BOWL).build()
    );
    public static final Item TENTACLE = registerItem("tentacle", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10 * 20), 0.2F).build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY
    ));
    public static final Item COOKED_TENTACLE = registerItem("cooked_tentacle", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0F).build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY
    ));
    public static final Item STARFISH_SHASHLIK = registerItem("starfish_shashlik", new AutoFishItem
            .Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5F).alwaysEdible().build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY).returnItem(Items.STICK).build()
    );
    public static final Item END_STARFISH_SHASHLIK = registerItem("end_starfish_shashlik", new AutoFishItem
            .Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5F).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60 * 20), 1).build()),
            Items.COOKED_CHICKEN, FishItem.END).returnItem(Items.STICK).build()
    );
    public static final Item PURPLE_PASTA = registerItem("purple_pasta", new AutoFishItem.Builder(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(8).saturationModifier(0.2F).alwaysEdible()
                    .build()),
            Items.CHORUS_FRUIT, FishItem.ORDINARY).isChorus().returnItem(Items.BOWL).build()
    );
    public static final Item RICE = registerItem("rice", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0F).build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY
    ));
    public static final Item SUSHI = registerItem("sushi", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 300 * 20), 1).build()),
            Items.COOKED_CHICKEN, FishItem.ORDINARY
    ));
    public static final Item THICK_GOO = registerItem("thick_goo", new AutoFishItem(new FabricItemSettings().maxCount(64)
            .food(new FoodComponent.Builder().hunger(0).saturationModifier(0F).alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 20), 1).build()),
            Items.DRIED_KELP, FishItem.ORDINARY
    ));


    //--------------------------------------------------
    // Books & other items
    public static final Item FISH_BOOK = registerItem("fish_book", new FishBookItem(new Item.Settings().maxCount(1)));
    public static final Item MEAL_BOOK = registerItem("meal_book", new MealBookItem(new Item.Settings().maxCount(1)));
    public static final Item CRAB_CLAW = registerItem("crab_claw", new AutoPolymerSwordItem(
            ToolMaterials.STONE,
            1,
            -1,
            new Item.Settings().maxCount(1).maxDamage(Integer.MAX_VALUE),
            "Crab Claw",
            SUITABLE_CRAB_CLAW_BLOCKS,
            true));


    //--------------------------------------------------
    public static Item registerItem(String path, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Fishing101Initializer.MOD_ID, path), item);
        PolymerTextures.requestModel(new Identifier(Fishing101Initializer.MOD_ID, "item/" + path), item);
        fishingItems.add(item);
        return item;
    }

    public static void register() {
        ItemGroup group = FabricItemGroup.builder()
                .displayName(Text.translatable("item.fishing101.group_title"))
                .icon(RED_KOI::getDefaultStack)
                .entries((context, entries) -> fishingItems.forEach(entries::add))
                .build();

        PolymerItemGroupUtils.registerPolymerItemGroup(new Identifier(Fishing101Initializer.MOD_ID), group);
    }
}
