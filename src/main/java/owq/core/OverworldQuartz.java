package owq.core;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

@Mod(modid = "overworld-quartz", name = "Overworld Quartz", acceptedMinecraftVersions = "[1.8]")
public class OverworldQuartz
{
	@Instance("overworld-quartz")
	private static OverworldQuartz instance;
	private Logger logger;
	
	@SidedProxy(clientSide = "owq.core.ClientProxy", serverSide = "owq.core.ServerProxy")
	public static ServerProxy proxy;
	
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
		blockQuartz = new BlockOverworldQuartz();

		SimpleOreGenerator.register(new SimpleOreGenerator(blockQuartz, 8, 1, 63, true, false), 1);
		GameRegistry.addSmelting(blockQuartz, new ItemStack(Items.quartz), 0.2F);
		
		proxy.registerRenderers();
	}
	
	public static OverworldQuartz getInstance()
	{
		return instance;
	}
}
