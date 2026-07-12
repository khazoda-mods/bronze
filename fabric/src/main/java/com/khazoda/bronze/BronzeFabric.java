package com.khazoda.bronze;

import com.khazoda.bronze.loot.LootTableModificationFabric;
import com.khazoda.bronze.loot.TrowelConversionReloadFabric;
import com.khazoda.bronze.registry.MainRegistry;
import com.khazoda.core.reg.KhazRegFabric;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BronzeFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    BronzeCommon.init();
    KhazRegFabric.init(MainRegistry::init);
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, MainRegistry.TIN_ORE_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, MainRegistry.TIN_ORE_SMALL_PLACED_KEY);
    CreativeModeTabEvents.modifyOutputEvent(MainRegistry.BRONZE_TAB.key()).register(output -> MainRegistry.addMainTabItems(output::accept));
    LootTableModificationFabric.init();
    TrowelConversionReloadFabric.init();
  }
}
