package toaru;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.lwjgl.input.Keyboard;

import toaru.HPW.BlockHighPerformanceWorkbench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Objects {
//アイテムなどの登録
	public static Item learning_device, nitrogen, compressed_air, iron_nails, axela_stick, cybord_hand, remote, electro_magnetic_wave_goggles, treediagram_debris, coin;
	public static Block high_performance_workbench;
	public static CreativeTabs tabToaru = new CreativeTabs("Toaru") {
		@Override
		@SideOnly(Side.CLIENT) 
		public Item getTabIconItem() {
			return learning_device;
		}
	};

	public static KeyBinding goggleKey;
//アイテム情報の追加
	public static void setupObjects() {
		learning_device = new Item().setCreativeTab(tabToaru).setUnlocalizedName("LearningDevice").setTextureName("LearningDevice");
		nitrogen = new Tools.LiquidNitrogenCan().setCreativeTab(tabToaru).setUnlocalizedName("LiquidNitrogenCan").setTextureName("LiquidNitrogenCan");
		compressed_air = new Item().setCreativeTab(tabToaru).setUnlocalizedName("CompressedAir").setTextureName("CompressedAir");
		iron_nails = new Item().setCreativeTab(tabToaru).setUnlocalizedName("IronNails").setTextureName("IronNails");
		axela_stick = new Item().setCreativeTab(tabToaru).setUnlocalizedName("AxelaStick").setTextureName("AxelaStick");
		cybord_hand = new Item().setCreativeTab(tabToaru).setUnlocalizedName("CyborgHand").setTextureName("CyborgHand");
		remote = new Item().setCreativeTab(tabToaru).setUnlocalizedName("Remote").setTextureName("Remote");
		electro_magnetic_wave_goggles = new Tools.ElectroMagneticWaveGoggles().setCreativeTab(tabToaru).setUnlocalizedName("ElectroMagneticWaveGoggles").setTextureName("ElectroMagneticWaveGoggles");
		treediagram_debris = new Item().setCreativeTab(tabToaru).setUnlocalizedName("Treediagram_Debris").setTextureName("Treediagram_Debris");
		coin = new Item().setCreativeTab(tabToaru).setUnlocalizedName("Coin").setTextureName("Coin");

		high_performance_workbench = new BlockHighPerformanceWorkbench(Material.wood).setCreativeTab(tabToaru).setBlockName("HighPerformanceWorkbench").setBlockTextureName("high_performance_workbench");

		goggleKey = new KeyBinding("key.goggle", Keyboard.KEY_L, "key.categories.Toaru");
	};
}
