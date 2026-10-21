package net.macck209.fishing101.loot;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.macck209.fishing101.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;

import static net.macck209.fishing101.Fishing101Initializer.id;

public final class Fishing101Loot {
    // Before other mods' listeners, so edits to existing pools touch vanilla's pools only.
    private static final Identifier VANILLA_POOLS = id("vanilla_pools");
    // After them, so other mods' modifyPools calls never reach into our pools.
    private static final Identifier OWN_POOLS = id("own_pools");

    private static final ResourceKey<LootTable> SQUID = EntityTypes.SQUID.getDefaultLootTable().orElseThrow();
    private static final ResourceKey<LootTable> GLOW_SQUID = EntityTypes.GLOW_SQUID.getDefaultLootTable().orElseThrow();
    private static final ResourceKey<LootTable> SHORT_GRASS = Blocks.SHORT_GRASS.getLootTable().orElseThrow();

    private Fishing101Loot() {
    }

    public static void register() {
        LootTableEvents.MODIFY.addPhaseOrdering(VANILLA_POOLS, Event.DEFAULT_PHASE);
        LootTableEvents.MODIFY.addPhaseOrdering(Event.DEFAULT_PHASE, OWN_POOLS);

        LootTableEvents.MODIFY.register(VANILLA_POOLS, (key, table, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }
            if (key.equals(BuiltInLootTables.FISHING)) {
                var handled = registries.getOrThrow(ResourceKey.create(Registries.PREDICATE, id("fishing/handled_dimension")));
                table.modifyPools(pool -> pool.when(InvertedLootItemCondition.invert(handled)));
            } else if (key.equals(BuiltInLootTables.FARMER_GIFT)) {
                table.modifyPools(pool -> pool.add(LootItem.lootTableItem(ItemRegistry.MEAL_BOOK)));
            } else if (key.equals(BuiltInLootTables.FISHERMAN_GIFT)) {
                table.modifyPools(pool -> pool.add(LootItem.lootTableItem(ItemRegistry.FISH_BOOK)));
            }
        });

        LootTableEvents.MODIFY.register(OWN_POOLS, (key, table, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }
            if (key.equals(BuiltInLootTables.FISHING)) {
                table.pool(nested(registries, "gameplay/fishing"));
            } else if (key.equals(SQUID) || key.equals(GLOW_SQUID)) {
                table.pool(nested(registries, "entities/tentacle"));
            } else if (key.equals(SHORT_GRASS)) {
                table.pool(nested(registries, "blocks/short_grass_rice"));
            }
        });
    }

    private static LootPool nested(HolderLookup.Provider registries, String path) {
        var table = registries.getOrThrow(ResourceKey.create(Registries.LOOT_TABLE, id(path)));
        return LootPool.lootPool().add(NestedLootTable.lootTableReference(table)).build();
    }
}
