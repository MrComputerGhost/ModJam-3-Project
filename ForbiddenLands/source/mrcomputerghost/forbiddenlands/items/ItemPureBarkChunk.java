package mrcomputerghost.forbiddenlands.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class ItemPureBarkChunk extends Item {

	public ItemPureBarkChunk(int par1) {
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
	}
		
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
            this.itemIcon = par1IconRegister.registerIcon("forbiddenlands:purebarkchunk");
    }
<<<<<<< HEAD
	
	@Override
    @SideOnly(Side.CLIENT)
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
		//player.inventory.setCurrentItem(ForbiddenBlocks.FBPortal.blockID, 1, true, true);
		return par1ItemStack;
		
    }
	
=======
>>>>>>> parent of 2eb9901... ADDED A DIMENSION!!!

}
