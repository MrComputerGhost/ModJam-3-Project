package mrcomputerghost.forbiddenlands.wallclimbingslime;

import mrcomputerghost.forbiddenlands.models.EntityRainbowSlime;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraft.item.*;

public class DropRainbowCrystal {
	@ForgeSubscribe
    public void onEntityDrop(LivingDropsEvent event) {
	if(event.entity instanceof EntityRainbowSlime) {
  		  event.entity.entityDropItem(new ItemStack(Item.slimeBall, 1, 10), 0.0F);
  	  }
    }
}
