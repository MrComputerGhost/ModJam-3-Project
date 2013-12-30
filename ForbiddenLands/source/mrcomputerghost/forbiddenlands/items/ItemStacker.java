package mrcomputerghost.forbiddenlands.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStacker extends Item {

	public ItemStacker(int par1) 
	{
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	
	
	public void registerIcons(IconRegister registerIcon) {
		this.itemIcon = registerIcon.registerIcon("minecraft:lead");
	}
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
		{
			if (entity.riddenByEntity != player){
				entity.mountEntity(player);
				return true;
			}
			else {
				return false;
			}
		}
	
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		switch (par1ItemStack.getItemDamage())
        {
        case 0:
        	par1ItemStack.itemID = ForbiddenItems.Rider.itemID;
            break;
        }
		return true;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
        case 0:
            list.add("Mode: Stack");
            break;
        case 1:
        	list.add("Mode: Ride");
            break;
        }
    }
	
}