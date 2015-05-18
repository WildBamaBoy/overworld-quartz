package owq.core;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockOverworldQuartz extends BlockOre
{
	public BlockOverworldQuartz(int id)
	{
		super(id);
		
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName("overworldquartz");
		setTextureName("overworld-quartz:overworldquartz");

		GameRegistry.registerBlock(this, "overworldquartz");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public int idDropped(int unknown, Random random, int unknown1) 
	{
		return Item.netherQuartz.itemID;
	}
}
