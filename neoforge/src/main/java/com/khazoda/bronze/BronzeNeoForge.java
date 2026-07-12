package com.khazoda.bronze;

import com.khazoda.bronze.registry.MainRegistry;
import com.khazoda.core.config.KhazConfigSyncNeoForge;
import com.khazoda.core.reg.KhazRegNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Constants.MOD_ID)
public class BronzeNeoForge {
  public BronzeNeoForge(IEventBus eventBus) {
    BronzeCommon.init();
    KhazConfigSyncNeoForge.registerPayloadHandlers(eventBus, Constants.CONFIG_SYNC);
    KhazRegNeoForge.init(eventBus, MainRegistry::init);
    eventBus.addListener(this::onBuildCreativeModeTabContents);
  }

  private void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
    if (MainRegistry.BRONZE_TAB.key().equals(event.getTabKey())) {
      MainRegistry.addMainTabItems(event::accept);
    }
  }
}
