package toaru.HPW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;

public class HighPerformanceCraftingManager {
	
	private static final HighPerformanceCraftingManager instance = new HighPerformanceCraftingManager();
	private List recipes = new ArrayList();
	
	// このCraftingManagerのインスタンスを返します。
	public static final HighPerformanceCraftingManager getInstance() {
		return instance;
	}
	

	private HighPerformanceCraftingManager() {
		recipes = new ArrayList();
		Collections.sort(this.recipes, new HighPerformanceRecipeSorter(this));
		FMLLog.info("%d recipes", this.recipes.size());
	}
	
	public HighPerformanceShapedRecipes func_92051_a(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		 String var3 = "";
		 int var4 = 0;
		 int var5 = 0;
		 int var6 = 0;

		 if (par2ArrayOfObj[var4] instanceof String[])
		 {
			 String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

			 for (int var8 = 0; var8 < var7.length; ++var8)
			 {
				 String var9 = var7[var8];
				 ++var6;
				 var5 = var9.length();
				 var3 = var3 + var9;
			 }
		 }
		 else
		 {
			 while (par2ArrayOfObj[var4] instanceof String)
			 {
				 String var11 = (String)par2ArrayOfObj[var4++];
				 ++var6;
				 var5 = var11.length();
				 var3 = var3 + var11;
			 }
		 }

		 HashMap var12;

		 for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
		 {
			 Character var13 = (Character)par2ArrayOfObj[var4];
			 ItemStack var14 = null;

			 if (par2ArrayOfObj[var4 + 1] instanceof Item)
			 {
				 var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
			 }
			 else if (par2ArrayOfObj[var4 + 1] instanceof Block)
			 {
				 var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
			 }
			 else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
			 {
				 var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
			 }

			 var12.put(var13, var14);
		 }

		 ItemStack[] var15 = new ItemStack[var5 * var6];

		 for (int var16 = 0; var16 < var5 * var6; ++var16)
		 {
			 char var10 = var3.charAt(var16);

			 if (var12.containsKey(Character.valueOf(var10)))
			 {
				 var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
			 }
			 else
			 {
				 var15[var16] = null;
			 }
		 }

		 HighPerformanceShapedRecipes var17 = new HighPerformanceShapedRecipes(var5, var6, var15, par1ItemStack);
		 this.recipes.add(var17);
		 return var17;
	}
	
	public void addBuilderShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		ArrayList list = new ArrayList();
		Object[] objects = par2ArrayOfObj;
		int length = par2ArrayOfObj.length;
		
		for (int i = 0; i < length; i++) {
			Object object = objects[i];
			
			if (object instanceof ItemStack)
				list.add((((ItemStack)object).copy()));
			else if (object instanceof Item)
				list.add(new ItemStack((Item)object));
			else {
				if (!(object instanceof Block))
					throw new RuntimeException("invalid shapeless recipy!: "+objects+"==>>>"+object);
				
				list.add(new ItemStack((Block)object));
			}
		}
		
		this.recipes.add(new HighPerformanceShapelessRecipes(par1ItemStack, list));
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting crafting, World world) {
		int i = 0;
		ItemStack is = null;
		ItemStack is1 = null;
		
		for (int j = 0; j < crafting.getSizeInventory(); j++) {
			ItemStack is2 = crafting.getStackInSlot(j);
			
			if (is2 == null) continue;
			if (i == 0) is = is2;
			if (i == 1) is1 = is2;
			
			i++;
		}
		
		if ((i == 2) && (is.getItem() == is1.getItem()) && (is.stackSize == 1) && (is1.stackSize == 1) && is.getItem().isRepairable()) {
			Item item = is.getItem();
			int j1 = item.getMaxDamage() - is.getItemDamageForDisplay();
			int k = item.getMaxDamage() - is1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;
			
			if (i1 < 0) i1 = 0;
			
			return new ItemStack(is.getItem(), 1, i1);
		}
		
		for (int j = 0; j < this.recipes.size(); j++) {
			IRecipe irecipe = (IRecipe)this.recipes.get(j);
			
			if (irecipe.matches(crafting, world)) return irecipe.getCraftingResult(crafting);
		}
	return null;
	}
	public List getRecipeList() { return this.recipes; }
}
