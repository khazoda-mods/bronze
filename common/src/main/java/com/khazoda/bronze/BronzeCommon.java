package com.khazoda.bronze;

import com.khazoda.bronze.platform.Services;
import com.khazoda.core.config.KhazConfig;

public final class BronzeCommon {
  public static final KhazConfig.Entry<Integer> SICKLE_HARVEST_RANGE = KhazConfig.integer("sickle_harvest_range", 2, 1, 12, "How far the sickle reaches when harvesting crops.");
  public static final KhazConfig.Entry<Integer> SICKLE_MOW_RANGE = KhazConfig.integer("sickle_mow_range", 4, 1, 12, "How far the sickle reaches when mowing grasslike blocks.");
  public static final KhazConfig CONFIG = KhazConfig.of(Constants.MOD_NAME, Constants.MOD_ID, Services.PLATFORM.getConfigDirectory(), SICKLE_HARVEST_RANGE, SICKLE_MOW_RANGE);

  private BronzeCommon() {
  }

  public static void init() {
    CONFIG.load();
    Services.PLATFORM.registerServerConfigSync(CONFIG);
    if (Services.PLATFORM.isModLoaded(Constants.MOD_ID)) Constants.LOG.info("- Bronze Loaded -");
  }
}
