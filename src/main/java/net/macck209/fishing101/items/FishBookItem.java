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

    public FishBookItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("Ichthyologist's Journal");
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
                //Text.translatable("books.fishing101.fish_book.intro")
                Text.literal("   October 12, 1878\n"),
                Text.literal("My name is Finn Benthos. " +
                        "The pages of this journal shall document the intriguing marine creatures I encounter throughout my voyage into the unknown. " +
                        "My aim is to unravel the mysteries concealed within the watery realm.")
        );
        builder.addPage(
                Text.literal("   October 13, 1878\n\n"),
                Text.literal("Carp\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Cypriniformes\n"+
                        "- Distribution: Freshwater\n"+
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   October 13, 1878\n\n"),
                Text.literal("Deformed Carp\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Cypriniformes\n" +
                        "- Distribution: Freshwater\n" +
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   October 14, 1878\n\n"),
                Text.literal("Luminous Carp\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Cypriniformes\n" +
                        "- Distribution: Freshwater; Nocturnal\n" +
                        "- Can be smoked\n" +
                        "- Special effects: Luminousness")
        );
        builder.addPage(
                Text.literal("   October 14, 1878\n\n"),
                Text.literal("Catfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Siluriformes\n" +
                        "- Distribution: Freshwater\n"+
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   October 16, 1878\n\n"),
                Text.literal("Muddy Catfish\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Siluriformes\n" +
                        "- Distribution: Murky swamp waters\n" +
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   October 24, 1878\n\n"),
                Text.literal("Tropical Catfish\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Siluriformes\n" +
                        "- Distribution: Tropical waters\n" +
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   November 8, 1878\n\n"),
                Text.literal("Divine Catfish\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Siluriformes\n" +
                        "- Distribution: Freshwater; rare, but much more common when raining\n" +
                        "- Can be smoked\n" +
                        "- Special effects: Ascension")
        );
        builder.addPage(
                Text.literal("   November 22, 1878\n\n"),
                Text.literal("Mackerel\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Perciformes\n" +
                        "- Distribution: Saltwater\n"+
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   November 27, 1878\n\n"),
                Text.literal("Luminous Mackerel\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Perciformes\n" +
                        "- Distribution: Saltwater; Nocturnal\n" +
                        "- Can be smoked\n" +
                        "- Special effects: Luminousness")
        );
        builder.addPage(
                Text.literal("   December 1, 1878\n\n"),
                Text.literal("Mangrove Jack\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Perciformes\n" +
                        "- Distribution: Mangrove waters\n" +
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   December 7, 1878\n\n"),
                Text.literal("Shrimp\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Decapoda\n" +
                        "- Distribution: Thermophilic; Saltwater\n"+
                        "- Can be smoked")
        );
        builder.addPage(
                Text.literal("   December 14, 1878\n\n"),
                Text.literal("Luminous Shrimp\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Decapoda\n" +
                        "- Distribution: thermophilic; Saltwater; Nocturnal\n"+
                        "- Can be smoked\n"+
                        "- Special effects: Luminousness")
        );
        builder.addPage(
                Text.literal("   December 15, 1878\n\n"),
                Text.literal("Jellyfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Semaeostomeae\n" +
                        "- Distribution: Saltwater\n"+
                        "- Potential allergic reaction")
        );
        builder.addPage(
                Text.literal("   January 7, 1879\n\n"),
                Text.literal("Divine Jellyfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Semaeostomeae\n" +
                        "- Distribution: Saltwater; rare, but much more common when raining\n"+
                        "- Special effects: Ascension")
        );
        builder.addPage(
                Text.literal("   January 9, 1879\n\n"),
                Text.literal("Anglerfish\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Lophiiformes\n" +
                        "- Distribution: Absolute darkness in deepest of caves; more common in the Ancient Cities\n" +
                        "- Can be smoked\n" +
                        "- Often causes nausea")
        );
        builder.addPage(
                Text.literal("   March 30, 1879\n\n"),
                Text.literal("Red Koi\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Cypriniformes\n" +
                        "- Distribution: Cherry groves\n" +
                        "- Can be smoked" )
        );
        builder.addPage(
                Text.literal("   April 2, 1879\n\n"),
                Text.literal("Yellow Koi\n").formatted(Formatting.BOLD),
                Text.literal( "- Order: Cypriniformes\n" +
                        "- Distribution: Cherry groves\n" +
                        "- Can be smoked" )
        );
        builder.addPage(
                Text.literal("   June 19, 1879\n\n"),
                Text.literal("Thunderfin\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Fulmeniformes\n" +
                        "- Distribution: Electrified waters\n" +
                        "- It appears to have some unusual attributes when charged with copper" )
        );
        builder.addPage(
                Text.literal("   July 25, 1879\n\n"),
                Text.literal("Starfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Paxillosida\n" +
                        "- Distribution: Warm oceans and beaches\n" +
                        "- Makes a great shashlik" )
        );
        builder.addPage(
                Text.literal("   July 13, 1879\n\n"),
                Text.literal("Ice Cod\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Gadiformes\n" +
                        "- Distribution: Found under glaciers\n" +
                        "- It's REALLY cold" )
        );
        builder.addPage(
                Text.literal("   July 19, 1879\n\n"),
                Text.literal("Solarfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Unknown\n" +
                        "- Distribution: Found on sunny days, in the highest sections of the country\n" +
                        "- Tastes funny" )
        );
        builder.addPage(
                Text.literal("   August 23, 1879\n\n"),
                Text.literal("Pandafish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Unknown\n" +
                        "- Distribution: Found in bamboo jungle\n" +
                        "- Tastes funny" )
        );
        builder.addPage(
                Text.literal("   September 15, 1879\n\n"),
                Text.literal("Witchfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Unknown\n" +
                        "- Distribution: Found in mushroom populated areas\n" +
                        "- Tastes funny" )
        );
        builder.addPage(
                Text.literal("   November 9, 1879\n\n"),
                Text.literal("Flowerfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Unknown\n" +
                        "- Distribution: Found in flower forests\n" +
                        "- Tastes funny" )
        );
        builder.addPage(
                Text.literal("   July XX, 19XX\n\n"),
                Text.literal("End Jellyfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Semaeostomeae\n" +
                        "- Distribution: Good question. Where, the heck, am I?\n"+
                        "- Potential allergic reaction")
        );
        builder.addPage(
                Text.literal("   July XX, 19XX\n\n"),
                Text.literal("End Starfish\n").formatted(Formatting.BOLD),
                Text.literal("- Order: Paxillosida\n" +
                        "- Distribution: I'm starting to get worried...\n" +
                        "- I don't know if it's edible, but I'm not risking it" )
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
