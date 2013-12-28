package mrcomputerghost.forbiddenlands.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ForbiddenRecipes {

    
    
    public static void initRecipes()
    {
            
    	GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenBlocks.DeathPlanks, 4), new Object[]
				{
						new ItemStack(ForbiddenBlocks.DeathWood)
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 4), new Object[]
				{
						new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks)
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.workbench), new Object[]
				{
						new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks)
				});
		
		GameRegistry.addRecipe(new ItemStack(Item.swordWood, 1),new Object[]
                {
                        "0L0", "0L0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood, 1),new Object[]
                {
                        "LLL", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.shovelWood, 1),new Object[]
                {
                        "0L0", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1),new Object[]
                {
                        "0LL", "0SL", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1),new Object[]
                {
                        "0LL", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Block.chest), new Object[]
				{
						"WWW", "W0W", "WWW", 'W', ForbiddenBlocks.DeathPlanks
				});
            
    }
}