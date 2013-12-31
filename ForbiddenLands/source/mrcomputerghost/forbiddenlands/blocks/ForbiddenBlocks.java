package mrcomputerghost.forbiddenlands.blocks;

import mrcomputerghost.forbiddenlands.ForbiddenLands;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
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
	public static Block Thorns;
	public static Block CorruptedBark;
	
	public static int DeathWoodDefaultID;
	public static int DeathLeavesDefaultID;
	public static int DeathPlanksDefaultID;
	public static int DeadGrassDefaultID;
	public static int ThornShrubDefaultID;
	public static int ThornsDefaultID;
	public static int CorruptedBarkDefaultID;
	
	public static void initBlocks()
	{
		DeathWood = new BlockDeathWood(4042, "DeathWood").setUnlocalizedName("DeathWood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		DeathLeaves = new BlockDeathLeaves(4043, "DeathLeaves").setUnlocalizedName("DeathLeaves").setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		DeathPlanks = new BlockDeathPlanks(4044, "DeathPlanks").setUnlocalizedName("DeathPlanks").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		DeadGrass = new BlockDeadGrass(4045, "DeadGrass").setUnlocalizedName("DeadGrass").setHardness(1.0F).setStepSound(Block.soundGrassFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		ThornShrub = new BlockThornShrub(4046, "ThornShrub").setUnlocalizedName("ThornShrub").setHardness(1.5F).setStepSound(Block.soundLadderFootstep).setResistance(1.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		Thorns = new BlockThorns(4047, "Thorns").setUnlocalizedName("Thorns").setHardness(0.5F).setStepSound(Block.soundLadderFootstep).setResistance(1.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		CorruptedBark = new BlockCorruptedBark(4048, "CorruptedBark").setUnlocalizedName("CorruptedBark").setHardness(0.7F).setStepSound(Block.soundLadderFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		
		GameRegistry.registerBlock(DeathWood, "DeathWood");
		GameRegistry.registerBlock(DeathLeaves, "DeathLeaves");
		GameRegistry.registerBlock(DeathPlanks, "DeathPlanks");
		GameRegistry.registerBlock(DeadGrass, "DeadGrass");
		GameRegistry.registerBlock(ThornShrub, "ThornShrub");
		GameRegistry.registerBlock(Thorns, "Thorns");
		GameRegistry.registerBlock(CorruptedBark, "CorruptedBark");
		
		LanguageRegistry.addName(DeathWood, "Death Log");
		LanguageRegistry.addName(DeathLeaves, "Death Leaves");
		LanguageRegistry.addName(DeathPlanks, "Death Planks");
		LanguageRegistry.addName(DeadGrass, "Dead Grass");
		LanguageRegistry.addName(ThornShrub, "Thorn Shrub");
		LanguageRegistry.addName(Thorns, "Deadly Sharp Thorns");
		LanguageRegistry.addName(CorruptedBark, "Corrupted Barks");
		
		MinecraftForge.addGrassPlant(ThornShrub, 0, 25);
		MinecraftForge.addGrassSeed(new ItemStack(Item.pumpkinSeeds), 25);
		MinecraftForge.addGrassSeed(new ItemStack(Item.melonSeeds), 25);
		MinecraftForge.addGrassSeed(new ItemStack(ThornShrub), 5);
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ForbiddenBlocks.DeathPlanks), 1, 5, 25));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ForbiddenBlocks.DeathPlanks), 1, 5, 25));
		
		
		
	}

}