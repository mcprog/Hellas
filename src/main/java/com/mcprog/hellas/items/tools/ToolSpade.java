package com.mcprog.hellas.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade {

	public ToolSpade(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
	}
	
}
