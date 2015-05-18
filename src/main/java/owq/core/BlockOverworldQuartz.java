package owq.core;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockOverworldQuartz extends BlockOre
{
	public BlockOverworldQuartz()
	{
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(soundTypePiston);
		setBlockName("overworldquartz");
		setBlockTextureName("overworld-quartz:overworldquartz");
		setHarvestLevel("pickaxe", 1);
		
		GameRegistry.registerBlock(this, "overworldquartz");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public Item getItemDropped(int unknown, Random random, int unknown1) 
	{
		return Items.quartz;
	}
}
