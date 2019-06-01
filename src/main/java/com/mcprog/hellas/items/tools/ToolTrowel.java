package com.mcprog.hellas.items.tools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ToolTrowel extends ToolSpade {

	public ToolTrowel(String name, ToolMaterial material) {
		super(name, material);
		
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack thisTrowel = player.getHeldItem(hand);
		
		if (!player.canPlayerEdit(pos.offset(facing), facing, thisTrowel)) {
			return EnumActionResult.FAIL;
		} else {
			Block targetBlock = worldIn.getBlockState(pos).getBlock();
			
			if (facing != EnumFacing.DOWN && worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR && targetBlock == Blocks.GRASS)
            {
                IBlockState dirtState = Blocks.DIRT.getDefaultState();
                worldIn.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!worldIn.isRemote)
                {
                    worldIn.setBlockState(pos, dirtState, 1 | 2 | 8); // bupdate | send to client | handle rerenders on main thread in client
                    thisTrowel.damageItem(2, player); // makes it twice as weak as shovel
                }

                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.PASS;
            }
		}
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		stack.damageItem(2, entityLiving);
		return true;
	}

}
