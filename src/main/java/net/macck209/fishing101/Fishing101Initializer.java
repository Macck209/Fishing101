package net.macck209.fishing101;

import net.macck209.fishing101.items.Fishing101Components;
import net.macck209.fishing101.loot.Fishing101Loot;
import net.macck209.fishing101.polymer.NoPackFallbacks;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.macck209.fishing101.registries.ItemRegistry;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fishing101Initializer implements net.fabricmc.api.ModInitializer {
	public static final String MOD_ID = "fishing101";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		PolymerTextures.setup(MOD_ID);
		NoPackFallbacks.register();

		Fishing101Components.register();
		ItemRegistry.register();
		Fishing101Loot.register();

		LOGGER.info("AAA!! Something bit my toe!");
	}
}
