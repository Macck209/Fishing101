package net.macck209.fishing101.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.sgui.api.elements.BookElementBuilder;
import eu.pb4.sgui.api.gui.BookGui;
import net.macck209.fishing101.items.polymer.PolymerAutoItem;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.HashMap;
import java.util.Map;

public class PolymerMealBookItem extends Item implements PolymerAutoItem {
    public PolymerMealBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context){
        return PolymerTextures.MODELS.get(this);
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("item.fishing101.meal_book");
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.WRITTEN_BOOK;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity player) {
            new IndexGui(player, hand).open();
            user.useBook(user.getStackInHand(hand), hand);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return ActionResult.SUCCESS_SERVER;
        }
        return ActionResult.SUCCESS;
    }


    public static void build(){
        var builder = new BookElementBuilder();
        FishGui.BOOKS.clear();

        builder.addPage(
                Text.translatable("books.fishing101.meal_book.intro.title").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.intro.text")
        );
        builder.addPage(
                Text.translatable("item.minecraft.bone_meal").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.bone_meal.text")
        );
        builder.addPage(
                Text.translatable("item.minecraft.slime_ball").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.fishing101.thick_goo")),
                Text.literal( "- ").append(Text.translatable("item.minecraft.green_dye"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.dough").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.minecraft.wheat")),
                Text.literal( "- ").append(Text.translatable("item.minecraft.egg"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.noodles").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.noodles.text")
        );
        builder.addPage(
                Text.translatable("item.fishing101.rice").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.obtaining").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.rice.text")
        );
        builder.addPage(
                Text.translatable("item.fishing101.tentacle").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.obtaining").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.tentacle.text")
        );
        builder.addPage(
                Text.translatable("item.fishing101.cooked_tentacle").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.cooked_tentacle.text")
        );
        builder.addPage(
                Text.translatable("item.fishing101.chicken_broth").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.minecraft.bowl")),
                Text.literal( "- ").append(Text.translatable("item.fishing101.noodles")),
                Text.literal( "- ").append(Text.translatable("books.fishing101.meal_book.chickens.text"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.purple_pasta").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.minecraft.bowl")),
                Text.literal( "- ").append(Text.translatable("item.fishing101.noodles")),
                Text.literal( "- ").append(Text.translatable("item.minecraft.cooked_porkchop")),
                Text.literal( "- ").append(Text.translatable("item.minecraft.chorus_fruit"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.spaghetti_frutti_di_mare").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.minecraft.bowl")),
                Text.literal( "- ").append(Text.translatable("item.fishing101.noodles")),
                Text.literal( "- ").append(Text.translatable("item.fishing101.cooked_tentacle")),
                Text.literal( "- ").append(Text.translatable("item.fishing101.smoked_ordinary_shrimp"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.starfish_shashlik").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.minecraft.stick")),
                Text.literal( "- ").append(Text.translatable("item.fishing101.starfish"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.end_starfish_shashlik").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.minecraft.stick")),
                Text.literal( "- ").append(Text.translatable("item.fishing101.end_starfish"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.sushi").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.literal( "- ").append(Text.translatable("item.fishing101.rice")),
                Text.literal( "- ").append(Text.translatable("block.minecraft.kelp")),
                Text.literal( "- ").append(Text.translatable("item.minecraft.salmon"))
        );
        builder.addPage(
                Text.translatable("item.fishing101.thick_goo").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.thick_goo.text")
        );
        builder.addPage(
                Text.translatable("item.fishing101.charged_thunderfin").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.recipe").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.charged_thunderfin.text")
        );
        builder.addPage(
                Text.translatable("item.fishing101.crab_claw").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.translatable("books.fishing101.meal_book.obtaining").formatted(Formatting.UNDERLINE),
                Text.empty(),
                Text.translatable("books.fishing101.meal_book.crab_claw.text")
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
            this.setPage(Math.min(stack.getOrDefault(Fishing101Components.BOOK_PAGE, 0),
                    book.get(DataComponentTypes.WRITTEN_BOOK_CONTENT).getPages(false).size()));
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
            this.player.playSoundToPlayer(SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1f, 1);

            if (this.book == book && this.stack == this.player.getStackInHand(hand)) {
                this.stack.set(Fishing101Components.BOOK_PAGE, page);
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
