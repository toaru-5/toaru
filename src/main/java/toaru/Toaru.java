package toaru;

import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Toaru", name = "Toaru", version = "1.0")
public class Toaru 
{
	
	@EventHandler
	public void Init(FMLInitializationEvent event) 
	{
		
	}
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) 
	{
		Objects.setupObjects();
		Item[] items = new Item[] {Objects.compressed_air, Objects.learning_device, Objects.nitrogen, Objects.iron_nails, Objects.cyborg_hand, Objects.Electrode};
		for (Item item : items) 
		{
			GameRegistry.registerItem(item, item.getUnlocalizedName());
		}
	}
}
