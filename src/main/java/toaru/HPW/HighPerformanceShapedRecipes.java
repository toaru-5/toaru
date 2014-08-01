package toaru.HPW;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class HighPerformanceShapedRecipes implements IRecipe {

	public final int recipeWidth;
	public final int recipeHeight;
	public final ItemStack[] recipeItems;
	private ItemStack recipeOutput;
	public final Item recipeOutputItem;
	private boolean bool = false;
	
	public HighPerformanceShapedRecipes(int par1, int par2, ItemStack[] par3ArrayOfItemStack, ItemStack par4ItemStack) {
		this.recipeOutputItem = par4ItemStack.getItem();
		this.recipeWidth = par1;
		this.recipeHeight = par2;
		this.recipeItems = par3ArrayOfItemStack;
		this.recipeOutput = par4ItemStack;
	}
	@Override
	public boolean matches(InventoryCrafting paramInventoryCrafting,
			World paramWorld) {
		for (int i = 0; i <= 7 - this.recipeWidth; i++)
			for (int j = 0; j <= 7 - this.recipeHeight; j++) {
				if (this.checkMatch(paramInventoryCrafting, i, j, true) || this.checkMatch(paramInventoryCrafting, i, j, false))
					return true;
			}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting paramInventoryCrafting) {
		ItemStack is = this.getRecipeOutput().copy();
		
		if (this.bool)
			for (int i = 0; i < paramInventoryCrafting.getSizeInventory(); i++) {
				ItemStack is1 = paramInventoryCrafting.getStackInSlot(i);
				if (is1 != null && is1.hasTagCompound())
					is.setTagCompound((NBTTagCompound)is1.stackTagCompound.copy());
			}
		return is;
	}

	@Override
	public int getRecipeSize() {
		return this.recipeWidth * this.recipeHeight;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}
	
	private boolean checkMatch(InventoryCrafting par1InventoryCrafting, int par2, int par3, boolean par4)
	{
		 for (int k = 0; k < 7; ++k)
		 {
			 for (int l = 0; l < 7; ++l)
			 {
				 int i1 = k - par2;
				 int j1 = l - par3;
				 ItemStack itemstack = null;

				 if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				 {
					 if (par4)
					 {
						 itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					 }
					 else
					 {
						 itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
					 }
				 }

				 ItemStack itemstack1 = par1InventoryCrafting.getStackInRowAndColumn(k, l);

				 if (itemstack1 != null || itemstack != null)
				 {
					 if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
					 {
						 return false;
					 }

					 if (itemstack.getItem() != itemstack1.getItem())
					 {
						 return false;
					 }

					 if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
					 {
						 return false;
					 }
				 }
			 }
		 }

		 return true;
	}
	

}
