package mrcomputerghost.mods.evilforest.core;

import mrcomputerghost.mods.evilforest.biomes.BiomeGenEvilForest;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenEnd;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "EvilForest", name = "EvilForest", version = "V.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class EvilForest 
{
	
	public static final String modid = "MrComputerGhost_EvilForest";
	
	//Biomes
	public static BiomeGenBase EvilForestBiome;
	
	
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		
		//Biomes
		EvilForestBiome = new BiomeGenEvilForest(63).setColor(616363).setBiomeName("EvilForest").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.1F).setDisableRain();
		
		
		//Registering
		GameRegistry.addBiome(EvilForestBiome);
		
		
	}
	

	public EvilForest()
	{
	
}}