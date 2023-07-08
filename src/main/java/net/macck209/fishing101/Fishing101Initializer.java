package net.macck209.fishing101;

import net.macck209.fishing101.items.FishBookItem;
import net.macck209.fishing101.items.MealBookItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.macck209.fishing101.registries.ItemRegistry;
import net.macck209.fishing101.registries.LootRegistry;
import net.macck209.fishing101.util.LootModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fishing101Initializer implements net.fabricmc.api.ModInitializer {
	public static final String MOD_ID = "fishing101";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemRegistry.register();
		LootRegistry.register();
		LootModifier.modifyLootTables();

		FishBookItem.build();
		MealBookItem.build();

		PolymerTextures.setup(MOD_ID);

		LOGGER.info("AAA!! Something bit my toe!");
	}
}
