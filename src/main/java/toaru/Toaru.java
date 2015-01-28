package toaru;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import toaru.HPW.TGuiHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Toaru", name = "Toaru", version = "1.0")
public class Toaru {

	@Instance("Toaru")
	public static Toaru instance;

	@EventHandler
	public void Init(FMLInitializationEvent event) {

		registerRecipes();
		FMLCommonHandler.instance().bus().register(new onSomeEventsHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new TGuiHandler());
		
	}
//アイテムの読み込み場所の指定？
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		Objects.setupObjects();

		Item[] items = new Item[] {Objects.compressed_air, Objects.learning_device, Objects.nitrogen, Objects.iron_nails, Objects.axela_stick, Objects.cybord_hand, Objects.remote, Objects.electro_magnetic_wave_goggles, Objects.treediagram_debris, Objects.coin};
		for (Item item : items)
			GameRegistry.registerItem(item, item.getUnlocalizedName());

		Block[] blocks = new Block[] {Objects.high_performance_workbench};
		for (Block block : blocks)
			GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
//クラフトなど追加
	private void registerRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(Objects.compressed_air), new Object[] {Items.bucket, Items.bucket, Items.bucket, Items.bucket});
		GameRegistry.addRecipe(new ItemStack(Objects.nitrogen, 4), new Object[] {"SBS", "SCS", "SSS", 'S', Blocks.stone, 'B', Blocks.stone_button, 'C', Objects.compressed_air});
		GameRegistry.addRecipe(new ItemStack(Objects.high_performance_workbench,1), new Object[] {"SBS", "SCS", "SSS", 'S', Items.diamond, 'B', Blocks.redstone_block, 'C', Items.emerald});
	}
}
