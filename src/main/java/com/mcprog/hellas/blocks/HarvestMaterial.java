package com.mcprog.hellas.blocks;

public enum HarvestMaterial {
	CLAY(HarvestType.spade, HarvestLevel.WOOD),
	ORE_STONE(HarvestType.pickaxe, HarvestLevel.STONE),
	ORE_IRON(HarvestType.pickaxe, HarvestLevel.IRON),
	ORE_DIAMOND(HarvestType.pickaxe, HarvestLevel.DIAMOND),
	STONE(HarvestType.pickaxe, HarvestLevel.WOOD), // ORE_WOOD
	METAL(HarvestType.pickaxe, HarvestLevel.STONE);
	
	private final HarvestType type;
	private final HarvestLevel level;
	
	private HarvestMaterial(HarvestType type, HarvestLevel level) {
		this.type = type;
		this.level = level;
	}
	
	public String getType() {
		return type.toString();
	}
	
	public int getLevel() {
		return level.ordinal();
	}
}
