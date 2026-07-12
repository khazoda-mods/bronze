package com.khazoda.bronze.registry;

import com.khazoda.bronze.Constants;
import com.khazoda.bronze.block.*;
import com.khazoda.bronze.item.FarmersDelightKnife;
import com.khazoda.bronze.item.Sickle;
import com.khazoda.bronze.item.Trowel;
import com.khazoda.bronze.material.BronzeMaterial;
import com.khazoda.bronze.material.TinMaterial;
import com.khazoda.bronze.platform.Services;
import com.khazoda.core.reg.KhazReg;
import com.khazoda.core.reg.KhazReg.BlockEntry;
import com.khazoda.core.reg.KhazReg.Entry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class MainRegistry {
  private static boolean initialized;
  public static final KhazReg reg = new KhazReg(Constants.MOD_ID);
  private static final List<Supplier<? extends ItemLike>> TAB = new ArrayList<>();

  /**
   * ==========[ Sounds ]=========
   */
  public static final Entry<SoundEvent> TROWEL_DIG = reg.sound("trowel_dig");

  /**
   * ==========[ Items ]==========
   */
  public static final Entry<Item> RAW_TIN = reg.item("raw_tin").addToTab(TAB);
  public static final Entry<Item> TIN_NUGGET = reg.item("tin_nugget").addToTab(TAB);
  public static final Entry<Item> TIN_INGOT = reg.item("tin_ingot").addToTab(TAB);
  public static final Entry<Item> TIN_HORSE_ARMOR = reg.horseArmor("tin_horse_armor", TinMaterial.ARMOR).addToTab(TAB);
  public static final Entry<Item> TIN_NAUTILUS_ARMOR = reg.nautilusArmor("tin_nautilus_armor", TinMaterial.ARMOR).addToTab(TAB);
  public static final Entry<Item> TIN_SWORD = reg.sword("tin_sword", TinMaterial.TOOL, 3.0F, -2.4F).addToTab(TAB);
  public static final Entry<Item> TIN_SPEAR = reg.spear("tin_spear", TinMaterial.TOOL, 0.85F, 0.82F, 0.65F, 4.0F, 9.0F, 8.25F, 5.1F, 12.5F, 4.6F).addToTab(TAB);
  public static final Entry<AxeItem> TIN_AXE = reg.axe("tin_axe", TinMaterial.TOOL, 7F, -3.1F).addToTab(TAB);
  public static final Entry<Item> TIN_PICKAXE = reg.pickaxe("tin_pickaxe", TinMaterial.TOOL, 1.0F, -2.8F).addToTab(TAB);
  public static final Entry<ShovelItem> TIN_SHOVEL = reg.shovel("tin_shovel", TinMaterial.TOOL, 1.5F, -3.0F).addToTab(TAB);
  public static final Entry<HoeItem> TIN_HOE = reg.hoe("tin_hoe", TinMaterial.TOOL, -2.0F, 0.0F).addToTab(TAB);
  public static final Entry<Item> TIN_HELMET = reg.humanoidArmor("tin_helmet", TinMaterial.ARMOR, ArmorType.HELMET).addToTab(TAB);
  public static final Entry<Item> TIN_CHESTPLATE = reg.humanoidArmor("tin_chestplate", TinMaterial.ARMOR, ArmorType.CHESTPLATE).addToTab(TAB);
  public static final Entry<Item> TIN_LEGGINGS = reg.humanoidArmor("tin_leggings", TinMaterial.ARMOR, ArmorType.LEGGINGS).addToTab(TAB);
  public static final Entry<Item> TIN_BOOTS = reg.humanoidArmor("tin_boots", TinMaterial.ARMOR, ArmorType.BOOTS).addToTab(TAB);

  public static final Entry<Item> BRONZE_BLEND = reg.item("bronze_blend").addToTab(TAB);
  public static final Entry<Item> BRONZE_NUGGET = reg.item("bronze_nugget").addToTab(TAB);
  public static final Entry<Item> BRONZE_INGOT = reg.item("bronze_ingot").addToTab(TAB);
  public static final Entry<Item> BRONZE_HORSE_ARMOR = reg.horseArmor("bronze_horse_armor", BronzeMaterial.ARMOR).addToTab(TAB);
  public static final Entry<Item> BRONZE_NAUTILUS_ARMOR = reg.nautilusArmor("bronze_nautilus_armor", BronzeMaterial.ARMOR).addToTab(TAB);
  public static final Entry<Item> BRONZE_SWORD = reg.sword("bronze_sword", BronzeMaterial.TOOL, 3.0F, -2.4F).addToTab(TAB);
  public static final Entry<Item> BRONZE_SPEAR = reg.spear("bronze_spear", BronzeMaterial.TOOL, 0.95F, 0.95F, 0.6F, 2.5F, 8.0F, 6.75F, 5.1F, 11.25F, 4.6F).addToTab(TAB);
  public static final Entry<AxeItem> BRONZE_AXE = reg.axe("bronze_axe", BronzeMaterial.TOOL, 6F, -3.1F).addToTab(TAB);
  public static final Entry<Item> BRONZE_PICKAXE = reg.pickaxe("bronze_pickaxe", BronzeMaterial.TOOL, 1.0F, -2.8F).addToTab(TAB);
  public static final Entry<ShovelItem> BRONZE_SHOVEL = reg.shovel("bronze_shovel", BronzeMaterial.TOOL, 1.5F, -3.0F).addToTab(TAB);
  public static final Entry<HoeItem> BRONZE_HOE = reg.hoe("bronze_hoe", BronzeMaterial.TOOL, -2.0F, 0.0F).addToTab(TAB);
  public static final Entry<Sickle> SICKLE = reg.item("bronze_sickle", Sickle::create).addToTab(TAB);
  public static final Entry<Trowel> TROWEL = reg.item("trowel", Trowel::create).addToTab(TAB);
  public static final Entry<Item> BRONZE_HELMET = reg.humanoidArmor("bronze_helmet", BronzeMaterial.ARMOR, ArmorType.HELMET).addToTab(TAB);
  public static final Entry<Item> BRONZE_CHESTPLATE = reg.humanoidArmor("bronze_chestplate", BronzeMaterial.ARMOR, ArmorType.CHESTPLATE).addToTab(TAB);
  public static final Entry<Item> BRONZE_LEGGINGS = reg.humanoidArmor("bronze_leggings", BronzeMaterial.ARMOR, ArmorType.LEGGINGS).addToTab(TAB);
  public static final Entry<Item> BRONZE_BOOTS = reg.humanoidArmor("bronze_boots", BronzeMaterial.ARMOR, ArmorType.BOOTS).addToTab(TAB);
  public static final Entry<FarmersDelightKnife> BRONZE_KNIFE = reg.item("bronze_knife", (key, props) -> new FarmersDelightKnife(FarmersDelightKnife.createProperties(key, BronzeMaterial.TOOL)));
  public static final Entry<FarmersDelightKnife> TIN_KNIFE = reg.item("tin_knife", (key, props) -> new FarmersDelightKnife(FarmersDelightKnife.createProperties(key, TinMaterial.TOOL)));
  public static final Entry<Item> BRONZE_COIN = reg.item("bronze_coin").addToTab(TAB);

  static {
    if (Services.PLATFORM.isModLoaded("farmersdelight")) {
      BRONZE_KNIFE.addToTab(TAB);
      TIN_KNIFE.addToTab(TAB);
    }
  }

  /**
   * ==========[ Blocks + BlockItems ]==========
   */
  public static final BlockEntry<Block, BlockItem> TIN_ORE = blockWithItem("tin_ore_block", 2.5F, 0.0F, MapColor.STONE, NoteBlockInstrument.BASEDRUM, SoundType.STONE).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> DEEPSLATE_TIN_ORE = blockWithItem("deepslate_tin_ore_block", 3.5F, 0.0F, MapColor.DEEPSLATE, NoteBlockInstrument.BASEDRUM, SoundType.DEEPSLATE).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> RAW_TIN_BLOCK = blockWithItem("raw_tin_block", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.BASEDRUM, SoundType.COPPER).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> TIN_BLOCK = blockWithItem("tin_block", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> CHISELED_TIN = blockWithItem("chiseled_tin", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> CUT_TIN = blockWithItem("cut_tin", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> TIN_TILES = blockWithItem("tin_tiles", 2.5F, 6.0F, MapColor.TERRACOTTA_WHITE, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.COPPER).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> BRONZE_BLEND_BLOCK = blockWithItem("bronze_blend_block", 2.5F, 0.0F, MapColor.DIRT, NoteBlockInstrument.BASEDRUM, SoundType.STONE).addToTab(TAB);
  public static final BlockEntry<Block, BlockItem> BRONZE_BLOCK = blockWithItem("bronze_block", 3.5F, 0.0F, MapColor.GOLD, NoteBlockInstrument.IRON_XYLOPHONE, SoundType.METAL).addToTab(TAB);
  public static final BlockEntry<TinFramedGlass, BlockItem> TIN_FRAMED_GLASS = reg.blockWithItem("tin_framed_glass", (key, props) -> new TinFramedGlass(key), BlockItem::new).addToTab(TAB);
  public static final BlockEntry<CutTinSlab, BlockItem> CUT_TIN_SLAB = reg.blockWithItem("cut_tin_slab", (key, props) -> new CutTinSlab(BlockBehaviour.Properties.ofFullCopy(CUT_TIN.get()).setId(key)), BlockItem::new).addToTab(TAB);
  public static final BlockEntry<CutTinStairs, BlockItem> CUT_TIN_STAIRS = reg.blockWithItem("cut_tin_stairs", (key, props) -> new CutTinStairs(CUT_TIN.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CUT_TIN.get()).setId(key)), BlockItem::new).addToTab(TAB);
  public static final BlockEntry<BronzeTrapdoor, BlockItem> BRONZE_TRAPDOOR = reg.blockWithItem("bronze_trapdoor_block", (key, props) -> new BronzeTrapdoor(key), BlockItem::new).addToTab(TAB);
  public static final BlockEntry<BronzeDoor, BlockItem> BRONZE_DOOR = reg.blockWithItem("bronze_door_block", (key, props) -> new BronzeDoor(key), BlockItem::new).addToTab(TAB);

  /**
   * ==========[ Worldgen ]==========
   */
  public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, Constants.ID("ore_tin"));
  public static final ResourceKey<PlacedFeature> TIN_ORE_SMALL_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, Constants.ID("ore_tin_small"));

  /**
   * ==========[ Tabs ]==========
   */
  public static final Entry<CreativeModeTab> BRONZE_TAB = reg.tab("main", () -> new ItemStack(BRONZE_INGOT.get()));

  private MainRegistry() {
  }

  public static KhazReg init() {
    if (initialized) return reg;
    initialized = true;
    reg.freeze();
    return reg;
  }

  public static void addMainTabItems(Consumer<ItemLike> output) {
    for (Supplier<? extends ItemLike> item : TAB) {
      output.accept(item.get());
    }
  }

  private static BlockEntry<Block, BlockItem> blockWithItem(String name, float destroyTime, float explosionResistance, MapColor mapColor, NoteBlockInstrument instrument, SoundType soundType) {
    return reg.blockWithItem(name, (key, props) -> new Block(BlockBehaviour.Properties.of().strength(destroyTime, explosionResistance).mapColor(mapColor).instrument(instrument).sound(soundType).requiresCorrectToolForDrops().setId(key)), BlockItem::new);
  }
}
