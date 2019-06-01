package com.mcprog.hellas.proxy.util.handlers;

import com.mcprog.hellas.init.ModBlocks;
import com.mcprog.hellas.init.ModItems;
import com.mcprog.hellas.init.ModRecipes;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class RegistryHandler {
	
	public static void client() {
		ModRecipes.register();
	}
	
	public static void common() {
		ModItems.register();
		
		ModBlocks.register();
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModel(Item item, ResourceLocation regName) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(regName, "inventory"));
	}
	

}
