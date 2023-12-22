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

public class MealBookItem extends Item implements PolymerItem {

    public MealBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("Johnny's Cook Book");
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
            String string = "Johnny Gourmet";
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
                //Text.translatable("books.fishing101.meal_book.intro") <- todo in future
                Text.literal("  Introduction\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal( "Welcome to my culinary odyssey! " +
                        "Join me in unraveling the secrets of exquisite flavors as we delve into the art of cooking. " +
                        "Let's create delicious masterpieces together. " +
                        "Bon appétit!")
        );
        builder.addPage(
                Text.literal("Bone Meal\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal( "Made from Fish Bones")
        );
        builder.addPage(
                Text.literal("Slimeball\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal( "- Thick Goo\n" +
                        "- Green Dye")
        );
        builder.addPage(
                Text.literal("Dough\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal( "- Wheat\n"+
                        "- Egg")
        );
        builder.addPage(
                Text.literal("Noodles\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal("Cook a Dough in a Furnace")
        );
        builder.addPage(
                Text.literal("Rice\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Obtaining\n").formatted(Formatting.UNDERLINE),
                Text.literal( "Found among Grass in Cherry Groves")
        );
        builder.addPage(
                Text.literal("Tentacle\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Obtaining\n").formatted(Formatting.UNDERLINE),
                Text.literal("Chop 'em, those Squids!")
        );
        builder.addPage(
                Text.literal("Cooked Tentacle\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal("Cook a Tentacle in a Furnace")
        );
        builder.addPage(
                Text.literal("Chicken Broth\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal( "- Bowl\n" +
                        "- Noodles\n"+
                        "- Raw Chicken")
        );
        builder.addPage(
                Text.literal("Purple Pasta\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal( "- Bowl\n" +
                        "- Noodles\n"+
                        "- Cooked Porkchop\n"+
                        "- Chorus Fruit")
        );
        builder.addPage(
                Text.literal("Spaghetti Frutti di Mare\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal( "- Bowl\n" +
                        "- Noodles\n"+
                        "- Cooked Tentacle\n"+
                        "- Any Smoked Shrimp")
        );
        builder.addPage(
                Text.literal("Starfish Shashlik\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal("- Starfish\n"+
                        "- Stick")
        );
        builder.addPage(
                Text.literal("End Starfish Shashlik\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal("- End Starfish\n"+
                        "- Stick")
        );
        builder.addPage(
                Text.literal("Sushi\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal("- Rice\n" +
                        "- Kelp\n"+
                        "- Raw Salmon")
        );
        builder.addPage(
                Text.literal("Thick Goo\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal("Cook a Jellyfish or an End Jellyfish in a Furnace or a Campfire")
        );
        builder.addPage(
                Text.literal("Charged Thunderfin\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Recipe\n").formatted(Formatting.UNDERLINE),
                Text.literal("Charge a Thunderfin in a Smithing Table with 2 Copper Blocks")
        );
        builder.addPage(
                Text.literal("Crab Claw\n\n").formatted(Formatting.BOLD,Formatting.GOLD),
                Text.literal("Obtaining\n").formatted(Formatting.UNDERLINE),
                Text.literal("Treasure fishing loot collected near beaches")
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
