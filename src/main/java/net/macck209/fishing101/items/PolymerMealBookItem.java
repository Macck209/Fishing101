package net.macck209.fishing101.items;

import eu.pb4.sgui.api.elements.BookElementBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class PolymerMealBookItem extends PolymerBookItem {
    public PolymerMealBookItem(Properties settings) {
        super(settings, "item.fishing101.meal_book_subtitle");
    }

    @Override
    protected void addPages(BookElementBuilder builder) {
        builder.addPage(
                Component.translatable("books.fishing101.meal_book.intro.title").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.intro.text")
        );
        builder.addPage(
                Component.translatable("item.minecraft.bone_meal").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.bone_meal.text")
        );
        builder.addPage(
                Component.translatable("item.minecraft.slime_ball").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.fishing101.thick_goo")),
                Component.literal( "- ").append(Component.translatable("item.minecraft.green_dye"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.dough").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.minecraft.wheat")),
                Component.literal( "- ").append(Component.translatable("item.minecraft.egg"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.noodles").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.noodles.text")
        );
        builder.addPage(
                Component.translatable("item.fishing101.rice").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.obtaining").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.rice.text")
        );
        builder.addPage(
                Component.translatable("item.fishing101.tentacle").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.obtaining").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.tentacle.text")
        );
        builder.addPage(
                Component.translatable("item.fishing101.cooked_tentacle").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.cooked_tentacle.text")
        );
        builder.addPage(
                Component.translatable("item.fishing101.chicken_broth").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.minecraft.bowl")),
                Component.literal( "- ").append(Component.translatable("item.fishing101.noodles")),
                Component.literal( "- ").append(Component.translatable("books.fishing101.meal_book.chickens.text"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.purple_pasta").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.minecraft.bowl")),
                Component.literal( "- ").append(Component.translatable("item.fishing101.noodles")),
                Component.literal( "- ").append(Component.translatable("item.minecraft.cooked_porkchop")),
                Component.literal( "- ").append(Component.translatable("item.minecraft.chorus_fruit"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.spaghetti_frutti_di_mare").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.minecraft.bowl")),
                Component.literal( "- ").append(Component.translatable("item.fishing101.noodles")),
                Component.literal( "- ").append(Component.translatable("item.fishing101.cooked_tentacle")),
                Component.literal( "- ").append(Component.translatable("item.fishing101.smoked_ordinary_shrimp"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.starfish_shashlik").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.minecraft.stick")),
                Component.literal( "- ").append(Component.translatable("item.fishing101.starfish"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.end_starfish_shashlik").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.minecraft.stick")),
                Component.literal( "- ").append(Component.translatable("item.fishing101.end_starfish"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.sushi").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.literal( "- ").append(Component.translatable("item.fishing101.rice")),
                Component.literal( "- ").append(Component.translatable("block.minecraft.kelp")),
                Component.literal( "- ").append(Component.translatable("item.minecraft.salmon"))
        );
        builder.addPage(
                Component.translatable("item.fishing101.thick_goo").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.thick_goo.text")
        );
        builder.addPage(
                Component.translatable("item.fishing101.charged_thunderfin").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.recipe").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.charged_thunderfin.text")
        );
        builder.addPage(
                Component.translatable("item.fishing101.crab_claw").withStyle(ChatFormatting.BOLD,ChatFormatting.GOLD),
                Component.translatable("books.fishing101.meal_book.obtaining").withStyle(ChatFormatting.UNDERLINE),
                Component.empty(),
                Component.translatable("books.fishing101.meal_book.crab_claw.text")
        );
    }
}
