package toaru;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Objects {

	public static Item learning_device, nitrogen, compressed_air, iron_nails, cyborg_hand;
	public static CreativeTabs tabToaru = new CreativeTabs("Toaru") {
		@Override
		@SideOnly(Side.CLIENT) 
		public Item getTabIconItem() {
			return learning_device;
		}
	};
	
	public static void setupObjects() {
		learning_device = new Item().setCreativeTab(tabToaru).setUnlocalizedName("LearningDevice").setTextureName("LearningDevice");
		nitrogen = new Item().setCreativeTab(tabToaru).setUnlocalizedName("LiquidNitrogenCan").setTextureName("LiquidNitrogenCan");
		compressed_air = new Item().setCreativeTab(tabToaru).setUnlocalizedName("CompressedAir").setTextureName("CompressedAir");
		iron_nails = new Item().setCreativeTab(tabToaru).setUnlocalizedName("IronNails").setTextureName("IronNails");
		cyborg_hand = new Item().setCreativeTab(tabToaru).setUnlocalizedName("CyborgHand").setTextureName("CyborgHand");
	}
}