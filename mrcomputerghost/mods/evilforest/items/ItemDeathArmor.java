package mrcomputerghost.mods.evilforest.items;

import mrcomputerghost.mods.evilforest.core.EvilForest;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ItemDeathArmor extends ItemArmor
{

	public ItemDeathArmor(int parl, EnumArmorMaterial par2, int par3, int par4)
	{
		super(parl, par2, par3, par4);
	}
	
	public void registerIcons(IconRegister parl)
	{
		if (this.itemID == EvilForest.DeathHelm.itemID)
		{
			itemIcon =  parl.registerIcon("ef:deathHelm");
		}
		
		if (this.itemID == EvilForest.DeathChest.itemID)
		{
			itemIcon =  parl.registerIcon("ef:deathChest");
		}
		
		if (this.itemID == EvilForest.DeathLegs.itemID)
		{
			itemIcon =  parl.registerIcon("ef:deathLegs");
		}
		
		if (this.itemID == EvilForest.DeathBoots.itemID)
		{
			itemIcon =  parl.registerIcon("ef:deathBoots");
		}
	}

}
