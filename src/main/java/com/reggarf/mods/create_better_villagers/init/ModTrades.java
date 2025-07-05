package com.reggarf.mods.create_better_villagers.init;



import com.reggarf.mods.create_better_villagers.Create_better_villagers;
import com.reggarf.mods.create_better_villagers.config.ModConfigs;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

@EventBusSubscriber
public class ModTrades {
    public ModTrades() {
    }

    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event) {
        //================================================================
        //                      ANDESITE_WORKER
        //================================================================
        if (Create_better_villagers.CONFIG.common.ENABLE_ANDESITE_WORKER) {
            if (event.getType() == ModVillagers.ANDESITE_WORKER.value()) {
                //LEVEL 1

                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllBlocks.COGWHEEL, 6), new ItemStack(AllBlocks.GEARBOX, 2), 3, 5, 0.07f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllBlocks.SHAFT, 6), new ItemStack(AllBlocks.COGWHEEL, 3), 3, 5, 0.07f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(AllBlocks.COGWHEEL, 6), new ItemStack(AllBlocks.GEARBOX, 2), 3, 5, 0.07f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllBlocks.COGWHEEL, 3), new ItemStack(AllBlocks.LARGE_COGWHEEL, 2), 3, 5, 0.07f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(AllItems.ANDESITE_ALLOY.get(), 3), new ItemStack(AllBlocks.SHAFT, 16), 3, 5, 0.07f));
                //LEVEL 2
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(AllBlocks.ANDESITE_ALLOY_BLOCK, 1), new ItemStack(AllBlocks.ANDESITE_FUNNEL, 5), 4, 5, 0.05f));
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(AllItems.ANDESITE_ALLOY.get(), 3), new ItemStack(AllBlocks.ANDESITE_TUNNEL, 2), 2, 5, 0.05f));
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(AllBlocks.SHAFT, 2), new ItemStack(AllBlocks.COGWHEEL, 4), 2, 5, 0.05f));
                //LEVEL 3
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.IRON_INGOT, 4), new ItemStack(AllItems.IRON_SHEET.get(), 5), 2, 5, 0.07f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(AllItems.ROSE_QUARTZ.get(), 3), 3, 5, 0.05f));
                //LEVEL 4
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.IRON_INGOT, 1), new ItemStack(AllItems.FILTER.get(), 2), 2, 5, 0.05f));
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(AllItems.GOLDEN_SHEET.get(), 4), new ItemStack(AllItems.GOGGLES.get(), 1), 2, 5, 0.05f));
                //LEVEL 5
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(AllItems.IRON_SHEET.get(), 8), new ItemStack(AllItems.PROPELLER.get(), 2), 3, 5, 0.05f));
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllItems.ANDESITE_ALLOY.get(), 10), new ItemStack(AllItems.WHISK.get(), 2), 2, 5, 0.05f));
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Blocks.BARREL, 2), new ItemStack(AllItems.IRON_SHEET.get(), 2), new ItemStack(AllBlocks.ITEM_VAULT, 2), 4, 5, 0.05f));

            }
        }

        //================================================================
        //                      BRASS_WORKER
        //================================================================
        if (Create_better_villagers.CONFIG.common.ENABLE_BRASSWORKER) {
            if (event.getType() == ModVillagers.BRASSWORKER.value()) {
                //LEVEL 1

                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllItems.BRASS_INGOT.get(), 5), new ItemStack(AllBlocks.FLYWHEEL, 1), 5, 5, 0.07f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllItems.ELECTRON_TUBE.get(), 2), new ItemStack(AllBlocks.SEQUENCED_GEARSHIFT, 3), 3, 5, 0.07f));
                //LEVEL 2
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(AllBlocks.GEARBOX, 2), new ItemStack(AllBlocks.MECHANICAL_CRAFTER, 1), 4, 5, 0.05f));
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(AllItems.PRECISION_MECHANISM.get(), 1), new ItemStack(AllBlocks.ROTATION_SPEED_CONTROLLER, 2), 2, 5, 0.05f));
                //LEVEL 3
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(AllItems.BRASS_SHEET.get(), 10), new ItemStack(AllItems.PRECISION_MECHANISM.get(), 1), new ItemStack(AllBlocks.MECHANICAL_ARM, 2), 2, 5, 0.07f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(AllBlocks.ANDESITE_FUNNEL, 3), new ItemStack(AllItems.ELECTRON_TUBE.get(), 2), new ItemStack(AllBlocks.BRASS_FUNNEL, 3), 3, 5, 0.05f));
                //LEVEL 4
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 11), new ItemStack(AllBlocks.ANDESITE_TUNNEL, 3), new ItemStack(AllBlocks.BRASS_TUNNEL, 2), 2, 5, 0.05f));
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 10), new ItemStack(AllItems.ELECTRON_TUBE.get(), 2), new ItemStack(AllBlocks.THRESHOLD_SWITCH, 1), 3, 5, 0.05f));
                //LEVEL 5
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllItems.ELECTRON_TUBE.get(), 2), new ItemStack(AllBlocks.SMART_FLUID_PIPE, 2), 10, 5, 0.05f));
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(AllItems.BRASS_SHEET.get(), 5), new ItemStack(AllItems.BRASS_HAND.get(), 2), 4, 5, 0.05f));
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(AllItems.COPPER_SHEET.get(), 2), new ItemStack(AllBlocks.BRASS_CASING, 2), new ItemStack(AllBlocks.DISPLAY_LINK, 3), 10, 5, 0.05f));
            }
        }
        //================================================================
        //                      COPPER_WORKER
        //================================================================
        if (Create_better_villagers.CONFIG.common.ENABLE_COPPERWORKER) {
            if (event.getType() == ModVillagers.COPPERWORKER.value()) {
                //LEVEL 1

                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.COPPER_INGOT, 1), new ItemStack(AllItems.COPPER_SHEET.get(), 1), 5, 5, 0.07f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllItems.COPPER_SHEET.get(), 2), new ItemStack(AllBlocks.FLUID_PIPE, 2), 3, 5, 0.07f));

                //LEVEL 2
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(AllBlocks.FLUID_PIPE, 2), new ItemStack(AllBlocks.MECHANICAL_PUMP, 1), 5, 5, 0.05f));
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(AllBlocks.ANDESITE_ALLOY_BLOCK, 1), new ItemStack(AllBlocks.COPPER_VALVE_HANDLE, 2), 10, 5, 0.05f));

                //LEVEL 3
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllItems.COPPER_NUGGET.get(), 31), new ItemStack(AllBlocks.FLUID_TANK, 2), 5, 5, 0.07f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(AllBlocks.COPPER_CASING, 2), new ItemStack(AllBlocks.HOSE_PULLEY, 1), 10, 5, 0.05f));

                //LEVEL 4
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 9), new ItemStack(AllBlocks.COPPER_CASING, 1), new ItemStack(AllBlocks.ITEM_DRAIN, 1), 10, 5, 0.05f));
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 10), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(AllBlocks.STEAM_ENGINE, 1), 10, 5, 0.05f));

                //LEVEL 5
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14), new ItemStack(AllItems.ELECTRON_TUBE.get(), 2), new ItemStack(AllBlocks.SMART_FLUID_PIPE, 2), 10, 5, 0.05f));
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14), new ItemStack(Blocks.DRIED_KELP_BLOCK, 2), new ItemStack(AllBlocks.SPOUT, 2), 10, 5, 0.05f));
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(AllBlocks.COPPER_CASING, 2), new ItemStack(AllBlocks.CHUTE, 3), new ItemStack(AllBlocks.PORTABLE_FLUID_INTERFACE, 3), 10, 5, 0.05f));
            }
        }
        if (Create_better_villagers.CONFIG.common.ENABLE_MINER) {
            if (event.getType() == ModVillagers.MINER.value()) {
                //LEVEL 1
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Blocks.COBBLESTONE, 2), new ItemStack(Blocks.ANDESITE, 8), 10, 5, 0.07f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(Blocks.COBBLESTONE_SLAB, 3), new ItemStack(Blocks.ANDESITE_SLAB, 10), 10, 5, 0.07f));
                //LEVEL 2
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.IRON_INGOT, 10), new ItemStack(AllItems.ZINC_INGOT.get(), 11), 10, 5, 0.05f));
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(Blocks.KELP, 6), new ItemStack(Items.DRIED_KELP, 20), 10, 5, 0.05f));
                //LEVEL 3
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.STICK, 8), new ItemStack(Blocks.TORCH, 20), 10, 5, 0.07f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(Items.RAW_IRON, 9), new ItemStack(Blocks.IRON_BLOCK, 2), 10, 5, 0.05f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(AllItems.ZINC_INGOT.get(), 9), new ItemStack(Items.COPPER_INGOT, 9), new ItemStack(AllItems.BRASS_INGOT.get(), 20), 10, 5, 0.05f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(Items.RAW_IRON, 9), new ItemStack(Blocks.IRON_BLOCK, 2), 10, 5, 0.05f));
                //LEVEL 4
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.ANDESITE, 3), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
                event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.COBBLESTONE, 3), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
                //LEVEL 5
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(AllItems.RAW_ZINC.get(), 5), new ItemStack(AllItems.ZINC_INGOT.get(), 7), 4, 5, 0.05f));
                event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9), new ItemStack(Items.RAW_COPPER, 5), new ItemStack(Items.COPPER_INGOT, 10), 4, 5, 0.05f));
            }
        }

        //================================================================
        //                      CRYSTAL_HARVESTER
        //================================================================

        //if (event.getType() == ModVillagerProfessions.CRYSTAL_HARVESTER.get()) {
        //	}
    }
}