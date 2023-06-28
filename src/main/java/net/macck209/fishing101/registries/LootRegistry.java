package net.macck209.fishing101.registries;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.TimeCheckLootCondition;
import net.minecraft.loot.condition.WeatherCheckLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;

public class LootRegistry {
    private static final Identifier FISHING_FISH_LOOT_TABLE_ID = LootTables.FISHING_FISH_GAMEPLAY;
    public static final LootCondition.Builder NEEDS_OCEAN_BIOME;
    public static final LootCondition.Builder NOT_OCEAN_BIOME;
    public static final LootCondition.Builder NEEDS_SWAMP_BIOME;
    public static final LootCondition.Builder NEEDS_JUNGLE_BIOME;
    public static final LootCondition.Builder NEEDS_NIGHT;
    public static final LootCondition.Builder NEEDS_MANGROVE;
    public static final LootCondition.Builder NEEDS_JAPAN;
    public static final LootCondition.Builder NEEDS_BEACH;
    public static final LootCondition.Builder NEEDS_DEEP_DARK;
    public static final LootCondition.Builder ABOVE_Y90;
    public static final LootCondition.Builder IS_RAINING;
    public static final LootCondition.Builder IS_STORMY;

    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && FISHING_FISH_LOOT_TABLE_ID.equals(id)) {
                tableBuilder.modifyPools(tb ->{
                    tb
                    .with(ItemEntry.builder(Items.COD)
                            .weight(4000-60))
                    .with(ItemEntry.builder(Items.SALMON)
                            .weight(2000-25))
                    .with(ItemEntry.builder(Items.PUFFERFISH)
                            .weight(240-2))
                    .with(ItemEntry.builder(Items.TROPICAL_FISH)
                            .weight(600-13))

                    .with(ItemEntry.builder(Items.SALMON)
                            .conditionally(ABOVE_Y90)
                            .weight(3000))
                    .with(ItemEntry.builder(Items.TROPICAL_FISH)
                            .conditionally(NEEDS_JUNGLE_BIOME)
                            .weight(1400))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_CARP)
                            .conditionally(NOT_OCEAN_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.DEFORMED_CARP)
                            .conditionally(NOT_OCEAN_BIOME)
                            .weight(800))
                    .with(ItemEntry.builder(ItemRegistry.LUMINOUS_CARP)
                            .conditionally(NOT_OCEAN_BIOME)
                            .conditionally(NEEDS_NIGHT)
                            .weight(240))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_CATFISH)
                            .conditionally(NOT_OCEAN_BIOME)
                            .conditionally(NEEDS_SWAMP_BIOME.invert())
                            .conditionally(NEEDS_JUNGLE_BIOME.invert())
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.MUDDY_CATFISH)
                            .conditionally(NEEDS_SWAMP_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.TROPICAL_CATFISH)
                            .conditionally(NEEDS_JUNGLE_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.DIVINE_CATFISH)
                            .conditionally(NOT_OCEAN_BIOME)
                            .weight(40))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_MACKEREL)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.LUMINOUS_MACKEREL)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .conditionally(NEEDS_NIGHT)
                            .weight(240))

                    .with(ItemEntry.builder(ItemRegistry.MANGROVE_JACK)
                            .conditionally(NEEDS_MANGROVE)
                            .weight((1000)))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_SHRIMP)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .weight((2000)))
                    .with(ItemEntry.builder(ItemRegistry.LUMINOUS_SHRIMP)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .conditionally(NEEDS_NIGHT)
                            .weight((240)))

                    .with(ItemEntry.builder(ItemRegistry.JELLYFISH)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .weight((600)))

                    // Rarer fish are more common when it's raining
                    .with(ItemEntry.builder(Items.PUFFERFISH)
                            .conditionally(IS_RAINING)
                            .weight(560))
                    .with(ItemEntry.builder(ItemRegistry.DIVINE_CATFISH)
                            .conditionally(NOT_OCEAN_BIOME)
                            .conditionally(IS_RAINING)
                            .weight(60))
                ;});
            }
        });
    }


    static {
        // Note: Fish occurrence isn't super realistic. I'm more focused on making the mod fun. Feel free to modify stuff on you own tho
        NEEDS_OCEAN_BIOME = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.OCEAN))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.COLD_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_COLD_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_FROZEN_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_LUKEWARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.LUKEWARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.WARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BEACH)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_BEACH)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.STONY_SHORE)));
        NOT_OCEAN_BIOME  = NEEDS_OCEAN_BIOME.invert();
        NEEDS_SWAMP_BIOME = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SWAMP))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MANGROVE_SWAMP)));
        NEEDS_JUNGLE_BIOME = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.JUNGLE))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BAMBOO_JUNGLE)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SPARSE_JUNGLE)));
        NEEDS_NIGHT = TimeCheckLootCondition.create(BoundedIntUnaryOperator.create(12000,24000));
        NEEDS_MANGROVE = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MANGROVE_SWAMP));
        NEEDS_JAPAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.CHERRY_GROVE))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MEADOW)));
        NEEDS_BEACH = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BEACH))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_BEACH)));
        NEEDS_DEEP_DARK = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_DARK));
        ABOVE_Y90 = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().y(NumberRange.FloatRange.atLeast(90)));
        IS_RAINING = WeatherCheckLootCondition.create().raining(true).or(WeatherCheckLootCondition.create().thundering(true));
        IS_STORMY = WeatherCheckLootCondition.create().thundering(true);
    }
}
