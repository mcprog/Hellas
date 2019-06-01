package com.mcprog.hellas.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block {

	private String tip;
	
	
	
	public BlockBase(String name, Material material, HarvestMaterial hMaterial) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel(hMaterial.getType(), hMaterial.getLevel());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	public BlockBase flagTooltip() {
		tip = getUnlocalizedName() + ".tip";
		return this;
	}


	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		if (tip == null) {
			super.addInformation(stack, player, tooltip, advanced);
		} else {
			tooltip.add(I18n.translateToLocal(tip));
		}
		
	}
	

}
