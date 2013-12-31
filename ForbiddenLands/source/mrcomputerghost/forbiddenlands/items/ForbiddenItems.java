package mrcomputerghost.forbiddenlands.items;

import mrcomputerghost.forbiddenlands.ForbiddenCreativeTab;
import mrcomputerghost.forbiddenlands.ForbiddenLands;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ForbiddenItems {
	
	public static Item PureBark;
	public static Item Rider;
	public static Item Stacker;
	public static Item PureBarkChunk;
	public static Item ParadoxDust;
	public static Item ParadoxCrystal;
	public static Item ParadoxShard;
	public static Item ParadoxSword;
	public static Item ParadoxPick;
	
	public static int PureBarkDefaultID = 4242;
	public static int RiderDefaultID = 4243;
	public static int StackerDefaultID = 4244;
	public static int PureBarkChunkDefaultID = 4245;
	public static int ParadoxDustDefaultID = 4246;
	public static int ParadoxCrystalDefaultID = 4247;
	public static int ParadoxShardDefaultID = 4248;
	public static int ParadoxSwordDefaultID = 4249;
	public static int ParadoxPickDefaultID = 4250;
	
	public static final EnumToolMaterial EnumToolParadox = EnumHelper.addToolMaterial("PARADOX", 3, 2570, 10.0F, 4.5F, 35);
	
	public static void initItems()
    {
		PureBark = new ItemPureBark(PureBarkDefaultID).setUnlocalizedName("Pure Bark").setTextureName("forbiddenlands:purebark").setCreativeTab(ForbiddenLands.ForbiddenTab);
        GameRegistry.registerItem(PureBark, "Pure Bark");
        LanguageRegistry.addName(PureBark, "Purified Bark");
        Rider = new ItemRider(RiderDefaultID).setUnlocalizedName("Rider").setTextureName("minecraft:lead").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(Rider, "Rider");
		LanguageRegistry.addName(Rider, "Rider");
		Stacker = new ItemStacker(StackerDefaultID).setUnlocalizedName("Stacker").setTextureName("minecraft:lead");
		GameRegistry.registerItem(Stacker, "Stacker");
		LanguageRegistry.addName(Stacker, "Rider");
		PureBarkChunk = new ItemPureBarkChunk(PureBarkChunkDefaultID).setUnlocalizedName("Pure Bark Chunk").setTextureName("forbiddenlands:purebarkchunk").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(PureBarkChunk, "Pure Bark Chunk");
		LanguageRegistry.addName(PureBarkChunk, "Purified Bark Chunk");
		ParadoxDust = new ItemParadoxDust(ParadoxDustDefaultID).setUnlocalizedName("Paradox Dust").setTextureName("forbiddenlands:paradoxdust").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxDust, "Paradox Dust");
		LanguageRegistry.addName(ParadoxDust, "Paradox Dust");
		ParadoxCrystal = new ItemParadoxCrystal(ParadoxCrystalDefaultID).setUnlocalizedName("Paradox Crystal").setTextureName("forbiddenlands:paradoxcrystal").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxCrystal, "Paradox Crystal");
		LanguageRegistry.addName(ParadoxCrystal, "Paradox Crystal");
		ParadoxShard = new ItemParadoxShard(ParadoxShardDefaultID).setUnlocalizedName("Paradox Shard").setTextureName("forbiddenlands:paradoxshard").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxShard, "Paradox Shard");
		LanguageRegistry.addName(ParadoxShard, "Paradox Shard");
		ParadoxSword = new ItemParadoxSword(ParadoxSwordDefaultID, EnumToolParadox).setUnlocalizedName("Paradox Sword").setTextureName("forbiddenlands:paradoxsword").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxSword, "Paradox Sword");
		LanguageRegistry.addName(ParadoxSword, "Paradox Sword");
		ParadoxPick = new ItemParadoxPick(ParadoxPickDefaultID, EnumToolParadox).setUnlocalizedName("Paradox Pick").setTextureName("forbiddenlands:paradoxpick").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxPick, "Paradox Pick");
		LanguageRegistry.addName(ParadoxPick, "Paradox Pick");
    }

}
