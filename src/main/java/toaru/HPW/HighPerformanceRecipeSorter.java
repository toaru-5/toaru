package toaru.HPW;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class HighPerformanceRecipeSorter implements Comparator {
	final HighPerformanceCraftingManager manager;
	
	public HighPerformanceRecipeSorter(HighPerformanceCraftingManager manager) {
		this.manager = manager;
	}
	
	public int compareRecipes(IRecipe irecipe, IRecipe irecipe1) {
		return irecipe instanceof HighPerformanceShapelessRecipes && irecipe1 instanceof HighPerformanceShapedRecipes ? 1 : (irecipe1 instanceof HighPerformanceShapelessRecipes && irecipe instanceof HighPerformanceShapedRecipes ? -1 : (irecipe1.getRecipeSize() < irecipe.getRecipeSize() ? -1 : (irecipe1.getRecipeSize() > irecipe.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}
	
}
