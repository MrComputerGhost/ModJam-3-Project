package mrcomputerghost.mods.evilforest.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import mrcomputerghost.mods.evilforest.trees.WorldGenEvilForest1;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenEvilForest extends BiomeGenBase
{
    private WorldGenFlowers mushroomBrownGen;

	public BiomeGenEvilForest(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 42;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 1;
        this.theBiomeDecorator.mushroomsPerChunk = 87;
        this.theBiomeDecorator.reedsPerChunk = 10;
        this.theBiomeDecorator.clayPerChunk = 5;
        this.theBiomeDecorator.waterlilyPerChunk = 6;
        this.mushroomBrownGen = new WorldGenFlowers(Block.pumpkin.blockID);
        this.waterColorMultiplier = 15745542;
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 5, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 5, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 4, 4));
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return new WorldGenEvilForest1();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        double d0 = (double)this.getFloatTemperature();
        double d1 = (double)this.getFloatRainfall();
        return ((ColorizerGrass.getGrassColor(d0, d1) & 16711422) + 5115470) / 2;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        double d0 = (double)this.getFloatTemperature();
        double d1 = (double)this.getFloatRainfall();
        return ((ColorizerFoliage.getFoliageColor(d0, d1) & 16711422) + 5115470) / 2;
    }
    
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
}
