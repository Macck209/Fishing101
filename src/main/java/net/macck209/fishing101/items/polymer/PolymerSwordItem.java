package net.macck209.fishing101.items.polymer;

import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class PolymerSwordItem extends Item implements PolymerAutoItem {
    private List<Text> tooltipLines;

    public PolymerSwordItem(ToolMaterial toolMaterial, int enchantability, float attackSpeed, Settings settings, AttributeModifiersComponent attributes, List<Text> tooltipText) {
        super(toolMaterial
                .applyToolSettings(settings, BlockTags.SHOVEL_MINEABLE, 0, attackSpeed, 0)
                .enchantable(enchantability).attributeModifiers(attributes)
        );
        this.tooltipLines = tooltipText;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
        return Items.IRON_SWORD;
    }

    @Override
    public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context){
        return PolymerTextures.MODELS.get(this);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
        if (tooltipLines != null) {
            for (Text line:tooltipLines) {
                tooltip.accept(line);
            }
        }
    }

    public static class Builder {
        private final ToolMaterial toolMaterial;
        private final int enchantability;
        private final float attackSpeed;

        private Settings settings;
        private AttributeModifiersComponent.Builder attributeBuilder = AttributeModifiersComponent.builder();
        private List<Text> loreLines = new ArrayList<>();

        public Builder(ToolMaterial toolMaterial, int enchantability, float attackSpeed, Settings settings) {
            this.toolMaterial = toolMaterial;
            this.enchantability = enchantability;
            this.attackSpeed = attackSpeed;
            this.settings = settings;
        }

        public Builder addAttributeModif(RegistryEntry attrType, EntityAttributeModifier modifValue, AttributeModifierSlot modifSlot, AttributeModifiersComponent.Display modifDisplay) {
            this.attributeBuilder.add(attrType, modifValue, modifSlot, modifDisplay);
            return this;
        }

        public Builder addLore(Text... lines) {
            this.loreLines.addAll(Arrays.asList(lines));
            return this;
        }

        public PolymerSwordItem build() {
            AttributeModifiersComponent attributes = attributeBuilder.build();
            return new PolymerSwordItem(toolMaterial, enchantability, attackSpeed, settings, attributes, List.copyOf(loreLines));
        }
    }
}
