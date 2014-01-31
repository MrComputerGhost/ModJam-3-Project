package mrcomputerghost.forbiddenlands.dim;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderForbidden2 extends WorldProvider
{
public void registerWorldChunkManager()
{
/** tells Minecraft to use our new WorldChunkManager **/
this.worldChunkMgr = new WorldChunkMangerForbidden2(worldObj.getSeed(), terrainType);
this.hasNoSky = true;
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
return DimensionManager.createProviderFor(ForbiddenDimensions.dimID);
}

/** Welcome message **/
public String getWelcomeMessage()
{
return "Entering Forbidden Lands";
}

/** What chunk provider to use **/
public IChunkProvider createChunkGenerator()
{
return new ChunkProviderForbidden2(worldObj, worldObj.getSeed(), true);
}

/** Can player re-spawn here **/
public boolean canRespawnHere()
{
return false;
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
return -42;
}

/** Dimension Movement speed **/
public double getMovementFactor()
{
return 10.0;
}
}