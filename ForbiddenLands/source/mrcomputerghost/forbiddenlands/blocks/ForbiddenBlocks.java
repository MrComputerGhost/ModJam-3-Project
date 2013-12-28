package mrcomputerghost.forbiddenlands.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ForbiddenBlocks {
	
	
	public static Block DeathWood;
	public static Block DeathLeaves;
	public static Block DeathPlanks;
	public static Block DeadGrass;
	public static Block ThornShrub;
	
	public static int DeathWoodDefaultID;
	public static int DeathLeavesDefaultID;
	public static int DeathPlanksDefaultID;
	public static int DeadGrassDefaultID;
	public static int ThornShrubDefaultID;
	
	public static void initBlocks()
	{
		DeathWood = new BlockDeathWood(4042, "DeathWood").setUnlocalizedName("DeathWood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F);
		DeathLeaves = new BlockDeathLeaves(4043, "DeathLeaves").setUnlocalizedName("DeathLeaves").setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setResistance(0.0F);
		DeathPlanks = new BlockDeathPlanks(4044, "DeathPlanks").setUnlocalizedName("DeathPlanks").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F);
		DeadGrass = new BlockDeadGrass(4045, "DeadGrass").setUnlocalizedName("DeadGrass").setHardness(1.0F).setStepSound(Block.soundGrassFootstep).setResistance(0.0F);
		ThornShrub = new BlockThornShrub(4046, "ThornShrub").setUnlocalizedName("ThornShrub").setHardness(1.5F).setStepSound(Block.soundLadderFootstep).setResistance(1.0F);
		
		GameRegistry.registerBlock(DeathWood, "DeathWood");
		GameRegistry.registerBlock(DeathLeaves, "DeathLeaves");
		GameRegistry.registerBlock(DeathPlanks, "DeathPlanks");
		GameRegistry.registerBlock(DeadGrass, "DeadGrass");
		GameRegistry.registerBlock(ThornShrub, "ThornShrub");
		
		LanguageRegistry.addName(DeathWood, "Death Log");
		LanguageRegistry.addName(DeathLeaves, "Death Leaves");
		LanguageRegistry.addName(DeathPlanks, "Death Planks");
		LanguageRegistry.addName(DeadGrass, "Dead Grass");
		LanguageRegistry.addName(ThornShrub, "Thorn Shrub");
		
		MinecraftForge.addGrassPlant(ThornShrub, 0, 1);
		

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ForbiddenBlocks.DeathPlanks), 1, 5, 25));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ForbiddenBlocks.DeathPlanks), 1, 5, 25));
		
		
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