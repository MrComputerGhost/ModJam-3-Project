package mrcomputerghost.mods.evilforest.core;

import mrcomputerghost.mods.evilforest.biomes.BiomeGenEvilForest;
import mrcomputerghost.mods.evilforest.blocks.BlockDeadGrass;
import mrcomputerghost.mods.evilforest.blocks.BlockDeathLeaves;
import mrcomputerghost.mods.evilforest.blocks.BlockDeathPlanks;
import mrcomputerghost.mods.evilforest.blocks.BlockDeathWood;
import mrcomputerghost.mods.evilforest.items.ItemDeathArmor;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


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
	
	//Items
	public static Item DeathHelm;
	public static Item DeathChest;
	public static Item DeathLegs;
	public static Item DeathBoots;
	
	//Biomes
	public static BiomeGenBase EvilForestBiome;
	//public static BiomeGenBase EvilForestHills;
		
	//Enums
	public static final EnumArmorMaterial EnumArmorMaterialDeath = EnumHelper.addArmorMaterial("DeathARMOR", 33, new int[]{3, 8, 6, 3}, 10);
	
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		

		//Armor
		DeathHelm = new ItemDeathArmor(9026, EnumArmorMaterialDeath, ModLoader.addArmor("Death"), 0).setUnlocalizedName("DeathHelmet");
		DeathChest = new ItemDeathArmor(9026, EnumArmorMaterialDeath, ModLoader.addArmor("Death"), 1).setUnlocalizedName("DeathChest");
		DeathLegs = new ItemDeathArmor(9026, EnumArmorMaterialDeath, ModLoader.addArmor("Death"), 3).setUnlocalizedName("DeathHelmet");
		DeathBoots = new ItemDeathArmor(9026, EnumArmorMaterialDeath, ModLoader.addArmor("Death"), 4).setUnlocalizedName("Death Helmet");
		
		//Blocks
		DeathWood = new BlockDeathWood(4042, "DeathWood").setUnlocalizedName("DeathWood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F);
		DeathLeaves = new BlockDeathLeaves(4043, "DeathLeaves").setUnlocalizedName("DeathLeaves").setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setResistance(0.0F);
		DeathPlanks = new BlockDeathPlanks(4044, "DeathPlanks").setUnlocalizedName("DeathPlanks").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F);
		DeadGrass = new BlockDeadGrass(4045, "DeadGrass").setUnlocalizedName("DeadGrass").setHardness(1.0F).setStepSound(Block.soundGrassFootstep).setResistance(0.0F);
		
		//Biomes
		EvilForestBiome = new BiomeGenEvilForest(42).setColor(616363).setBiomeName("EvilForest").func_76733_a(9154376).setMinMaxHeight(-0.1F, 0.1F).setDisableRain();
		//EvilForestHills = new BiomeGenEvilForest(43).setColor(616363).setBiomeName("EvilForestHills").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.3F).setDisableRain();
		
		
		//Registering
		

		GameRegistry.registerBlock(DeathWood, "DeathWood");
		GameRegistry.registerBlock(DeathLeaves, "DeathLeaves");
		GameRegistry.registerBlock(DeathPlanks, "DeathPlanks");
		GameRegistry.registerBlock(DeadGrass, "DeadGrass");
		
		GameRegistry.addBiome(EvilForestBiome);
		//GameRegistry.addBiome(EvilForestHills);
		
		
		LanguageRegistry.addName(DeathWood, "Death Log");
		LanguageRegistry.addName(DeathLeaves, "Death Leaves");
		LanguageRegistry.addName(DeathPlanks, "Death Planks");
		LanguageRegistry.addName(DeadGrass, "Dead Grass");
		
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