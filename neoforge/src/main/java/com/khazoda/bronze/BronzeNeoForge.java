package com.khazoda.bronze;

import com.khazoda.bronze.registry.MainRegistry;
import com.khazoda.bronze.worldgen.TinOreCondition;
import com.khazoda.core.config.KhazConfigSyncNeoForge;
import com.khazoda.core.reg.KhazRegNeoForge;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@Mod(Constants.MOD_ID)
public class BronzeNeoForge {
  private static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS = DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Constants.MOD_ID);

  static {
    CONDITION_CODECS.register("generate_tin_ore", () -> TinOreCondition.CODEC);
  }

  public BronzeNeoForge(IEventBus eventBus) {
    BronzeCommon.init();
    KhazConfigSyncNeoForge.registerPayloadHandlers(eventBus, Constants.CONFIG_SYNC);
    KhazRegNeoForge.init(eventBus, MainRegistry::init);
    eventBus.addListener(this::onBuildCreativeModeTabContents);
    CONDITION_CODECS.register(eventBus);
  }

  private void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
    if (MainRegistry.BRONZE_TAB.key().equals(event.getTabKey())) {
      MainRegistry.addMainTabItems(event::accept);
    }
  }
}
