package owq.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends ServerProxy
{
	public void registerRenderers()
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OverworldQuartz.blockQuartz), 0, new ModelResourceLocation("overworld-quartz:overworldquartz", "inventory"));
	}
}
