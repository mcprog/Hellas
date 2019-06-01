package com.mcprog.hellas.blocks;

import net.minecraft.block.material.Material;

public class OreBlock extends BlockBase {

	
	public OreBlock(String name, HarvestMaterial hMaterial) {
		super(name, Material.ROCK, hMaterial);
		setHardness(3);
		setResistance(15);
	}
	
}
