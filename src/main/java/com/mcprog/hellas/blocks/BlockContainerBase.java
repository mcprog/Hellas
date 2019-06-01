package com.mcprog.hellas.blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockContainerBase extends BlockContainer {

	private String tip;
	
	public BlockContainerBase(String name, Material materialIn, HarvestMaterial hMaterial) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel(hMaterial.getType(), hMaterial.getLevel());
		setCreativeTab(CreativeTabs.MISC);
	}
	
	
	public BlockContainerBase flagTooltip() {
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
