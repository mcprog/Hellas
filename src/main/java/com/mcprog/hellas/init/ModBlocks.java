package com.mcprog.hellas.init;

import java.util.ArrayList;
import java.util.List;

import com.mcprog.hellas.blocks.BlockBase;
import com.mcprog.hellas.blocks.BlockSlabBase;
import com.mcprog.hellas.blocks.BreakingOreBlock;
import com.mcprog.hellas.blocks.ClaySlab;
import com.mcprog.hellas.blocks.HarvestLevel;
import com.mcprog.hellas.blocks.HarvestMaterial;
import com.mcprog.hellas.blocks.MetalBlock;
import com.mcprog.hellas.blocks.MetalSlab;
import com.mcprog.hellas.blocks.OreBlock;
import com.mcprog.hellas.blocks.machines.BlockKiln;
import com.mcprog.hellas.proxy.util.handlers.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {
	
	
	public static final List<BlockSlab> SLABS = new ArrayList<BlockSlab>();
	
	// block base automatically adds itself to BLOCKS and ITEMS
	public static final Block SALT_BLOCK = new BlockBase("salt_block", Material.SAND, HarvestMaterial.ORE_STONE);
	public static final Block COPPER_BLOCK = new MetalBlock("copper_block");
	public static final Block COPPER_ORE = new OreBlock("copper_ore", HarvestMaterial.ORE_STONE);
	public static final Block SALT_ORE = new BreakingOreBlock("salt_ore", ModItems.SALT, 5, HarvestMaterial.ORE_IRON).flagTooltip();
	public static final Block MOLDER = new BlockBase("molder", Material.ROCK, HarvestMaterial.STONE).flagTooltip();
	
	public static final BlockSlab COPPER_SLAB = new MetalSlab.Half("copper_slab", Material.IRON, HarvestMaterial.METAL);
	public static final BlockSlab COPPER_SLAB_DOUBLE = new MetalSlab.Double("copper_slab_double", Material.IRON, HarvestMaterial.METAL);
	
	public static final BlockSlab CLAY_SLAB = new ClaySlab.Half("clay_slab", Material.CLAY, HarvestMaterial.CLAY);
	public static final BlockSlab CLAY_SLAB_DOUBLE = new ClaySlab.Double("clay_slab_double", Material.CLAY, HarvestMaterial.CLAY);
	
	public static final Block KILN = new BlockKiln("kiln", Material.ROCK, HarvestMaterial.STONE);



	public static void register() {
		registerBlock(SALT_BLOCK);
		registerBlock(COPPER_BLOCK);
		registerBlock(COPPER_ORE);
		registerBlock(SALT_ORE);
		registerBlock(MOLDER);
		registerBlock(KILN);
		
		registerSlab(COPPER_SLAB, COPPER_SLAB_DOUBLE);
		registerSlab(CLAY_SLAB, CLAY_SLAB_DOUBLE);
		
		
	}
	
	static void registerBlock(Block block) {
		ItemBlock iBlock = new ItemBlock(block);
		registerBlock(block, iBlock);
	}
	
	static void registerBlock(Block block, ItemBlock itemBlock) {
		ForgeRegistries.BLOCKS.register(block);
		itemBlock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);
		
		RegistryHandler.registerModel(Item.getItemFromBlock(block), block.getRegistryName());
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	static void registerSlab(BlockSlab halfSlab, BlockSlab doubleSlab) {
		ItemSlab iSlab = new ItemSlab(halfSlab, halfSlab, doubleSlab);
		
		registerBlock(halfSlab, iSlab);
		
		ForgeRegistries.BLOCKS.register(doubleSlab); // does not exist in inventory
	}
	
	
}
