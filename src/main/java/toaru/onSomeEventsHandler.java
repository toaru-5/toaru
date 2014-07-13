package toaru;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class onSomeEventsHandler {
	
	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		if (event.crafting.getItem().equals(Objects.compressed_air)) {
			event.player.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 3));
		}
	}
	
	/**
	 * 書き途中
	 * @deprecated
	 */
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (Objects.goggleKey.isPressed());
	}
}
