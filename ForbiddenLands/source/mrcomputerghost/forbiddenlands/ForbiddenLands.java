package mrcomputerghost.forbiddenlands;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import mrcomputerghost.forbiddenlands.biomes.BiomeGenEnchantedForest;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenEvilForest;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenGraves;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenThorns;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenWasted;
import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.handlers.CraftingHandler;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import mrcomputerghost.forbiddenlands.lib.ForbiddenRecipes;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.ICraftingHandler;
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
import net.minecraft.stats.Achievement;



@Mod (modid = "ForbiddenLands", name = "Forbidden Lands", version = "3.5")
@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class ForbiddenLands 
{
	public static final Logger logger = Logger.getLogger("ForbiddenLands");
	
	public static int probabilityOfBecomingAware;
	
	
	@Instance("ForbiddenLands")
	public static ForbiddenLands instance;
        
	@SidedProxy(clientSide = "mrcomputerghost.forbiddenlands.ClientProxy", serverSide = "mrcomputerghost.forbiddenlands.CommonProxy")
	public static CommonProxy proxy; 
    
	public static CreativeTabs ForbiddenTab = new ForbiddenCreativeTab(CreativeTabs.getNextID(), "Forbidden Lands");
	
	//Biomes
	public static BiomeGenBase ForbiddenLandsBiome;
	public static BiomeGenBase ThornForest;
	public static BiomeGenBase Wasted;
	public static BiomeGenBase EnchantedForest;
	public static BiomeGenBase EnchantedForestHills;
	public static BiomeGenBase ForbiddenHills;
	public static BiomeGenBase Graveyard;
        
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
        BiomeGenThorns.UseOldThornBushes = config.get("BiomeStuff", "UseOldThornBushes", false).getBoolean(false);
        
        config.save();
        
        ForbiddenBlocks.initBlocks(); 
        ForbiddenItems.initItems();
        ForbiddenRecipes.initRecipes();
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.ForbiddenLands", "ForbiddenLands");
        
		//Biomes
		ForbiddenLandsBiome = new BiomeGenEvilForest(42).setColor(616363).setBiomeName("Forbidden Lands").func_76733_a(9154376).setMinMaxHeight(-0.1F, 0.1F).setDisableRain();
		ThornForest = new BiomeGenThorns(43).setColor(616363).setBiomeName("Thorn Forest").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.3F).setDisableRain();
		Wasted = new BiomeGenWasted(44).setColor(6163).setBiomeName("Wasteland").func_76733_a(9154376).setMinMaxHeight(-0.2F, -0.1F).setDisableRain();
		EnchantedForest = new BiomeGenEnchantedForest(45).setColor(10000).setBiomeName("Enchanted Forest").setMinMaxHeight(-0.2F, 0.2F).setDisableRain();
		EnchantedForestHills = new BiomeGenEnchantedForest(46).setColor(10000).setBiomeName("Enchanted Forest Hills").setMinMaxHeight(-0.3F, 0.3F).setDisableRain();
		Graveyard = new BiomeGenGraves(47).setColor(99999).setBiomeName("Graveyard").setMinMaxHeight(-0.1F, 0.1F).setDisableRain();
		
		GameRegistry.addBiome(ForbiddenLandsBiome);
		GameRegistry.addBiome(ThornForest);
		GameRegistry.addBiome(Wasted);
		GameRegistry.addBiome(EnchantedForest);
		GameRegistry.addBiome(EnchantedForestHills);
		GameRegistry.addBiome(Graveyard);
		BiomeManager.addSpawnBiome(ForbiddenLandsBiome);
		BiomeManager.addSpawnBiome(ThornForest);
		BiomeManager.addSpawnBiome(Wasted);
		BiomeManager.addSpawnBiome(EnchantedForest);
		BiomeManager.addSpawnBiome(EnchantedForestHills);
		BiomeManager.addVillageBiome(EnchantedForest, true);
		BiomeManager.addVillageBiome(EnchantedForestHills, true);
		BiomeManager.addVillageBiome(Wasted, false);
		BiomeManager.addVillageBiome(ForbiddenLandsBiome, false);
		BiomeManager.addStrongholdBiome(ForbiddenLandsBiome);
		BiomeManager.addStrongholdBiome(EnchantedForestHills);
		BiomeDictionary.registerAllBiomesAndGenerateEvents();
		
		
		
		
		
		
	}
	
	@EventHandler
    public void load(FMLInitializationEvent event)
    {
		/**Forbidden = new Achievement(35, "ForbiddenAchievement", 0, 0, ForbiddenItems.Rider, null).registerAchievement();

		this.addAchievementName("ForbiddenAchievement", "I'll Ride You...");
		this.addAchievementDesc("ForbiddenAchievement", "Ride another player");
		
		GameRegistry.registerCraftingHandler(new CraftingHandler());**/
    }
    
	/**private void addAchievementName(String ach, String name)
	{
	LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}

	private void addAchievementDesc(String ach, String desc)
	{
	LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);**/
	//}
	
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    
    
	public ForbiddenLands()
	{
		     
	}
	
}