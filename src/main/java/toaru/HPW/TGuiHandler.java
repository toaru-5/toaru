package toaru.HPW;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class TGuiHandler implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int arg0, EntityPlayer arg1, World arg2,
			int arg3, int arg4, int arg5) {
		return arg0 == 0 && arg2.getBlock(arg3, arg4, arg5) instanceof BlockHighPerformanceWorkbench ? new GuiHighPerformanceWorkbench(arg1.inventory, arg2, arg3, arg4, arg5) : null;
	}

	@Override
	public Object getServerGuiElement(int arg0, EntityPlayer arg1, World arg2,
			int arg3, int arg4, int arg5) {
		return arg0 == 0 && arg2.getBlock(arg3, arg4, arg5) instanceof BlockHighPerformanceWorkbench ? new ContainerHighPerformanceWorkbench(arg1.inventory, arg2, arg3, arg4, arg5) : null;
	}
}
