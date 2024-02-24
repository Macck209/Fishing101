package net.macck209.fishing101.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.sgui.api.elements.BookElementBuilder;
import eu.pb4.sgui.api.gui.BookGui;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishBookItem extends Item implements PolymerItem {

    public FishBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("item.fishing101.fish_book");
    }
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.WRITTEN_BOOK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity player) {
            new IndexGui(player, hand).open();
            user.useBook(user.getStackInHand(hand), hand);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(user.getStackInHand(hand), true);
        }

        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            NbtCompound nbtCompound = stack.getNbt();
            String string = "Dr. Finn Benthos";
            if (!StringHelper.isEmpty(string)) {
                tooltip.add(Text.translatable("book.byAuthor", string).formatted(Formatting.GRAY));
            }

            assert nbtCompound != null;
            tooltip.add(Text.translatable("book.generation." + nbtCompound.getInt("generation")).formatted(Formatting.GRAY));
        }

    }


    public static void build(){
        var builder = new BookElementBuilder();
        FishGui.BOOKS.clear();

        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.intro"),
                Text.empty(),
                Text.translatable("books.fishing101.fish_book.intro")
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.carp"),
                Text.empty(),
                Text.translatable("books.fishing101.ordinary_carp").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.cypriniformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.freshwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.nocturnal"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.carp"),
                Text.empty(),
                Text.translatable("books.fishing101.deformed_carp").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.cypriniformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.freshwater"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.luminous_carp"),
                Text.empty(),
                Text.translatable("books.fishing101.luminous_carp").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.cypriniformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.freshwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.nocturnal")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.luminous"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.luminous_carp"),
                Text.empty(),
                Text.translatable("books.fishing101.ordinary_catfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.siluriformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.freshwater"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.muddy_catfish"),
                Text.empty(),
                Text.translatable("books.fishing101.muddy_catfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.siluriformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.swamp"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.tropical_catfish"),
                Text.empty(),
                Text.translatable("books.fishing101.tropical_catfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.siluriformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.tropical"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.divine_catfish"),
                Text.empty(),
                Text.translatable("item.fishing101.divine_catfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.siluriformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.freshwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.rain")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.ascension"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.mackerel"),
                Text.empty(),
                Text.translatable("books.fishing101.ordinary_mackerel").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.perciformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.saltwater"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.mackerel"),
                Text.empty(),
                Text.translatable("books.fishing101.luminous_mackerel").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.perciformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.saltwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.nocturnal")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.luminous"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.mangrove_jack"),
                Text.empty(),
                Text.translatable("books.fishing101.mangrove_jack").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.perciformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.mangrove"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.shrimp"),
                Text.empty(),
                Text.translatable("books.fishing101.ordinary_shrimp").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.decapoda"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.saltwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.thermophilic"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.shrimp"),
                Text.empty(),
                Text.translatable("books.fishing101.luminous_shrimp").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.decapoda"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.saltwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.thermophilic"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.nocturnal")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.luminous"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.jellyfish"),
                Text.empty(),
                Text.translatable("item.fishing101.jellyfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.semaeostomeae"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.saltwater")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.allergy"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.jellyfish"),
                Text.empty(),
                Text.translatable("item.fishing101.divine_jellyfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.semaeostomeae"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.saltwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.rain")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.ascension"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.anglerfish"),
                Text.empty(),
                Text.translatable("books.fishing101.anglerfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.lophiiformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.darkness")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.nausea"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.koi"),
                Text.empty(),
                Text.translatable("item.fishing101.red_koi").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.cypriniformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.cherry"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.koi"),
                Text.empty(),
                Text.translatable("item.fishing101.yellow_koi").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.cypriniformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.cherry"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.thunderfin"),
                Text.empty(),
                Text.translatable("item.fishing101.thunderfin").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.fulmeniformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.electric")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.charging"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.starfish"),
                Text.empty(),
                Text.translatable("item.fishing101.starfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.paxillosida"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.saltwater"))
                        .append(Text.translatable("books.fishing101.fish_book.distribution.beach")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.shashlik"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.ice_cod"),
                Text.empty(),
                Text.translatable("item.fishing101.ice_cod").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.gadiformes"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.glaciers")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.cold"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.solarfish"),
                Text.empty(),
                Text.translatable("books.fishing101.solarfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.unknown"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.high")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.funny"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.pandafish"),
                Text.empty(),
                Text.translatable("books.fishing101.pandafish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.unknown"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.bamboo")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.funny"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.witchfish"),
                Text.empty(),
                Text.translatable("books.fishing101.witchfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.unknown"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.mushroom")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.funny"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.flowerfish"),
                Text.empty(),
                Text.translatable("books.fishing101.flowerfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.unknown"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.flower")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.funny"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.end_jellyfish"),
                Text.empty(),
                Text.translatable("item.fishing101.end_jellyfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.semaeostomeae"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.unknown_1")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.allergy"))
        );
        builder.addPage(
                Text.translatable("books.fishing101.fish_book.date.end_jellyfish"),
                Text.empty(),
                Text.translatable("item.fishing101.end_starfish").formatted(Formatting.BOLD),
                Text.translatable("books.fishing101.fish_book.order.paxillosida"),
                Text.translatable("books.fishing101.fish_book.distribution")
                        .append(Text.translatable("books.fishing101.fish_book.distribution.unknown_2")),
                Text.translatable("books.fishing101.fish_book.special")
                        .append(Text.translatable("books.fishing101.fish_book.special.inedible"))
        );

        IndexGui.book = builder.asStack();
    }


    public static final class IndexGui extends BookGui {
        public static ItemStack book;
        private final ItemStack stack;
        private final Hand hand;

        public IndexGui(ServerPlayerEntity player, Hand hand) {
            super(player, book);
            this.stack = player.getStackInHand(hand);
            this.hand = hand;
            this.setPage(Math.min(stack.getOrCreateNbt().getInt("Page"), book.getNbt().getList("pages", NbtElement.STRING_TYPE).size() - 1));
        }

        @Override
        public void onOpen() {
            super.onOpen();
        }

        @Override
        public void onClose() {
            super.onClose();
        }

        @Override
        public void onTakeBookButton() {
            this.close();
        }

        @Override
        public void setPage(int page) {
            super.setPage(page);
            this.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1f, 1);

            if (this.stack == this.player.getStackInHand(hand)) {
                this.stack.getOrCreateNbt().putInt("Page", page);
            }
        }
    }
    public static final class FishGui extends BookGui {
        public static final Map<Identifier, ItemStack> BOOKS = new HashMap<>();
        private final Runnable runnable;
        private boolean forceReopen;

        public FishGui(ServerPlayerEntity player, Identifier identifier, boolean forceReopen, Runnable runnable) {
            super(player, BOOKS.get(identifier));
            this.runnable = runnable;
            this.forceReopen = forceReopen;
        }

        @Override
        public void setPage(int page) {
            super.setPage(page);
            this.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1f, 1);
        }

        @Override
        public void onTakeBookButton() {
            super.onTakeBookButton();
            this.close();
        }

        @Override
        public void onClose() {
            if (this.forceReopen) {
                this.open();
                this.forceReopen = false;
            } else {
                super.onClose();
                runnable.run();
            }
        }
    }
}
