package net.macck209.fishing101.items;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import eu.pb4.polymer.core.api.other.PolymerComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static net.macck209.fishing101.Fishing101Initializer.id;

public class Fishing101Components {
    public static ComponentType<Integer> BOOK_PAGE;

    public static void register() {
        BOOK_PAGE = register("book_page",
                ComponentType.<Integer>builder().codec(Codec.INT).build());
    }

    private static <T> ComponentType<T> register(String path, ComponentType<T> block) {
        PolymerComponent.registerDataComponent(block);
        return Registry.register(Registries.DATA_COMPONENT_TYPE, id(path), block);
    }
}
