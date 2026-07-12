package com.khazoda.bronze;

import com.khazoda.core.config.KhazConfigSync;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

  public static final String MOD_ID = "bronze";
  public static final String MOD_NAME = "Bronze";
  public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
  public static final KhazConfigSync CONFIG_SYNC = KhazConfigSync.create(ID("config_sync"));

  public static Identifier ID(String path) {
    return Identifier.fromNamespaceAndPath(MOD_ID, path);
  }

  public static ResourceKey<Recipe<?>> recipeKey(String path) {
    return ResourceKey.create(Registries.RECIPE, ID(path));
  }
}
