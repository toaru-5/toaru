package toaru;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tools {
	
	public static class LiquidNitrogenCan extends Item {
		
		@Override
		public boolean onItemUse(ItemStack itemstack, EntityPlayer player,
				World world, int p_77648_4_, int p_77648_5_, int p_77648_6_,
				int p_77648_7_, float p_77648_8_, float p_77648_9_,
				float p_77648_10_) {
			
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 5*20, 3));
			player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Objects.nitrogen, player.inventory.getCurrentItem().stackSize-1));
			return true;
		}
	}
	
	/**
	 * @deprecated
	 * 作成途中
	 */
	public static class ElectroMagneticWaveGoggles extends Item {
		
		/*@SideOnly(Side.CLIENT)
		private IIcon theIcon;
		
		@SideOnly(Side.CLIENT)
		@Override
		public void registerIcons(IIconRegister p_registerIcons_1_) {
			itemIcon = p_registerIcons_1_.registerIcon(getIconString()+ "_off");
			theIcon = p_registerIcons_1_.registerIcon(getIconString()+"_on");
		}
		
		@SideOnly(Side.CLIENT)
		public void onPressedKey() {
			this.
		}*/
	}
}
