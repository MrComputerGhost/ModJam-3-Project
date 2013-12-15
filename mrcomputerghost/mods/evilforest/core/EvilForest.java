package mrcomputerghost.mods.evilforest.core;

import mrcomputerghost.mods.evilforest.biomes.BiomeGenEvilForest;
//import mrcomputerghost.mods.evilforest.blocks.BlockDeathWood;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
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
	
	
	//Biomes
	public static BiomeGenBase EvilForestBiome;
	
	
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		
		//Biomes
		EvilForestBiome = new BiomeGenEvilForest(42).setColor(616363).setBiomeName("EvilForest").func_76733_a(9154376).setMinMaxHeight(-0.1F, 0.1F).setDisableRain();
		
		//Blocks
		//DeathWood = new BlockDeathWood(5947, "DeathWood").setUnlocalizedName("DeathWood").setHardness(1.0F).setStepSound(Block.soundPowderFootstep).setResistance(0.0F);
		
		
		//Registering
		GameRegistry.addBiome(EvilForestBiome);
		
		//GameRegistry.registerBlock(DeathWood, "DeathWood");
		
		//LanguageRegistry.addName(DeathWood, "Death Log");
		
	}
	

	public EvilForest()
		{
	}
}