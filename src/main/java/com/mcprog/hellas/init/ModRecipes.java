package com.mcprog.hellas.init;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void register() {
		GameRegistry.addSmelting(ModBlocks.COPPER_ORE, new ItemStack(ModItems.COPPER_INGOT), 2.5f);
		GameRegistry.addSmelting(ModBlocks.SALT_ORE, new ItemStack(ModItems.SALT, 4), 1);
		GameRegistry.addSmelting(new ItemStack(ModItems.COPPER_INGOT, 2), 
				new ItemStack(ModItems.COPPER_BLADE), 0);
		GameRegistry.addSmelting(ModItems.COPPER_BLADE, new ItemStack(ModItems.COPPER_INGOT, 2), 0);
		GameRegistry.addSmelting(ModItems.COPPER_INGOT, new ItemStack(ModItems.COPPER_TROWEL, 1), 0);
		
		// Special Crafting
	}

}
