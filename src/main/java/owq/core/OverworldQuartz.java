package owq.core;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "overworld-quartz", name = "Overworld Quartz", acceptedMinecraftVersions = "[1.6.4]")
public class OverworldQuartz
{
	@Instance("overworld-quartz")
	private static OverworldQuartz instance;
	private Logger logger;
	
	public static Block blockQuartz;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		blockQuartz = new BlockOverworldQuartz(3231);

		SimpleOreGenerator.register(new SimpleOreGenerator(blockQuartz, 8, 1, 63, true, false), 1);
		GameRegistry.addSmelting(blockQuartz.blockID, new ItemStack(Item.netherQuartz), 0.2F);
	}
	
	public static OverworldQuartz getInstance()
	{
		return instance;
	}
}
