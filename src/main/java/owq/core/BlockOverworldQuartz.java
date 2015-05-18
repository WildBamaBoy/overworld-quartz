package owq.core;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockOverworldQuartz extends BlockOre
{
	public BlockOverworldQuartz()
	{
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(soundTypePiston);
		setUnlocalizedName("overworldquartz");
		setHarvestLevel("pickaxe", 1);
		
		GameRegistry.registerBlock(this, "overworldquartz");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public int quantityDropped(Random random) 
	{
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Items.quartz;
	}
}
