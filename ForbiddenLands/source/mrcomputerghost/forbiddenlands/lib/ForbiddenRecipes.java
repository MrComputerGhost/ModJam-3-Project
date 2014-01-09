package mrcomputerghost.forbiddenlands.lib;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class ForbiddenRecipes {

    
    public static void initRecipes()
    {    
    	FurnaceRecipes.smelting().addSmelting(ForbiddenBlocks.DeathWood.blockID, 0, new ItemStack(ForbiddenBlocks.CorruptedBark, 1, 0), 1.0f);
    	FurnaceRecipes.smelting().addSmelting(ForbiddenItems.ParadoxShard.itemID, 0, new ItemStack(ForbiddenItems.ParadoxCrystal, 1, 0), 1.0f);
    	FurnaceRecipes.smelting().addSmelting(ForbiddenItems.ParadoxDust.itemID, 0, new ItemStack(ForbiddenItems.ParadoxShard, 1, 0), 1.0f);
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenBlocks.DeathPlanks, 4), new Object[]{new ItemStack(ForbiddenBlocks.DeathWood)});
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenBlocks.Thorns, 4), new Object[]{new ItemStack(ForbiddenBlocks.ThornShrub)});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 4), new Object[]{new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks)});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.workbench), new Object[]{new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks)});
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenItems.Rider, 4), new Object[]{new ItemStack(Item.leash), new ItemStack(Item.saddle)});
		GameRegistry.addRecipe(new ItemStack(Item.swordWood, 1),new Object[]{"0L0", "0L0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood, 1),new Object[]{"LLL", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.shovelWood, 1),new Object[]{"0L0", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1),new Object[]{"0LL", "0SL", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1),new Object[]{"0LL", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Block.chest), new Object[]{"WWW", "W0W", "WWW", 'W', ForbiddenBlocks.DeathPlanks});
        GameRegistry.addRecipe(new ItemStack(Item.saddle), new Object[]{"ABA", "AAA", "S00", 'A', Item.leather, 'B', Block.cloth, 'S', Item.silk});   
        GameRegistry.addRecipe(new ItemStack(ForbiddenItems.ParadoxPick), new Object[]{"AAA", "0S0", "0S0", 'A', ForbiddenItems.ParadoxCrystal, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ForbiddenItems.ParadoxSword), new Object[]{"0A0", "0A0", "0S0", 'A', ForbiddenItems.ParadoxCrystal, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ForbiddenItems.ParadoxBow), new Object[]{"SA0", "S0A", "SA0", 'A', ForbiddenItems.ParadoxCrystal, 'S', Item.silk});
    }
}