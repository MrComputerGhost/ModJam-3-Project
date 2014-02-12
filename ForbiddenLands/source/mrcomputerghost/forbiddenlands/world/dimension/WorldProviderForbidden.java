package mrcomputerghost.forbiddenlands.world.dimension;

import mrcomputerghost.forbiddenlands.ForbiddenLands;
import net.minecraft.block.Block;
import net.minecraft.client.main.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderForbidden extends WorldProvider {

	public void registerWorldChunkManager()
	{
		/** tells Minecraft to use our new WorldChunkManager **/
		this.worldChunkMgr = new WorldChunkMangerForbidden(worldObj.getSeed(), terrainType);
		this.hasNoSky = false;
	}

	@Override
	/** Dimension Name **/
	public String getDimensionName()
	{
		return "Forbidden Lands";
	}

	/** Get Provider for dimension **/
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(ForbiddenLands.ForbiddenDimID);
	}

	/** Welcome message **/
	public String getWelcomeMessage()
	{
		return "Entering the Forbidden Lands";
	}

	/** What chunk provider to use **/
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderForbidden(worldObj, worldObj.getSeed(), true);
	}

	/** Can player re-spawn here **/
	public boolean canRespawnHere()
	{
		return true;
	}

	/** Set user message **/
	// not sure if this works any more ?
	protected synchronized String setUserMessage(String par1Str)
	{
		return "Building Forbidden Lands";
	}

	/** Determines the dimension the player will be respawned in **/
	public int getRespawnDimension(EntityPlayerMP player)
	{
		return 42;
	}

	/** Dimension Movement speed **/
	public double getMovementFactor()
	{
		return 4.2;
	}
	
}