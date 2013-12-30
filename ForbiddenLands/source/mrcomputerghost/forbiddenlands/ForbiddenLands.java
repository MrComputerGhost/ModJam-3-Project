package mrcomputerghost.forbiddenlands;

import java.util.logging.Logger;

import mrcomputerghost.forbiddenlands.biomes.BiomeGenEvilForest;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenThorns;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenWasted;
import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import mrcomputerghost.forbiddenlands.lib.ForbiddenRecipes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
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


@Mod (modid = "ForbiddenLands", name = "Forbidden Lands", version = "2.0")
@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class ForbiddenLands 
{
	public static final Logger logger = Logger.getLogger("ForbiddenLands");
	
	@Instance("ForbiddenLands")
	public static ForbiddenLands instance;
        
	@SidedProxy(clientSide = "mrcomputerghost.forbiddenlands.ClientProxy", serverSide = "mrcomputerghost.forbiddenlands.CommonProxy")
	public static CommonProxy proxy; 
    	
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
		
		
		
		}
	
	@EventHandler
    public void load(FMLInitializationEvent event)
    {
		
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("Forbidden Lands Mod Initialized");    
    }
    

	public ForbiddenLands()
	{
		logger.setParent(FMLCommonHandler.instance().getFMLLogger());
        if (Loader.isModLoaded("magitech"))
        {
            System.out.println("[ForbiddenLands] Give me the bacon, Hammer");
        }
        if (Loader.isModLoaded("glowglass"))
        {
            System.out.println("[ForbiddenLands] Prepare the traps, the Slimes are invading!");
        }
        if (Loader.isModLoaded("OreSpiders"))
        {
            System.out.println("[ForbiddenLands] The Spiders are comming!");
        }
	}
}