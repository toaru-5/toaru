package toaru.HPW;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiHighPerformanceWorkbench extends GuiContainer {

	private static final ResourceLocation highPerformanceWorkbenchTextures = new ResourceLocation("textures/gui/container/highperformanceworkbench.png");
	public GuiHighPerformanceWorkbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
	{
		super(new ContainerHighPerformanceWorkbench(par1InventoryPlayer, par2World, par3, par4, par5));
		this.xSize = 256;
		this.ySize = 248;
		
	}
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("High Performance"), 120, 5, 0x000000);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0,
			int arg1, int arg2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(highPerformanceWorkbenchTextures);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}