package toaru;

import toaru.HPW.ContainerHighPerformanceWorkbench;
import toaru.HPW.HighPerformanceCraftingManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;
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
			if (!player.capabilities.isCreativeMode)
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Objects.nitrogen, player.inventory.getCurrentItem().stackSize-1));
			return true;
		}
	}

	/**
	 * @deprecated
	 * 作成途中
	 */
	public static class ElectroMagneticWaveGoggles extends Item {

		@SideOnly(Side.CLIENT)
		private IIcon theIcon;

		@SideOnly(Side.CLIENT)
		@Override
		public void registerIcons(IIconRegister p_registerIcons_1_) {
			itemIcon = p_registerIcons_1_.registerIcon(getIconString()+ "_off");
			theIcon = p_registerIcons_1_.registerIcon(getIconString()+"_on");
		}

		public boolean onItemUse(ItemStack itemstack, EntityPlayer player,
				World world, int p_77648_4_, int p_77648_5_, int p_77648_6_,
				int p_77648_7_, float p_77648_8_, float p_77648_9_,
				float p_77648_10_) {

			FMLLog.info(this.itemIcon.getIconName());
			FMLLog.info(this.theIcon.getIconName());
			return true;
		}
	}

	static class GuiHighPerformanceWorkbench extends GuiContainer {

		private static final ResourceLocation highPerformanceWorkbenchTextures = new ResourceLocation("textures/gui/container/highperformanceworkbench.png");
		public GuiHighPerformanceWorkbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
		{
			super(new ContainerHighPerformanceWorkbench(par1InventoryPlayer, par2World, par3, par4, par5));
			this.ySize = 219;
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float arg0,
				int arg1, int arg2) {
			// TODO 自動生成されたメソッド・スタブ

		}

	}
}
