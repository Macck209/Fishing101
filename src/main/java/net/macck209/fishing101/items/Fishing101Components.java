package net.macck209.fishing101.items;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import eu.pb4.polymer.core.api.other.PolymerComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

import static net.macck209.fishing101.Fishing101Initializer.id;

public class Fishing101Components {
    public static DataComponentType<Integer> BOOK_PAGE;

    public static void register() {
        BOOK_PAGE = register("book_page",
                DataComponentType.<Integer>builder().persistent(Codec.INT).build());
    }

    private static <T> DataComponentType<T> register(String path, DataComponentType<T> block) {
        PolymerComponent.registerDataComponent(block);
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, id(path), block);
    }
}
