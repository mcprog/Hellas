package com.mcprog.hellas.blocks;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BreakingOreBlock extends OreBlock {

	private Item droppedItem;
	private int maxExtra;
	
	private int minXp = 0;
	private int maxXp = 2; //default values as per coal ore
	
	public BreakingOreBlock(String name, Item dropped, int maxExtra, HarvestMaterial hMaterial) {
		super(name, hMaterial);
		droppedItem = dropped;
		this.maxExtra = maxExtra;
	}
	
	public BreakingOreBlock(String name, Item dropped, HarvestMaterial hMaterial) {
		super(name, hMaterial);
		droppedItem = dropped;
		maxExtra = 0;
	}
	
	public BreakingOreBlock setExp(int min, int max) {
		minXp = min;
		maxXp = max;
		return this;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return droppedItem;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return random.nextInt(maxExtra) + 1;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0) { // don't need to check if it drops itself, it does not
			int i = random.nextInt(fortune + 2) - 1;

	        if (i < 0)
	        {
                i = 0;
            }
            return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
	
	
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		return MathHelper.getInt(rand, minXp, maxXp);
	}

}
