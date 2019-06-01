package com.mcprog.hellas.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public abstract class MetalSlab extends BlockSlabBase {

	public MetalSlab(String name, Material material) {
		super(name, material, HarvestMaterial.METAL);
		setHardness(3);
		setResistance(30);
		setSoundType(SoundType.METAL);
	}

}
