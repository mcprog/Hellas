package com.mcprog.hellas.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public abstract class MetalSlab extends BlockSlabBase {

	public MetalSlab(String name, Material material) {
		super(name, material);
		setHardness(3);
		setResistance(30);
		setHarvestLevel(HarvestMaterial.METAL.getType(), HarvestMaterial.METAL.getLevel());
		setSoundType(SoundType.METAL);
	}

}
