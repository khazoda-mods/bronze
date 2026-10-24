package com.khazoda.bronze.worldgen;

import com.khazoda.bronze.BronzeCommon;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;

// used for reference: https://docs.neoforged.net/docs/resources/server/conditions/
public record TinOreCondition() implements ICondition {
  public static final MapCodec<TinOreCondition> CODEC = MapCodec.unit(TinOreCondition::new);

  @Override
  public boolean test(IContext context) {
    return BronzeCommon.CONFIG.getLocal(BronzeCommon.GENERATE_TIN_ORE);
  }

  @Override
  public MapCodec<? extends ICondition> codec() {
    return CODEC;
  }
}
