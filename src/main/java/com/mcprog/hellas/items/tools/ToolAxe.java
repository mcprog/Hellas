package com.mcprog.hellas.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe {

	public ToolAxe(String name, ToolMaterial material) {
		super(material, 6f, -3.2f);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
	}
	
}
