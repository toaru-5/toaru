package toaru.HPW;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerHighPerformanceWorkbench extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX, posY, posZ;

	public ContainerHighPerformanceWorkbench(InventoryPlayer player, World world, int i, int j, int k) {
		craftMatrix = new InventoryCrafting(this, 7, 7);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = i;
		posY = j;
		posZ = k;
		
		addSlotToContainer(new SlotCrafting(player.player, craftMatrix, craftResult, 0, 131, 36));
		
		for (int l = 0; l < 7; l++) {
			for (int k1 = 0; k1 < 7; k1++) { 
				this.addSlotToContainer(new Slot(craftMatrix, k1 + l * 7, 4 + k1 * 18, 3 + l * 18));
			}
		}
		
		for (int i1 = 0; i1 < 3; i1++) {
			for (int l1 = 0; l1 < 9; l1++) {
				this.addSlotToContainer(new Slot(player, l1 + i1 * 9 + 9, 8 + l1 * 18, 94 * i1 * 18));
			}
		}
		
		for (int j1 = 0; j1 < 9; j1++) {
			this.addSlotToContainer(new Slot(player, j1, 8 + j1 * 18, 148));
		}
		
		craftResult.setInventorySlotContents(0, HighPerformanceCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		if (worldObj.isRemote)
			return;

		for (int i = 0; i < 64; i++) {
			ItemStack itemstack = craftMatrix.getStackInSlotOnClosing(i);
			if (itemstack != null)
				player.dropPlayerItemWithRandomChoice(itemstack, false);
		}
	}
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (!(worldObj.getBlock(posX, posY, posZ) instanceof BlockHighPerformanceWorkbench))
			return false;
		else
			return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64D;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(par2);
		if (slot != null && slot.getHasStack()) {
			ItemStack is = slot.getStack();
			itemstack = is.copy();

			if (par2==0) {
				if (!this.mergeItemStack(is, 10, 46, true))
				{
					return null;
				}

				slot.onSlotChange(is, itemstack);
			}
			else if(par2 >= 10 && par2 < 37)
			{
				if(!mergeItemStack(is, 37, 46, false))
				{
					return null;
				}
			} else
				if(par2 >= 37 && par2 < 46)
				{
					if(!mergeItemStack(is, 10, 37, false))
					{
						return null;
					}
				} else
					if(!mergeItemStack(is, 10, 46, false))
					{
						return null;
					}
			if(is.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			} else
			{
				slot.onSlotChanged();
			}
			if(is.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, is);
		}
		return itemstack;
	}
}