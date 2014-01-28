package mrcomputerghost.forbiddenlands.dim;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderForbidden2 extends WorldProvider {
	public void registerWorldChunkManager() {
		/** tells Minecraft to use our new WorldChunkManager **/
		this.worldChunkMgr = new WorldChunkMangerForbidden2(worldObj.getSeed(),
				terrainType);
		this.hasNoSky = true;
	}

	@Override
	/** Dimension Name **/
	public String getDimensionName() {
		return "Forbidden Lands";
	}

	/** Get Provider for dimension **/
	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(ForbiddenDimensions.dimID);
	}

	public int getAverageGroundLevel() {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int par1, int par2) {
		return false;
	}

	public boolean renderStars() {
		return true;
	}

	public float getStarBrightness(World world, float f) {
		return 10.0F;
	}

	public boolean renderClouds() {
		return true;
	}

	public boolean renderVoidFog() {
		return true;
	}

	public boolean renderEndSky() {
		return true;
	}

	public float setSunSize() {
		return 10.0F;
	}

	public float setMoonSize() {
		return 10.0F;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return true;
	}

	public boolean isSurfaceWorld() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return 128.0F;
	}

	@SideOnly(Side.CLIENT)
	public String getSunTexture() {
		return "minecraft:moon.png";
	}

	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}

	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(50, 5, 0);
	}

	protected void generateLightBrightnessTable() {
		float f = 12.0F;
		for (int i = 0; i <= 15; i++) {
			float f1 = 12.0F - i / 15.0F;
			this.lightBrightnessTable[i] = ((1.0F - f1) / (f1 * 3.0F + 1.0F)
					* (1.0F - f) + f);
		}
	}

	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage() {
		if ((this instanceof WorldProviderForbidden2)) {
			return "Entering Forbidden Lands";
		}
		return null;
	}

	/** What chunk provider to use **/
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderForbidden2(worldObj, worldObj.getSeed(), true);
	}

	/** Can player re-spawn here **/
	public boolean canRespawnHere() {
		return true;
	}

	/** Set user message **/
	// not sure if this works any more ?
	protected synchronized String setUserMessage(String par1Str) {
		return "Building Forbidden Lands";
	}

	/** Determines the dimension the player will be respawned in **/
	public int getRespawnDimension(EntityPlayerMP player) {
		return -42;
	}

	/** Dimension Movement speed **/
	public double getMovementFactor() {
		return 10.0;
	}

	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float par1, float par2) {
		int i = 10518688;
		float f2 = MathHelper.cos(par1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		float f3 = (i >> 16 & 0xFF) / 255.0F;
		float f4 = (i >> 8 & 0xFF) / 255.0F;
		float f5 = (i & 0xFF) / 255.0F;
		f3 *= (f2 * 0.0F + 0.15F);
		f4 *= (f2 * 0.0F + 0.15F);
		f5 *= (f2 * 0.0F + 0.15F);
		return this.worldObj.getWorldVec3Pool().getVecFromPool(f3, f4, f5);
	}
}