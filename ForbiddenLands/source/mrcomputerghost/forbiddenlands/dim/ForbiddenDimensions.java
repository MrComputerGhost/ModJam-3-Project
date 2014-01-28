package mrcomputerghost.forbiddenlands.dim;

import net.minecraftforge.common.DimensionManager;

public class ForbiddenDimensions {

	public static int dimID = -42;

	public static void initDims() {
		DimensionManager.registerProviderType(dimID,
				WorldProviderForbidden2.class, true);
		DimensionManager.registerDimension(dimID, dimID);

	}

}
