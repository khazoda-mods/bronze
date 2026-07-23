package com.khazoda.bronze.registry;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.minecraft.core.registries.Registries.LOOT_TABLE;
import static net.minecraft.world.level.storage.loot.BuiltInLootTables.*;

public class LootTables {
  private static final Map<ResourceKey<LootTable>, LootConfig> LOOT_TABLE_CONFIGS = new HashMap<>();
  private static final Set<Item> ENCHANTABLE_LOOT_ITEMS = new HashSet<>();

  static {
    ENCHANTABLE_LOOT_ITEMS.addAll(List.of(
        MainRegistry.TIN_SWORD.get(),
        MainRegistry.TIN_SPEAR.get(),
        MainRegistry.TIN_AXE.get(),
        MainRegistry.TIN_PICKAXE.get(),
        MainRegistry.TIN_SHOVEL.get(),
        MainRegistry.TIN_HOE.get(),
        MainRegistry.TIN_HELMET.get(),
        MainRegistry.TIN_CHESTPLATE.get(),
        MainRegistry.TIN_LEGGINGS.get(),
        MainRegistry.TIN_BOOTS.get(),
        MainRegistry.BRONZE_SWORD.get(),
        MainRegistry.BRONZE_SPEAR.get(),
        MainRegistry.BRONZE_AXE.get(),
        MainRegistry.BRONZE_PICKAXE.get(),
        MainRegistry.BRONZE_SHOVEL.get(),
        MainRegistry.BRONZE_HOE.get(),
        MainRegistry.BRONZE_HELMET.get(),
        MainRegistry.BRONZE_CHESTPLATE.get(),
        MainRegistry.BRONZE_LEGGINGS.get(),
        MainRegistry.BRONZE_BOOTS.get()
    ));

    LOOT_TABLE_CONFIGS.put(ABANDONED_MINESHAFT, new LootConfig(List.of(MainRegistry.TIN_PICKAXE.get(), MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(ANCIENT_CITY, new LootConfig(List.of(MainRegistry.BRONZE_LEGGINGS.get(), MainRegistry.BRONZE_HOE.get()), true, true));
    LOOT_TABLE_CONFIGS.put(BASTION_BRIDGE, new LootConfig(List.of(MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_NUGGET.get()), false, false));
    LOOT_TABLE_CONFIGS.put(BASTION_OTHER, new LootConfig(List.of(MainRegistry.BRONZE_SWORD.get(),MainRegistry.BRONZE_SPEAR.get(), MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_NUGGET.get(), MainRegistry.BRONZE_BLOCK.item().get()), true, true));
    LOOT_TABLE_CONFIGS.put(BASTION_TREASURE, new LootConfig(List.of(MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_BLOCK.item().get()), false, false));
    LOOT_TABLE_CONFIGS.put(BURIED_TREASURE, new LootConfig(List.of(MainRegistry.BRONZE_SWORD.get(), MainRegistry.BRONZE_SPEAR.get(), MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_NAUTILUS_ARMOR.get(), MainRegistry.TIN_NAUTILUS_ARMOR.get()), false, false));
    LOOT_TABLE_CONFIGS.put(OCEAN_RUIN_COLD_ARCHAEOLOGY, new LootConfig(List.of(MainRegistry.TIN_NAUTILUS_ARMOR.get()), false, false));
    LOOT_TABLE_CONFIGS.put(OCEAN_RUIN_WARM_ARCHAEOLOGY, new LootConfig(List.of(MainRegistry.BRONZE_NAUTILUS_ARMOR.get()), false, false));
    LOOT_TABLE_CONFIGS.put(TRIAL_CHAMBERS_CORRIDOR, new LootConfig(List.of(MainRegistry.BRONZE_AXE.get(), MainRegistry.TIN_AXE.get()), true, true));
    LOOT_TABLE_CONFIGS.put(DESERT_PYRAMID, new LootConfig(List.of(MainRegistry.BRONZE_HORSE_ARMOR.get(), MainRegistry.TIN_HORSE_ARMOR.get(), MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(END_CITY_TREASURE, new LootConfig(List.of(MainRegistry.BRONZE_SWORD.get(), MainRegistry.BRONZE_SPEAR.get(), MainRegistry.BRONZE_PICKAXE.get(), MainRegistry.BRONZE_SHOVEL.get(), MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_HELMET.get(), MainRegistry.BRONZE_CHESTPLATE.get(), MainRegistry.BRONZE_LEGGINGS.get(), MainRegistry.BRONZE_BOOTS.get(), MainRegistry.BRONZE_HORSE_ARMOR.get(), MainRegistry.TIN_HORSE_ARMOR.get()), false, true));
    LOOT_TABLE_CONFIGS.put(TRIAL_CHAMBERS_INTERSECTION, new LootConfig(List.of(MainRegistry.BRONZE_BLOCK.item().get(), MainRegistry.TIN_BLOCK.item().get()), false, false));
    LOOT_TABLE_CONFIGS.put(JUNGLE_TEMPLE, new LootConfig(List.of(MainRegistry.BRONZE_HORSE_ARMOR.get(), MainRegistry.TIN_HORSE_ARMOR.get(), MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(NETHER_BRIDGE, new LootConfig(List.of(MainRegistry.BRONZE_HORSE_ARMOR.get(), MainRegistry.TIN_HORSE_ARMOR.get(), MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(PILLAGER_OUTPOST, new LootConfig(List.of(MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(TRIAL_CHAMBERS_REWARD_OMINOUS_RARE, new LootConfig(List.of(MainRegistry.BRONZE_BLOCK.item().get()), false, false));
    LOOT_TABLE_CONFIGS.put(TRIAL_CHAMBERS_REWARD_RARE, new LootConfig(List.of(MainRegistry.BRONZE_AXE.get(), MainRegistry.BRONZE_CHESTPLATE.get()), false, true));
    LOOT_TABLE_CONFIGS.put(RUINED_PORTAL, new LootConfig(List.of(MainRegistry.BRONZE_NUGGET.get(), MainRegistry.TIN_NUGGET.get()), false, false));
    LOOT_TABLE_CONFIGS.put(SHIPWRECK_TREASURE, new LootConfig(List.of(MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_NUGGET.get(), MainRegistry.TIN_INGOT.get(), MainRegistry.TIN_NUGGET.get(), MainRegistry.BRONZE_NAUTILUS_ARMOR.get(), MainRegistry.TIN_NAUTILUS_ARMOR.get()), false, false));
    LOOT_TABLE_CONFIGS.put(SIMPLE_DUNGEON, new LootConfig(List.of(MainRegistry.BRONZE_HORSE_ARMOR.get(), MainRegistry.TIN_HORSE_ARMOR.get(), MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(STRONGHOLD_CORRIDOR, new LootConfig(List.of(MainRegistry.BRONZE_SWORD.get(), MainRegistry.BRONZE_SPEAR.get(), MainRegistry.BRONZE_PICKAXE.get(), MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_HELMET.get(), MainRegistry.BRONZE_CHESTPLATE.get(), MainRegistry.BRONZE_LEGGINGS.get(), MainRegistry.BRONZE_BOOTS.get(), MainRegistry.BRONZE_HORSE_ARMOR.get(), MainRegistry.TIN_HORSE_ARMOR.get()), false, true));
    LOOT_TABLE_CONFIGS.put(STRONGHOLD_CROSSING, new LootConfig(List.of(MainRegistry.TIN_PICKAXE.get(), MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(VILLAGE_ARMORER, new LootConfig(List.of(MainRegistry.BRONZE_HELMET.get(), MainRegistry.BRONZE_INGOT.get()), false, true));
    LOOT_TABLE_CONFIGS.put(VILLAGE_TAIGA_HOUSE, new LootConfig(List.of(MainRegistry.BRONZE_NUGGET.get()), false, false));
    LOOT_TABLE_CONFIGS.put(VILLAGE_TOOLSMITH, new LootConfig(List.of(MainRegistry.BRONZE_PICKAXE.get(), MainRegistry.BRONZE_SHOVEL.get(), MainRegistry.BRONZE_INGOT.get()), false, false));
    LOOT_TABLE_CONFIGS.put(VILLAGE_WEAPONSMITH, new LootConfig(List.of(MainRegistry.BRONZE_SWORD.get(), MainRegistry.BRONZE_SPEAR.get(), MainRegistry.BRONZE_PICKAXE.get(), MainRegistry.BRONZE_AXE.get(), MainRegistry.BRONZE_INGOT.get(), MainRegistry.BRONZE_HELMET.get(), MainRegistry.BRONZE_CHESTPLATE.get(), MainRegistry.BRONZE_LEGGINGS.get(), MainRegistry.BRONZE_BOOTS.get(), MainRegistry.BRONZE_HORSE_ARMOR.get(), MainRegistry.TIN_HORSE_ARMOR.get()), false, true));
    LOOT_TABLE_CONFIGS.put(WOODLAND_MANSION, new LootConfig(List.of(MainRegistry.BRONZE_INGOT.get()), false, false));
  }

  public static boolean modifyLootTable(Identifier id, LootTable.Builder tableBuilder) {
    ResourceKey<LootTable> key = ResourceKey.create(LOOT_TABLE, id);
    LootConfig config = LOOT_TABLE_CONFIGS.get(key);
    if (config == null) return false;

    addLootToTable(config, tableBuilder);
    return true;
  }

  private static void addLootToTable(LootConfig config, LootTable.Builder tableBuilder) {
    List<Item> enchantableItems = new ArrayList<>();
    List<Item> nonEnchantableItems = new ArrayList<>();

    for (Item item : config.items()) {
      if (isEnchantable(item)) {
        enchantableItems.add(item);
      } else {
        nonEnchantableItems.add(item);
      }
    }

    if (config.enchanted() && !enchantableItems.isEmpty()) {
      // Add 0-1 enchanted items
      LootPool.Builder enchantedPool = createBasePoolBuilder(enchantableItems, 1f)
          .apply(EnchantRandomlyFunction.randomEnchantment());
      if (config.applyDamage()) applyDamage(enchantedPool);
      tableBuilder.withPool(enchantedPool);

      // Add 0-1 unenchanted enchantable items
      LootPool.Builder normalEnchantablePool = createBasePoolBuilder(enchantableItems, 1f);
      if (config.applyDamage()) applyDamage(normalEnchantablePool);
      tableBuilder.withPool(normalEnchantablePool);
    } else {
      // Add 0-2 unenchanted items
      LootPool.Builder pool = createBasePoolBuilder(config.items(), 2f);
      if (config.applyDamage()) applyDamageToEnchantableItems(pool, config.items());
      tableBuilder.withPool(pool);
    }

    if (config.enchanted() && !nonEnchantableItems.isEmpty()) {
      LootPool.Builder nonEnchantablePool = createBasePoolBuilder(nonEnchantableItems, 2f);
      tableBuilder.withPool(nonEnchantablePool);
    }
  }

  private static LootPool.Builder createBasePoolBuilder(List<Item> items, float maxRolls) {
    LootPool.Builder builder = LootPool.lootPool()
        .setRolls(UniformGenerator.between(0.0f, maxRolls));
    for (Item item : items) {
      builder.add(LootItem.lootTableItem(item).setWeight(2));
    }
    return builder;
  }

  private static void applyDamage(LootPool.Builder builder) {
    builder.apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.8f)))
        .setBonusRolls(ConstantValue.exactly(0.5f));
  }

  private static void applyDamageToEnchantableItems(LootPool.Builder builder, List<Item> items) {
    boolean hasEnchantableItems = items.stream().anyMatch(LootTables::isEnchantable);
    if (hasEnchantableItems) {
      applyDamage(builder);
    }
  }

  private static boolean isEnchantable(Item item) {
    return ENCHANTABLE_LOOT_ITEMS.contains(item);
  }

  private record LootConfig(List<Item> items, boolean applyDamage, boolean enchanted) {
  }
}