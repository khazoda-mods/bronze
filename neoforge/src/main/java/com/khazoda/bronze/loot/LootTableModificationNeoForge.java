package com.khazoda.bronze.loot;

import com.khazoda.bronze.Constants;
import com.khazoda.bronze.registry.LootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public final class LootTableModificationNeoForge {
  private LootTableModificationNeoForge() {
  }

  @SubscribeEvent
  public static void onLootTableLoad(LootTableLoadEvent event) {
    if (!"minecraft".equals(event.getName().getNamespace())) return;

    LootTable.Builder builder = LootTable.lootTable();
    if (!LootTables.modifyLootTable(event.getName(), builder)) return;

    LootPool pool = LootPool.lootPool()
        .add(NestedLootTable.inlineLootTable(builder.build()))
        .build();
    event.getTable().addPool(pool);
  }
}