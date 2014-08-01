package toaru.HPW;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class HighPerformanceShapelessRecipes implements IRecipe {
	private final ItemStack recipeOutput;
	
	public final List recipeItems;
	
	public HighPerformanceShapelessRecipes(ItemStack par1ItemStack, List par2List) {
		this.recipeOutput = par1ItemStack;
		this.recipeItems = par2List;
	}
	
	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	@Override
	public boolean matches(InventoryCrafting paramInventoryCrafting,
			World paramWorld) {
		ArrayList list = new ArrayList(this.recipeItems);
		
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++) {
				ItemStack is = paramInventoryCrafting.getStackInRowAndColumn(j, i);
				
				if (is != null) {
					boolean flag = false;
					Iterator iterator = list.iterator();
					while (iterator.hasNext()) {
						ItemStack is1 = (ItemStack)iterator.next();
						
						if (is.getItem().equals(is1.getItem()) && (is1.getItemDamage() == 32767 || is.getItemDamage() == is1.getItemDamage())) {
							flag = true;
							list.remove(is1);
							break;
						}
					}
					
					if (!flag) return false;
				}
			}
		return list.isEmpty();
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting paramInventoryCrafting) {
		return this.recipeOutput.copy();
	}

	@Override
	public int getRecipeSize() {
		return this.recipeItems.size();
	}

}
