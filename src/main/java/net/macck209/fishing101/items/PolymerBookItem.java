package net.macck209.fishing101.items;

import eu.pb4.sgui.api.elements.BookElementBuilder;
import eu.pb4.sgui.api.gui.BookGui;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.macck209.fishing101.items.polymer.PolymerAutoItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

// A book read through sgui's book screen that remembers its last page per stack.
public abstract class PolymerBookItem extends Item implements PolymerAutoItem {
    private final String subtitleKey;
    private ItemStack book;

    protected PolymerBookItem(Properties settings, String subtitleKey) {
        super(settings);
        this.subtitleKey = subtitleKey;
    }

    protected abstract void addPages(BookElementBuilder builder);

    // Built on first use: item components are not bound yet during onInitialize.
    private ItemStack book() {
        if (book == null) {
            var builder = new BookElementBuilder();
            addPages(builder);
            book = builder.asStack();
        }
        return book;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.WRITTEN_BOOK;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> tooltip, TooltipFlag type) {
        tooltip.accept(Component.translatable(subtitleKey).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        if (user instanceof ServerPlayer player) {
            new IndexGui(player, hand, book()).open();
            user.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.SUCCESS;
    }

    private static final class IndexGui extends BookGui {
        private final ItemStack shared;
        private final ItemStack stack;
        private final InteractionHand hand;
        private final int lastPage;

        IndexGui(ServerPlayer player, InteractionHand hand, ItemStack book) {
            super(player, book);
            this.shared = book;
            this.stack = player.getItemInHand(hand);
            this.hand = hand;
            this.lastPage = Math.max(0, book.get(DataComponents.WRITTEN_BOOK_CONTENT).getPages(false).size() - 1);
            this.setPage(stack.getOrDefault(Fishing101Components.BOOK_PAGE, 0));
        }

        @Override
        public void onTakeBookButton() {
            this.close();
        }

        @Override
        public void setPage(int page) {
            page = Math.clamp(page, 0, lastPage);
            super.setPage(page);
            this.player.connection.send(new ClientboundSoundPacket(
                    BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.BOOK_PAGE_TURN), SoundSource.BLOCKS,
                    this.player.getX(), this.player.getY(), this.player.getZ(), 1f, 1, this.player.getRandom().nextLong()));

            if (this.book == shared && this.stack == this.player.getItemInHand(hand)) {
                this.stack.set(Fishing101Components.BOOK_PAGE, page);
            }
        }
    }
}
