package net.macck209.fishing101;

import net.macck209.fishing101.items.Fishing101Components;
import net.macck209.fishing101.items.PolymerFishBookItem;
import net.macck209.fishing101.items.PolymerMealBookItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.macck209.fishing101.registries.ItemRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fishing101Initializer implements net.fabricmc.api.ModInitializer {
	public static final String MOD_ID = "fishing101";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		PolymerTextures.setup(MOD_ID);

		Fishing101Components.register();
		ItemRegistry.register();
		PolymerFishBookItem.build();
		PolymerMealBookItem.build();
		
		LOGGER.info("AAA!! Something bit my toe!");
	}
}
