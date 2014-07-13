package toaru;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Toaru", name = "Toaru", version = "1.0")
public class Toaru {
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		registerRecipes();
		/**  **/
		FMLCommonHandler.instance().bus().register(new onSomeEventsHandler());
		
	}
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		Objects.setupObjects();
		Item[] items = new Item[] {Objects.compressed_air, Objects.learning_device, Objects.nitrogen, Objects.iron_nails, Objects.axela_stick, Objects.cybord_hand, Objects.remote, Objects.electro_magnetic_wave_goggles};
		for (Item item : items) {
			GameRegistry.registerItem(item, item.getUnlocalizedName());
		}
	}
	
	private void registerRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(Objects.compressed_air), new Object[] {Items.bucket, Items.bucket, Items.bucket, Items.bucket});
		GameRegistry.addRecipe(new ItemStack(Objects.nitrogen, 4), new Object[] {"SBS", "SCS", "SSS", 'S', Blocks.stone, 'B', Blocks.stone_button, 'C', Objects.compressed_air});
	}
}
