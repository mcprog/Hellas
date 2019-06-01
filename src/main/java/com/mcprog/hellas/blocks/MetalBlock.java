package com.mcprog.hellas.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MetalBlock extends BlockBase {

	public MetalBlock(String name) {
		super(name, Material.IRON, HarvestMaterial.METAL);
		setSoundType(SoundType.METAL);
		setHardness(5);
		setResistance(30);
		
	}
	

}
