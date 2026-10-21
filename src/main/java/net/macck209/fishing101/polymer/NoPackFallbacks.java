package net.macck209.fishing101.polymer;

import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import org.jetbrains.annotations.Nullable;

import static net.macck209.fishing101.Fishing101Initializer.MOD_ID;

// Clients without the resource pack have no textures for this mod's trim patterns, so worn
// armour would render pink-and-black. Jelly boots' own fallback lives in PolymerArmorItem.
public final class NoPackFallbacks {
    private NoPackFallbacks() {
    }

    public static void register() {
        // Vanilla armour carrying one of our trims must go through Polymer's conversion too.
        PolymerItemUtils.CONTEXT_ITEM_CHECK.register((stack, context) ->
                isOwnTrim(stack.get(DataComponents.TRIM)) && lacksPack(context));

        PolymerItemUtils.ITEM_MODIFICATION_EVENT.register((original, client, context) -> {
            if (isOwnTrim(client.get(DataComponents.TRIM)) && lacksPack(context)) {
                client.remove(DataComponents.TRIM);
            }
            return client;
        });
    }

    // Polymer passes a null context outside packet encoding, e.g. its creative-tab filter.
    public static boolean lacksPack(@Nullable PacketContext context) {
        return context != null && context.get(PacketContext.CONNECTION) != null
                && !PolymerResourcePackUtils.hasMainPack(context);
    }

    private static boolean isOwnTrim(@Nullable ArmorTrim trim) {
        return trim != null && trim.pattern().unwrapKey().map(NoPackFallbacks::isOwn).orElse(false);
    }

    private static boolean isOwn(ResourceKey<?> key) {
        return key.identifier().getNamespace().equals(MOD_ID);
    }
}
