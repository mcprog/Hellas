package com.mcprog.hellas.blocks.util;

import net.minecraft.block.Block;

public interface ITippable<T extends Block> {
	
	public String tip = null;
	
	public T flagTooltip();

}
