package net.macck209.fishing101.items.polymer;

import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class PolymerSwordItem extends Item implements PolymerAutoItem {
    private List<Component> tooltipLines;

    public PolymerSwordItem(ToolMaterial toolMaterial, int enchantability, float attackSpeed, Properties settings, ItemAttributeModifiers attributes, List<Component> tooltipText) {
        super(toolMaterial
                .applyToolProperties(settings, BlockTags.MINEABLE_WITH_SHOVEL, 0, attackSpeed, 0)
                .enchantable(enchantability).attributes(attributes)
        );
        this.tooltipLines = tooltipText;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.IRON_SWORD;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> tooltip, TooltipFlag type) {
        if (tooltipLines != null) {
            for (Component line:tooltipLines) {
                tooltip.accept(line);
            }
        }
    }

    public static class Builder {
        private final ToolMaterial toolMaterial;
        private final int enchantability;
        private final float attackSpeed;

        private Properties settings;
        private ItemAttributeModifiers.Builder attributeBuilder = ItemAttributeModifiers.builder();
        private List<Component> loreLines = new ArrayList<>();

        public Builder(ToolMaterial toolMaterial, int enchantability, float attackSpeed, Properties settings) {
            this.toolMaterial = toolMaterial;
            this.enchantability = enchantability;
            this.attackSpeed = attackSpeed;
            this.settings = settings;
        }

        public Builder addAttributeModif(Holder<Attribute> attrType, AttributeModifier modifValue, EquipmentSlotGroup modifSlot, ItemAttributeModifiers.Display modifDisplay) {
            this.attributeBuilder.add(attrType, modifValue, modifSlot, modifDisplay);
            return this;
        }

        public Builder addLore(Component... lines) {
            this.loreLines.addAll(Arrays.asList(lines));
            return this;
        }

        public PolymerSwordItem build() {
            ItemAttributeModifiers attributes = attributeBuilder.build();
            return new PolymerSwordItem(toolMaterial, enchantability, attackSpeed, settings, attributes, List.copyOf(loreLines));
        }
    }
}
