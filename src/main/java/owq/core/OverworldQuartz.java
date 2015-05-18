package owq.core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "overworld-quartz", name = "Overworld Quartz", acceptedMinecraftVersions = "[1.7.10]")
public class OverworldQuartz
{
	@Instance("overworld-quartz")
	private static OverworldQuartz instance;
	private Logger logger;
	
	private static Block blockQuartz;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		blockQuartz = new BlockOverworldQuartz();

		SimpleOreGenerator.register(new SimpleOreGenerator(blockQuartz, 8, 1, 63, true, false), 1);
		GameRegistry.addSmelting(blockQuartz, new ItemStack(Items.quartz), 0.2F);
	}
	
	public static OverworldQuartz getInstance()
	{
		return instance;
	}
}
