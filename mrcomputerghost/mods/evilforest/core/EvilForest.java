package mrcomputerghost.mods.evilforest.core;

import mrcomputerghost.mods.evilforest.biomes.BiomeGenEvilForest;
import mrcomputerghost.mods.evilforest.biomes.BiomeGenThorns;
import mrcomputerghost.mods.evilforest.biomes.BiomeGenWasted;
import mrcomputerghost.mods.evilforest.blocks.BlockDeadGrass;
import mrcomputerghost.mods.evilforest.blocks.BlockDeathLeaves;
import mrcomputerghost.mods.evilforest.blocks.BlockDeathPlanks;
import mrcomputerghost.mods.evilforest.blocks.BlockDeathWood;
import mrcomputerghost.mods.evilforest.blocks.BlockThornShrub;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.*;


@Mod(modid = "EvilForest", name = "EvilForest", version = "V.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class EvilForest 
{	
	public static final String modid = "MrComputerGhost_EvilForest";

	//Blocks
	public static Block DeathWood;
	public static Block DeathLeaves;
	public static Block DeathPlanks;
	public static Block DeadGrass;
	public static Block ThornShrub;
	
	//Biomes
	public static BiomeGenBase EvilForestBiome;
	public static BiomeGenBase ThornForest;
	public static BiomeGenBase Wasted;
		
	
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
	
		
		//Blocks
		DeathWood = new BlockDeathWood(4042, "DeathWood").setUnlocalizedName("DeathWood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F);
		DeathLeaves = new BlockDeathLeaves(4043, "DeathLeaves").setUnlocalizedName("DeathLeaves").setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setResistance(0.0F);
		DeathPlanks = new BlockDeathPlanks(4044, "DeathPlanks").setUnlocalizedName("DeathPlanks").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F);
		//DeadGrass = new BlockDeadGrass(4045, "DeadGrass").setUnlocalizedName("DeadGrass").setHardness(1.0F).setStepSound(Block.soundGrassFootstep).setResistance(0.0F);
		ThornShrub = new BlockThornShrub(4046, "ThornShrub").setUnlocalizedName("ThornShrub").setHardness(1.5F).setStepSound(Block.soundLadderFootstep).setResistance(1.0F);
		
		//Biomes
		EvilForestBiome = new BiomeGenEvilForest(42).setColor(616363).setBiomeName("EvilForest").func_76733_a(9154376).setMinMaxHeight(-0.1F, 0.1F).setDisableRain();
		ThornForest = new BiomeGenThorns(43).setColor(616363).setBiomeName("EvilForestHills").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.3F).setDisableRain();
		Wasted = new BiomeGenWasted(44).setColor(6163).setBiomeName("Wasted").func_76733_a(9154376).setMinMaxHeight(-0.2F, -0.1F).setDisableRain();
		
		//Registering
		GameRegistry.registerBlock(DeathWood, "DeathWood");
		GameRegistry.registerBlock(DeathLeaves, "DeathLeaves");
		GameRegistry.registerBlock(DeathPlanks, "DeathPlanks");
		//GameRegistry.registerBlock(DeadGrass, "DeadGrass");
		GameRegistry.registerBlock(ThornShrub, "ThornShrub");
		
		GameRegistry.addBiome(EvilForestBiome);
		GameRegistry.addBiome(ThornForest);
		GameRegistry.addBiome(Wasted);
				
		LanguageRegistry.addName(DeathWood, "Death Log");
		LanguageRegistry.addName(DeathLeaves, "Death Leaves");
		LanguageRegistry.addName(DeathPlanks, "Death Planks");
		LanguageRegistry.addName(DeadGrass, "Dead Grass");
		LanguageRegistry.addName(ThornShrub, "Thorn Shrub");
		
		//Hooks
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(EvilForest.DeathPlanks), 1, 5, 25));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(EvilForest.DeathPlanks), 1, 5, 25));
		MinecraftForge.addGrassPlant(ThornShrub, 0, 1);
		
		GameRegistry.addShapelessRecipe(new ItemStack(EvilForest.DeathPlanks, 4), new Object[]
				{
						new ItemStack(EvilForest.DeathWood)
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 4), new Object[]
				{
						new ItemStack(EvilForest.DeathPlanks), new ItemStack(EvilForest.DeathPlanks)
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.workbench), new Object[]
				{
						new ItemStack(EvilForest.DeathPlanks), new ItemStack(EvilForest.DeathPlanks), new ItemStack(EvilForest.DeathPlanks), new ItemStack(EvilForest.DeathPlanks)
				});
		
		GameRegistry.addRecipe(new ItemStack(Item.swordWood, 1),new Object[]
                {
                        "0L0", "0L0", "0S0", 'L', EvilForest.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood, 1),new Object[]
                {
                        "LLL", "0S0", "0S0", 'L', EvilForest.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.shovelWood, 1),new Object[]
                {
                        "0L0", "0S0", "0S0", 'L', EvilForest.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1),new Object[]
                {
                        "0LL", "0SL", "0S0", 'L', EvilForest.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1),new Object[]
                {
                        "0LL", "0S0", "0S0", 'L', EvilForest.DeathPlanks, 'S', Item.stick
                });
		GameRegistry.addRecipe(new ItemStack(Block.chest), new Object[]
				{
						"WWW", "W0W", "WWW", 'W', EvilForest.DeathPlanks
				});
		

		
	}
	

	public EvilForest()
		{
	}
}