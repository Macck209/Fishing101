package net.macck209.fishing101.items.polymer;

import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.macck209.fishing101.polymer.NoPackFallbacks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class PolymerArmorItem extends Item implements PolymerAutoItem {
	private List<Component> tooltipLines;
	private final Item polymerItemBase;

	public PolymerArmorItem(ArmorMaterial material, ArmorType slot, Properties settings, ItemAttributeModifiers attributes, List<Component> tooltipText) {
		super(settings.humanoidArmor(material, slot).attributes(attributes));
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
	public void modifyBasePolymerItemStack(ItemStack out, ItemStack stack, PacketContext context, HolderLookup.Provider lookup) {
		// Without the pack the client has no texture for our equipment asset; show the base item's.
		if (NoPackFallbacks.lacksPack(context)) {
			out.set(DataComponents.EQUIPPABLE, this.polymerItemBase.components().get(DataComponents.EQUIPPABLE));
		}
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
		private ArmorMaterial material;
		private ArmorType slot;
		private Properties settings;
		private ItemAttributeModifiers.Builder attributeBuilder = ItemAttributeModifiers.builder();
		private List<Component> loreLines = new ArrayList<>();

		public Builder(ArmorMaterial mat, ArmorType slot, Properties settings) {
			this.material = mat;
			this.slot = slot;
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

		public PolymerArmorItem build() {
			ItemAttributeModifiers attributes = attributeBuilder.build();
			return new PolymerArmorItem(material, slot, settings, attributes, List.copyOf(loreLines));
		}
	}
}
