package toaru.HPW;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import toaru.Toaru;

public class BlockHighPerformanceWorkbench extends Block {

	public BlockHighPerformanceWorkbench(Material material) {
		super(material);
	}
	
	@Override
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int l, float f, float f2, float f3)
    {
        if(world.isRemote) {
        	if(!player.isSneaking()) {
        		player.openGui(Toaru.instance, 0, world, i, j, k);
        		return true;
        	}
        }
        return false;
    }
}