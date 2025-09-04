package net.macck209.fishing101.items.polymer;

import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class PolymerArmorItem extends Item implements PolymerAutoItem {
	private List<Text> tooltipLines;
	private final Item polymerItemBase;

	public PolymerArmorItem(ArmorMaterial material, EquipmentType slot, Settings settings, AttributeModifiersComponent attributes, List<Text> tooltipText) {
		super(settings.armor(material, slot).attributeModifiers(attributes));
		this.polymerItemBase = switch (slot) {
			case HELMET -> Items.IRON_HELMET;
			case CHESTPLATE -> Items.IRON_CHESTPLATE;
			case LEGGINGS -> Items.IRON_LEGGINGS;
			case BOOTS -> Items.IRON_BOOTS;
			default -> Items.STICK;
		};
		this.tooltipLines = tooltipText;
	}

	@Override
	public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
		return this.polymerItemBase;
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
		private ArmorMaterial material;
		private EquipmentType slot;
		private Settings settings;
		private AttributeModifiersComponent.Builder attributeBuilder = AttributeModifiersComponent.builder();
		private List<Text> loreLines = new ArrayList<>();

		public Builder(ArmorMaterial mat, EquipmentType slot, Settings settings) {
			this.material = mat;
			this.slot = slot;
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

		public PolymerArmorItem build() {
			AttributeModifiersComponent attributes = attributeBuilder.build();
			return new PolymerArmorItem(material, slot, settings, attributes, List.copyOf(loreLines));
		}
	}
}
