package com.khazoda.bronze.platform;

import com.khazoda.bronze.Constants;
import com.khazoda.bronze.platform.services.IPlatformHelper;
import com.khazoda.core.config.KhazConfig;
import com.khazoda.core.config.KhazConfigSyncNeoForge;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    @Override
    public void registerServerConfigSync(KhazConfig config) {
        KhazConfigSyncNeoForge.registerServerConfigSync(config, Constants.CONFIG_SYNC);
    }
}
