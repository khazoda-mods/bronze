package com.khazoda.bronze.platform;

import com.khazoda.bronze.BronzeCommon;
import com.khazoda.bronze.Constants;
import com.khazoda.core.config.KhazConfigSyncFabric;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class FabricConfigSyncClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    KhazConfigSyncFabric.registerClientboundPayloadType(Constants.CONFIG_SYNC);
    registerServerConfigReceiver();
    registerDisconnectReloadListener();
  }

  private static void registerServerConfigReceiver() {
    ClientPlayNetworking.registerGlobalReceiver(Constants.CONFIG_SYNC.type(), (payload, context) -> BronzeCommon.CONFIG.applyServerSyncedValues(payload.serverValues()));
  }

  private static void registerDisconnectReloadListener() {
    ClientPlayConnectionEvents.DISCONNECT.register((listener, client) -> BronzeCommon.CONFIG.clearServerSyncedValuesAndReload());
  }
}
