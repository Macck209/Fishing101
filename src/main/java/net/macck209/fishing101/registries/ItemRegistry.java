package net.macck209.fishing101.registries;

import eu.pb4.polymer.core.api.item.PolymerCreativeModeTabUtils;
import net.macck209.fishing101.items.PolymerFishBookItem;
import net.macck209.fishing101.items.PolymerMealBookItem;
import net.macck209.fishing101.items.polymer.PolymerArmorItem;
import net.macck209.fishing101.items.polymer.PolymerFishItem;
import net.macck209.fishing101.items.polymer.PolymerSwordItem;
import net.macck209.fishing101.items.polymer.SimplePolymerItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.*;
import java.util.function.Function;

import static net.macck209.fishing101.Fishing101Initializer.MOD_ID;
import static net.macck209.fishing101.Fishing101Initializer.id;


public class ItemRegistry {
    private static final List<Item> fishingItems = new ArrayList<>() {};

    private static final ToolMaterial CLAW_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 92, 4.0F, 3.0F, 5, ItemTags.STONE_TOOL_MATERIALS);
    private static final ToolMaterial WRENCH_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 200, 5.0F, 3.0F, 15, ItemTags.STONE_TOOL_MATERIALS);
    private static final ArmorMaterial JELLY_MATERIAL = new ArmorMaterial(10, Util.make(new EnumMap<>(ArmorType.class), (map) -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 3);
                map.put(ArmorType.HELMET, 1);
                map.put(ArmorType.BODY, 2);
            }), 20, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, 0.0F,
            TagKey.create(Registries.ITEM, id("jelly_repair")),
            ResourceKey.create(EquipmentAssets.ROOT_ID, id("jelly")));

    //--------------------------------------------------
    // Raw fish
    public static final Item FISH_BONES = registerItem(
            "fish_bones",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64),
                    Items.BONE,
                    SimplePolymerItem.ORDINARY
            )
    );
    public static final Item ORDINARY_CARP = registerItem(
            "ordinary_carp",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.ORDINARY
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item DEFORMED_CARP = registerItem(
            "deformed_carp",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(-1F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 30 * 20))).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.DEFORMED
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item LUMINOUS_CARP = registerItem(
            "luminous_carp",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 30 * 20))).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.LUMINOUS
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ORDINARY_CATFISH = registerItem(
            "ordinary_catfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.ORDINARY
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item MUDDY_CATFISH = registerItem(
            "muddy_catfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.MUDDY
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item TROPICAL_CATFISH = registerItem(
            "tropical_catfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.TROPICAL
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item DIVINE_CATFISH = registerItem(
            "divine_catfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().alwaysEdible().nutrition(6).saturationModifier(1.5F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                    new MobEffectInstance(MobEffects.LEVITATION, 5 * 20,1),
                                    new MobEffectInstance(MobEffects.GLOWING, 5 * 20,1),
                                    new MobEffectInstance(MobEffects.RESISTANCE, 600 * 20,0),
                                    new MobEffectInstance(MobEffects.ABSORPTION, 300 * 20,4)
                            ))).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.DIVINE
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ORDINARY_MACKEREL = registerItem(
            "ordinary_mackerel",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.ORDINARY
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item LUMINOUS_MACKEREL = registerItem(
            "luminous_mackerel",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 30 * 20))).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.LUMINOUS
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item MANGROVE_JACK = registerItem(
            "mangrove_jack",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.MANGROVE
            )
            .returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ORDINARY_SHRIMP = registerItem(
            "ordinary_shrimp",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build()
                    ),
                    Items.TROPICAL_FISH,
                    SimplePolymerItem.ORDINARY
            )
    );
    public static final Item LUMINOUS_SHRIMP = registerItem(
            "luminous_shrimp",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 30 * 20))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.LUMINOUS
            )
    );
    public static final Item JELLYFISH = registerItem(
            "jellyfish",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(0.4F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 30 * 20),0.3F)).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.JELLYFISH
            )
    );
    public static final Item END_JELLYFISH = registerItem(
            "end_jellyfish",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(0.4F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.LEVITATION, 60 * 20,2),
                                            new MobEffectInstance(MobEffects.SPEED, 60 * 20,2)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.END
            )
    );
    public static final Item DIVINE_JELLYFISH = registerItem(
            "divine_jellyfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(1.5F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.LEVITATION, 5 * 20,1),
                                            new MobEffectInstance(MobEffects.GLOWING, 5 * 20,1),
                                            new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 600 * 20,1),
                                            new MobEffectInstance(MobEffects.CONDUIT_POWER, 600 * 20,1)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.DIVINE
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item ANGLERFISH = registerItem(
            "anglerfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 8 * 20))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ANGLER
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item RED_KOI = registerItem(
            "red_koi",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item YELLOW_KOI = registerItem(
            "yellow_koi",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item THUNDERFIN = registerItem(
            "thunderfin",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item STARFISH = registerItem(
            "starfish",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(0F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item END_STARFISH = registerItem(
            "end_starfish",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(1).saturationModifier(0F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.END
            )
    );
    public static final Item ICE_COD = registerItem(
            "ice_cod",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).isChilly().build()
    );
    public static final Item SOLARFISH = registerItem(
            "solarfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60 * 20,2))).build()
                    ),
            Items.TROPICAL_FISH, SimplePolymerItem.SOLAR
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item WITCHFISH = registerItem(
            "witchfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40 * 20,0,false,false))).build()
                    ),
            Items.TROPICAL_FISH, SimplePolymerItem.WITCH
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item FLOWERFISH = registerItem(
            "flowerfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.HEALTH_BOOST, 30 * 20,2),
                                            new MobEffectInstance(MobEffects.REGENERATION, 5 * 20,1)
                                    ))).build()
                    ),
            Items.TROPICAL_FISH, SimplePolymerItem.FLOWER
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item PANDAFISH = registerItem(
            "pandafish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 8 * 20))).build()
                    ),
            Items.TROPICAL_FISH, SimplePolymerItem.PANDA
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );


    //--------------------------------------------------
    // Cooked fish
    public static final Item SMOKED_ORDINARY_CARP = registerItem(
            "smoked_ordinary_carp",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(5).saturationModifier(0.8F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_DEFORMED_CARP = registerItem(
            "smoked_deformed_carp",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 30 * 20))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.DEFORMED
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_LUMINOUS_CARP = registerItem(
            "smoked_luminous_carp",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(5).saturationModifier(0.8F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.GLOWING, 300 * 20),
                                            new MobEffectInstance(MobEffects.NIGHT_VISION, 300 * 20)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.LUMINOUS
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_ORDINARY_CATFISH = registerItem(
            "smoked_catfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(7).saturationModifier(0.4F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_ORDINARY_MACKEREL = registerItem(
            "smoked_ordinary_mackerel",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.7F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_LUMINOUS_MACKEREL = registerItem(
            "smoked_luminous_mackerel",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(4).saturationModifier(0.7F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.GLOWING, 300 * 20),
                                            new MobEffectInstance(MobEffects.NIGHT_VISION, 300 * 20)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.LUMINOUS
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_MANGROVE_JACK = registerItem(
            "smoked_mangrove_jack",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.MANGROVE
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_ORDINARY_SHRIMP = registerItem(
            "smoked_ordinary_shrimp",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item SMOKED_LUMINOUS_SHRIMP = registerItem(
            "smoked_luminous_shrimp",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.GLOWING, 300 * 20),
                                            new MobEffectInstance(MobEffects.NIGHT_VISION, 300 * 20)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.LUMINOUS
            )
    );
    public static final Item SMOKED_ANGLERFISH = registerItem(
            "smoked_anglerfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 90 * 20))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ANGLER
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item CHARGED_THUNDERFIN = registerItem(
            "charged_thunderfin",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).alwaysEdible().build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.DIVINE
            ).isCharged().returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_KOI = registerItem(
            "smoked_koi",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(9).saturationModifier(1F).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_SOLARFISH = registerItem(
            "smoked_solarfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.ABSORPTION, 90 * 20,4),
                                            new MobEffectInstance(MobEffects.RESISTANCE, 90 * 20,1)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.SOLAR
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_WITCHFISH = registerItem(
            "smoked_witchfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 150 * 20,0,false,false))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.WITCH
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_FLOWERFISH = registerItem(
            "smoked_flowerfish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.HEALTH_BOOST, 90 * 20,3),
                                            new MobEffectInstance(MobEffects.REGENERATION, 60 * 20,0)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.FLOWER
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_PANDAFISH = registerItem(
            "smoked_pandafish",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.SLOW_FALLING, 150 * 20,0),
                                            new MobEffectInstance(MobEffects.JUMP_BOOST, 150 * 20,2)
                                    ))).build()
                    ),
                    Items.TROPICAL_FISH, SimplePolymerItem.PANDA
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item EEL = registerItem(
            "eel",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                            .food(
                                    new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).build(),
                                    Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                                            new MobEffectInstance(MobEffects.NAUSEA, 15 * 20,0),
                                            new MobEffectInstance(MobEffects.POISON, 30 * 20,1),
                                            new MobEffectInstance(MobEffects.HUNGER, 15 * 20,2)
                                    ))).build()
                            ),
                    Items.TROPICAL_FISH, SimplePolymerItem.DEFORMED
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );
    public static final Item SMOKED_EEL = registerItem(
            "smoked_eel",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                            .food(
                                    new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).build()
                            ),
                    Items.TROPICAL_FISH, SimplePolymerItem.ORDINARY
            ).returnItem(ItemRegistry.FISH_BONES).build()
    );


    //--------------------------------------------------
    // Food related items
    public static final Item DOUGH = registerItem(
            "dough",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(0).saturationModifier(0F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 8 * 20),0.3F)).build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item NOODLES = registerItem(
            "noodles",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(6).saturationModifier(0.5F).build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item CHICKEN_BROTH = registerItem(
            "chicken_broth",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(1F).alwaysEdible().build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            ).returnItem(Items.BOWL).build()
    );
    public static final Item SPAGHETTI_FRUTTI_DI_MARE = registerItem(
            "spaghetti_frutti_di_mare",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(10).saturationModifier(1.5F).alwaysEdible().build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            ).returnItem(Items.BOWL).build()
    );
    public static final Item TENTACLE = registerItem(
            "tentacle",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 8 * 20),0.2F)).build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item COOKED_TENTACLE = registerItem(
            "cooked_tentacle",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0F).build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item STARFISH_SHASHLIK = registerItem(
            "starfish_shashlik",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).alwaysEdible().build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            ).returnItem(Items.STICK).build()
    );
    public static final Item END_STARFISH_SHASHLIK = registerItem(
            "end_starfish_shashlik",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).alwaysEdible().build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 60 * 20))).build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.END
            ).returnItem(Items.STICK).build()
    );
    public static final Item PURPLE_PASTA = registerItem(
            "purple_pasta",
            (s) -> new PolymerFishItem.Builder(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(8).saturationModifier(0.5F).alwaysEdible().build()
                    ),
                    Items.CHORUS_FRUIT, SimplePolymerItem.ORDINARY
            ).isChorus().returnItem(Items.BOWL).build()
    );
    public static final Item RICE = registerItem(
            "rice",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0F).build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item SUSHI = registerItem(
            "sushi",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(6).saturationModifier(1F).build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LUCK, 300 * 20,0,false,false))).build()
                    ),
                    Items.COOKED_CHICKEN, SimplePolymerItem.ORDINARY
            )
    );
    public static final Item THICK_GOO = registerItem(
            "thick_goo",
            (s) -> new PolymerFishItem(
                    s.stacksTo(64)
                    .food(
                            new FoodProperties.Builder().nutrition(0).saturationModifier(0F).alwaysEdible().build(),
                            Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 16 * 20))).build()
                    ),
                    Items.DRIED_KELP, SimplePolymerItem.ORDINARY
            )
    );


    //--------------------------------------------------
    // Books & other items
    public static final Item FISH_BOOK = registerItem(
            "fish_book",
            (s) -> new PolymerFishBookItem(s.stacksTo(1)));
    public static final Item MEAL_BOOK = registerItem(
            "meal_book",
            (s) -> new PolymerMealBookItem(s.stacksTo(1)));
    // I feel like this is a terrible approach, but att. modifiers don't display _total_ dmg and attack speed
    // Also I'm just learning/experimenting with attribs and lore modifications
    public static final Item CRAB_CLAW = registerItem(
            "crab_claw",
            (s) -> new PolymerSwordItem.Builder(
                    CLAW_MATERIAL,
                    5,
                    0,
                    s.stacksTo(1).durability(Integer.MAX_VALUE).enchantable(5)
            ).addAttributeModif(Attributes.BLOCK_INTERACTION_RANGE,
                    new AttributeModifier(id("crab_claw_attribute_1"), 0.5f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND, ItemAttributeModifiers.Display.hidden()
            ).addAttributeModif(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(id("crab_claw_attribute_2"), 2f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND, ItemAttributeModifiers.Display.hidden() // +2f = 3 dmg total
            ).addAttributeModif(Attributes.ATTACK_SPEED,
                    new AttributeModifier(id("crab_claw_attribute_3"), -1f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND, ItemAttributeModifiers.Display.hidden() // -2.4f = the same as sword (1.6 hits/s)
            ).addLore(Component.translatable("item.fishing101.lore.also_shovel").withStyle(ChatFormatting.GRAY),
                    Component.literal(""),
                    Component.translatable("item.fishing101.lore.main_hand").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.fishing101.lore.attack_dmg_3").withStyle(ChatFormatting.DARK_GREEN),
                    Component.translatable("item.fishing101.lore.attack_speed_3").withStyle(ChatFormatting.DARK_GREEN),
                    Component.translatable("item.fishing101.lore.block_range_05").withStyle(ChatFormatting.BLUE)
            ).build());
    public static final Item CRAB_WRENCH = registerItem(
            "crab_wrench",
            (s) -> new PolymerSwordItem.Builder(
                    WRENCH_MATERIAL,
                    15,
                    0,
                    s.stacksTo(1).durability(Integer.MAX_VALUE).enchantable(12)
            ).addAttributeModif(Attributes.BLOCK_INTERACTION_RANGE,
                    new AttributeModifier(id("crab_wrench_attribute_1"), 2f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.OFFHAND, ItemAttributeModifiers.Display.hidden()
            ).addAttributeModif(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(id("crab_wrench_attribute_2"), 2f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND, ItemAttributeModifiers.Display.hidden()
            ).addAttributeModif(Attributes.ATTACK_SPEED,
                    new AttributeModifier(id("crab_wrench_attribute_3"), -1f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND, ItemAttributeModifiers.Display.hidden()
            ).addLore(Component.translatable("item.fishing101.lore.also_shovel").withStyle(ChatFormatting.GRAY),
                    Component.literal(""),
                    Component.translatable("item.fishing101.lore.main_hand").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.fishing101.lore.attack_dmg_3").withStyle(ChatFormatting.DARK_GREEN),
                    Component.translatable("item.fishing101.lore.attack_speed_3").withStyle(ChatFormatting.DARK_GREEN),
                    Component.translatable("item.fishing101.lore.off_hand").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.fishing101.lore.block_range_2").withStyle(ChatFormatting.BLUE)
            ).build());
    public static final Item JELLY_BOOTS = registerItem(
            "jelly_boots",
            (s) -> new PolymerArmorItem.Builder(
                    JELLY_MATERIAL, ArmorType.BOOTS, s.enchantable(20)
            ).addAttributeModif(Attributes.SAFE_FALL_DISTANCE,
                    new AttributeModifier(id("jelly_boots_attribute_1"), 3.0f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.FEET, ItemAttributeModifiers.Display.hidden()
            ).addAttributeModif(Attributes.JUMP_STRENGTH,
                    new AttributeModifier(id("jelly_boots_attribute_2"), 0.5f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    EquipmentSlotGroup.FEET, ItemAttributeModifiers.Display.hidden()
            ).addAttributeModif(Attributes.GRAVITY,
                    new AttributeModifier(id("jelly_boots_attribute_3"), -0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    EquipmentSlotGroup.FEET, ItemAttributeModifiers.Display.hidden()
            ).addAttributeModif(Attributes.ARMOR, // att. modifs overwrite armor, so this is necessary here
                    new AttributeModifier(id("jelly_boots_attribute_4"), 1.0f, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.FEET, ItemAttributeModifiers.Display.hidden()
            ).addLore(Component.literal(""),
                    Component.translatable("item.fishing101.lore.feet").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.fishing101.lore.armor_1").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.fishing101.lore.jump_height_2").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.fishing101.lore.safe_fall_3").withStyle(ChatFormatting.BLUE)
            ).build());


    //--------------------------------------------------
    public static Item registerItem(String path, Function<Item.Properties, Item> f) {
        var id = id(path);
        var item = f.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id)));
        Registry.register(BuiltInRegistries.ITEM, id, item);
        fishingItems.add(item);
        return item;
    }

    public static void register() {
        CreativeModeTab group = PolymerCreativeModeTabUtils.builder()
                .title(Component.translatable("item.fishing101.group_title"))
                .icon(ORDINARY_SHRIMP::getDefaultInstance)
                .displayItems((context, entries) -> fishingItems.forEach(entries::accept))
                .build();

        PolymerCreativeModeTabUtils.registerPolymerCreativeModeTab(id(MOD_ID), group);
    }
}
