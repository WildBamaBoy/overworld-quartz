package owq.core;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
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
	private Configuration config;
	
	public static Block blockQuartz;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		logger = event.getModLog();
		config = new Configuration(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		int id = config.get("Init", "overworldQuartzID", 3527).getInt();
		config.save();
		
		blockQuartz = new BlockOverworldQuartz(id);

		SimpleOreGenerator.register(new SimpleOreGenerator(blockQuartz, 8, 1, 63, true, false), 1);
		GameRegistry.addSmelting(blockQuartz.blockID, new ItemStack(Item.netherQuartz), 0.2F);
	}
	
	public static OverworldQuartz getInstance()
	{
		return instance;
	}
}
