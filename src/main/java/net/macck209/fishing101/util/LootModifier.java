package net.macck209.fishing101.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.macck209.fishing101.registries.ItemRegistry;
import net.macck209.fishing101.registries.LootRegistry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootModifier {
    private static final Identifier GRASS_BLOCK_ID
            = new Identifier("assets/minecraft", "blocks/grass");
    private static final Identifier SQUID_ID
            = new Identifier("assets/minecraft", "entities/squid");
    private static final Identifier GLOW_SQUID_ID
            = new Identifier("assets/minecraft", "entities/glow_squid");
    private static final Identifier VILLAGE_FISHER_ID
            = new Identifier("assets/minecraft", "chests/village/village_fisher");
    private static final Identifier HERO_FISHER_ID
            = new Identifier("assets/minecraft", "gameplay/hero_of_the_village/fisherman_gift");
    private static final Identifier HERO_FARMER_ID
            = new Identifier("assets/minecraft", "gameplay/hero_of_the_village/farmer_gift");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(GRASS_BLOCK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .conditionally(LootRegistry.NEEDS_JAPAN)
                        .with(ItemEntry.builder(ItemRegistry.RICE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(SQUID_ID.equals(id) || GLOW_SQUID_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.05f,0.02f))
                        .with(ItemEntry.builder(ItemRegistry.TENTACLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(VILLAGE_FISHER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ItemRegistry.FISH_BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(HERO_FISHER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ItemRegistry.FISH_BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(HERO_FARMER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ItemRegistry.MEAL_BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}

