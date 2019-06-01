package com.mcprog.hellas.init;

import java.util.ArrayList;
import java.util.List;

import com.mcprog.hellas.items.ItemBase;
import com.mcprog.hellas.items.tools.ToolAxe;
import com.mcprog.hellas.items.tools.ToolPickaxe;
import com.mcprog.hellas.items.tools.ToolSpade;
import com.mcprog.hellas.items.tools.ToolSword;
import com.mcprog.hellas.items.tools.ToolTrowel;
import com.mcprog.hellas.proxy.util.handlers.RegistryHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItems {
	
	
	//Materials
	public static final ToolMaterial MATERIAL_COPPER = EnumHelper
			.addToolMaterial("material_copper", 1, 190, 5.5f, 1.5f, 17);
	
	public static final Item SALT = new ItemBase("salt");
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
	public static final Item COPPER_BLADE = new ItemBase("copper_blade");
	public static final Item COPPER_PICKAXE_HEAD = new ItemBase("copper_pickaxe_head");
	public static final Item COPPER_AXE_HEAD = new ItemBase("copper_axe_head");
	
	// Tools
	public static final ItemSword COPPER_SWORD = new ToolSword("copper_sword", MATERIAL_COPPER);
	public static final ItemSpade COPPER_SHOVEL = new ToolSpade("copper_shovel", MATERIAL_COPPER);
	public static final ItemSpade COPPER_TROWEL = new ToolTrowel("copper_trowel", MATERIAL_COPPER);
	public static final ItemPickaxe COPPER_PICKAXE = new ToolPickaxe("copper_pickaxe", MATERIAL_COPPER);
	public static final ItemAxe COPPER_AXE = new ToolAxe("copper_axe", MATERIAL_COPPER);
	
	public static void register() {
		registerItem(SALT);
		registerItem(COPPER_INGOT);
		registerItem(COPPER_BLADE);
		registerItem(COPPER_PICKAXE_HEAD);
		registerItem(COPPER_AXE_HEAD);
		registerItem(COPPER_SWORD);
		registerItem(COPPER_SHOVEL);
		registerItem(COPPER_TROWEL);
		registerItem(COPPER_PICKAXE);
		registerItem(COPPER_AXE);
	}
	
	static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
		RegistryHandler.registerModel(item, item.getRegistryName());
	}
	
	
}
