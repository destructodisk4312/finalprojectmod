package com.example.finalproject;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(finalprojectmod.MODID)
public class finalprojectmod {

    public static final String MODID = "finalprojectmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // ============================
    //      REGISTRIES
    // ============================
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // ============================
    //      BLOCKS
    // ============================
    public static final RegistryObject<Block> CRYSTAL_ORE =
            BLOCKS.register("crystal_ore", () ->
                    new Block(BlockBehaviour.Properties.of()
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .mapColor(MapColor.STONE)));

    public static final RegistryObject<Block> CRYSTAL_BLOCK =
            BLOCKS.register("crystal_block", () ->
                    new Block(BlockBehaviour.Properties.of()
                            .strength(5.0F)
                            .mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> CRYSTAL_BRICKS =
            BLOCKS.register("crystal_bricks", () ->
                    new Block(BlockBehaviour.Properties.of()
                            .strength(4.0F)
                            .mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> CRYSTAL_GLASS =
            BLOCKS.register("crystal_glass", () ->
                    new Block(BlockBehaviour.Properties.of()
                            .strength(0.3F)
                            .noOcclusion()
                            .mapColor(MapColor.COLOR_LIGHT_BLUE)));

    // Block Items
    public static final RegistryObject<Item> CRYSTAL_ORE_ITEM =
            ITEMS.register("crystal_ore", () -> new BlockItem(CRYSTAL_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> CRYSTAL_BLOCK_ITEM =
            ITEMS.register("crystal_block", () -> new BlockItem(CRYSTAL_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> CRYSTAL_BRICKS_ITEM =
            ITEMS.register("crystal_bricks", () -> new BlockItem(CRYSTAL_BRICKS.get(), new Item.Properties()));

    public static final RegistryObject<Item> CRYSTAL_GLASS_ITEM =
            ITEMS.register("crystal_glass", () -> new BlockItem(CRYSTAL_GLASS.get(), new Item.Properties()));

    // ============================
    //      BASIC ITEMS
    // ============================
    public static final RegistryObject<Item> CRYSTAL_SHARD =
            ITEMS.register("crystal_shard", () -> new Item(new Item.Properties()));

    private static final FoodProperties CRYSTAL_BREAD_FOOD =
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8F)
                    .effect(new MobEffectInstance(MobEffects.GLOWING, 20 * 20, 0), 1.0F)
                    .build();

    public static final RegistryObject<Item> CRYSTAL_BREAD =
            ITEMS.register("crystal_bread",
                    () -> new Item(new Item.Properties().food(CRYSTAL_BREAD_FOOD)));

    // ============================
    //      TOOL TIER (ForgeTier)
    //  Signature from compiler:
    //  ForgeTier(int, float, float, int, TagKey<Block>, Supplier<Ingredient>, TagKey<Block>)
    // ============================
    public static final Tier CRYSTAL_TIER =
            new ForgeTier(
                    4,                                   // mining level
                    10.0F,                               // mining speed
                    4.0F,                                // attack damage bonus
                    22,                                  // enchantability
                    BlockTags.MINEABLE_WITH_PICKAXE,     // correct blocks
                    () -> Ingredient.of(CRYSTAL_SHARD.get()),
                    BlockTags.MINEABLE_WITH_PICKAXE      // fallback incorrect blocks tag
            );

    // ============================
    //      TOOLS
    // ============================
    public static final RegistryObject<SwordItem> CRYSTAL_SWORD =
            ITEMS.register("crystal_sword",
                    () -> new SwordItem(CRYSTAL_TIER, new Item.Properties()));

    public static final RegistryObject<PickaxeItem> CRYSTAL_PICKAXE =
            ITEMS.register("crystal_pickaxe",
                    () -> new PickaxeItem(CRYSTAL_TIER, new Item.Properties()));

    public static final RegistryObject<AxeItem> CRYSTAL_AXE =
            ITEMS.register("crystal_axe",
                    () -> new AxeItem(CRYSTAL_TIER, new Item.Properties()));

    public static final RegistryObject<ShovelItem> CRYSTAL_SHOVEL =
            ITEMS.register("crystal_shovel",
                    () -> new ShovelItem(CRYSTAL_TIER, new Item.Properties()));

    public static final RegistryObject<HoeItem> CRYSTAL_HOE =
            ITEMS.register("crystal_hoe",
                    () -> new HoeItem(CRYSTAL_TIER, new Item.Properties()));

    // ============================
    //      ARMOR
    // ============================
    public static final RegistryObject<ArmorItem> CRYSTAL_HELMET =
            ITEMS.register("crystal_helmet",
                    () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<ArmorItem> CRYSTAL_CHESTPLATE =
            ITEMS.register("crystal_chestplate",
                    () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<ArmorItem> CRYSTAL_LEGGINGS =
            ITEMS.register("crystal_leggings",
                    () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> CRYSTAL_BOOTS =
            ITEMS.register("crystal_boots",
                    () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

    // ============================
    //      CREATIVE TAB
    // ============================
    public static final RegistryObject<CreativeModeTab> CRYSTAL_TAB =
            CREATIVE_MODE_TABS.register("crystal_tab", () ->
                    CreativeModeTab.builder()
                            .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                            .icon(() -> CRYSTAL_SHARD.get().getDefaultInstance())
                            .displayItems((params, output) -> {

                                // Blocks
                                output.accept(CRYSTAL_ORE_ITEM.get());
                                output.accept(CRYSTAL_BLOCK_ITEM.get());
                                output.accept(CRYSTAL_BRICKS_ITEM.get());
                                output.accept(CRYSTAL_GLASS_ITEM.get());

                                // Items
                                output.accept(CRYSTAL_SHARD.get());
                                output.accept(CRYSTAL_BREAD.get());

                                // Tools
                                output.accept(CRYSTAL_SWORD.get());
                                output.accept(CRYSTAL_PICKAXE.get());
                                output.accept(CRYSTAL_AXE.get());
                                output.accept(CRYSTAL_SHOVEL.get());
                                output.accept(CRYSTAL_HOE.get());

                                // Armor
                                output.accept(CRYSTAL_HELMET.get());
                                output.accept(CRYSTAL_CHESTPLATE.get());
                                output.accept(CRYSTAL_LEGGINGS.get());
                                output.accept(CRYSTAL_BOOTS.get());
                            })
                            .build());

    // ============================
    //      CONSTRUCTOR
    // ============================
    public finalprojectmod(FMLJavaModLoadingContext context) {

        IEventBus bus = context.getModEventBus();

        BLOCKS.register(bus);
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("Crystal Mod Loaded!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // common setup if needed
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
            event.accept(CRYSTAL_ORE_ITEM);

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(CRYSTAL_BLOCK_ITEM);
            event.accept(CRYSTAL_BRICKS_ITEM);
            event.accept(CRYSTAL_GLASS_ITEM);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(CRYSTAL_SHARD);
            event.accept(CRYSTAL_BREAD);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(CRYSTAL_SWORD);
            event.accept(CRYSTAL_HELMET);
            event.accept(CRYSTAL_CHESTPLATE);
            event.accept(CRYSTAL_LEGGINGS);
            event.accept(CRYSTAL_BOOTS);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(CRYSTAL_PICKAXE);
            event.accept(CRYSTAL_AXE);
            event.accept(CRYSTAL_SHOVEL);
            event.accept(CRYSTAL_HOE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Crystal Mod Server Starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Client setup running for Crystal Mod");
            LOGGER.info("Logged in as: {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
