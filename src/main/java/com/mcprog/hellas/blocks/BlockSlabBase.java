package com.mcprog.hellas.blocks;

import java.util.List;
import java.util.Random;

import com.mcprog.hellas.init.ModBlocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockSlabBase extends BlockSlab {

	
	private String tip;
	
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);
	
	public BlockSlabBase(String name, Material material, HarvestMaterial hMaterial) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHarvestLevel(hMaterial.getType(), hMaterial.getLevel());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		IBlockState iblockstate = blockState.getBaseState();
		
		if (!isDouble()) {
			iblockstate.withProperty(HALF, EnumBlockHalf.BOTTOM);
			// starts in hand as bottom
		}
		
		setDefaultState(iblockstate.withProperty(VARIANT, Variant.DEFAULT));
		useNeighborBrightness = !isDouble(); // if full block, need to block light
		
		
	}
	
	public BlockSlabBase flagTooltip() {
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

	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}


	@Override
	public IProperty<?> getVariantProperty() {
		return VARIANT;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return Variant.DEFAULT;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		
		IBlockState iblockstate = getDefaultState().withProperty(VARIANT, Variant.DEFAULT);
		if (!isDouble()) {
			iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
		}
		
		return iblockstate;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.COPPER_SLAB);
	}
	
	
	
	@Override
	public int getMetaFromState(IBlockState state) {

		int meta = 0;
		
		if(!this.isDouble() && state.getValue(HALF)==EnumBlockHalf.TOP) {
			meta |= 8;
		}
		
		return meta;
	}

	
	@Override
	protected BlockStateContainer createBlockState() {
		if (isDouble()) {
			return new BlockStateContainer(this, new IProperty[] {VARIANT});
		}
		return new BlockStateContainer(this, new IProperty[] { HALF, VARIANT });
	}
	

	
	public static class Double extends BlockSlabBase {
		public Double(String name, Material material, HarvestMaterial hMaterial) {
			super(name, material, hMaterial);
		}
		
		@Override
		public boolean isDouble() {
			return true;
		}
	}
	
	
	public static class Half extends BlockSlabBase {

		public Half(String name, Material material, HarvestMaterial hMaterial) {
			super(name, material, hMaterial);
		}
		
		@Override
		public boolean isDouble() {
			return false;
		}
		
	}
	
	
	protected static enum Variant implements IStringSerializable {
		
		DEFAULT;

		@Override
		public String getName() {
			return "default"; // no other variant yet
		}
		
	}

}
