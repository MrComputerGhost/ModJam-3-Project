package mrcomputerghost.forbiddenlands.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ForbiddenItems {
	
	public static Item PureBark;
	public static Item Rider;
	public static Item Stacker;
	
	public static int PureBarkDefaultID = 4242;
	public static int RiderDefaultID = 4243;
	public static int StackerDefaultID = 4244;
	
	public static void initItems()
    {
		PureBark = new ItemPureBark(PureBarkDefaultID);
        GameRegistry.registerItem(PureBark, "PureBark");
        LanguageRegistry.addName(PureBark, "Purified Bark Pieces");
		Rider = new ItemRider(RiderDefaultID);
		GameRegistry.registerItem(Rider, "Rider");
		LanguageRegistry.addName(Rider, "Rider");
		Stacker = new ItemStacker(StackerDefaultID);
		GameRegistry.registerItem(Stacker, "Stacker");
		LanguageRegistry.addName(Stacker, "Rider");
    }

}
