package com.mcprog.hellas.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe {

	public ToolPickaxe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
	}


}
