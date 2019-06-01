package com.mcprog.hellas.blocks;

import net.minecraft.block.material.Material;

public abstract class ClaySlab extends BlockSlabBase {

	public ClaySlab(String name, Material material) {
		super(name, material);
		setHardness(.6f);
		setResistance(3);
		setHarvestLevel("spade", HarvestLevel.WOOD.ordinal());
		flagTooltip();
	}

	//TODO more

}
