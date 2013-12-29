package mrcomputerghost.forbiddenlands.items;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ForbiddenItems {
	
	public static Item PureBark;
	
	public static int PureBarkDefaultID = 4242;
	
	public static void initItems()
    {
		PureBark = new ItemPureBark(PureBarkDefaultID);
        GameRegistry.registerItem(PureBark, "PureBark");
        LanguageRegistry.addName(PureBark, "Purified Bark Pieces");
		 
		 
		 
    }

}
