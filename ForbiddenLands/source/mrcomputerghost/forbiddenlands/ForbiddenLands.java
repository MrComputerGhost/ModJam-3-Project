package mrcomputerghost.forbiddenlands;

import java.util.logging.Logger;

import mrcomputerghost.forbiddenlands.biomes.BiomeGenEvilForest;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenThorns;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenWasted;
import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import mrcomputerghost.forbiddenlands.lib.ForbiddenRecipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod (modid = "ForbiddenLands", name = "Forbidden Lands", version = "3.0")
@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class ForbiddenLands 
{
	public static final Logger logger = Logger.getLogger("ForbiddenLands");
	
	
	
	
	@Instance("ForbiddenLands")
	public static ForbiddenLands instance;
        
	@SidedProxy(clientSide = "mrcomputerghost.forbiddenlands.ClientProxy", serverSide = "mrcomputerghost.forbiddenlands.CommonProxy")
	public static CommonProxy proxy; 
    
	public static CreativeTabs ForbiddenTab = new ForbiddenCreativeTab(CreativeTabs.getNextID(), "Forbidden Lands");
	
	//Biomes
	public static BiomeGenBase ForbiddenLandsBiome;
	public static BiomeGenBase ThornForest;
	public static BiomeGenBase Wasted;
	
	
        
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

        
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
		
        ForbiddenBlocks.DeathWoodDefaultID = config.getBlock("Death Logs", 4042).getInt();
        ForbiddenBlocks.DeathLeavesDefaultID = config.getBlock("Death Leaves", 4043).getInt();
        ForbiddenBlocks.DeathPlanksDefaultID = config.getBlock("Death Planks", 4044).getInt();
        ForbiddenBlocks.DeadGrassDefaultID = config.getBlock("Dead Grass", 4045).getInt();
        ForbiddenBlocks.ThornShrubDefaultID = config.getBlock("Thorn Shrub", 4046).getInt();
        ForbiddenBlocks.ThornsDefaultID = config.getBlock("Thorns", 4047).getInt();
        ForbiddenBlocks.CorruptedBarkDefaultID = config.getBlock("Corrupted Bark", 4048).getInt();
     
        config.save();
        
        ForbiddenBlocks.initBlocks(); 
        ForbiddenItems.initItems();
        ForbiddenRecipes.initRecipes();
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.ForbiddenLands", "ForbiddenLands");
        
		//Biomes
		ForbiddenLandsBiome = new BiomeGenEvilForest(42).setColor(616363).setBiomeName("ForbiddenLands").func_76733_a(9154376).setMinMaxHeight(-0.1F, 0.1F).setDisableRain();
		ThornForest = new BiomeGenThorns(43).setColor(616363).setBiomeName("ThornForest").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.3F).setDisableRain();
		Wasted = new BiomeGenWasted(44).setColor(6163).setBiomeName("Wasted").func_76733_a(9154376).setMinMaxHeight(-0.2F, -0.1F).setDisableRain();
		
		GameRegistry.addBiome(ForbiddenLandsBiome);
		GameRegistry.addBiome(ThornForest);
		GameRegistry.addBiome(Wasted);
		BiomeManager.addSpawnBiome(ForbiddenLandsBiome);
		BiomeManager.addSpawnBiome(ThornForest);
		BiomeManager.addSpawnBiome(Wasted);
	}
	
	@EventHandler
    public void load(FMLInitializationEvent event)
    {
		
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    

	public ForbiddenLands()
	{
		
        
        
	}
}