

package com.reggarf.mods.create_better_villagers.init;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CreateBetterVillagersModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == CreateBetterVillagersModVillagerProfessions.MINER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4), new ItemStack(Blocks.COBBLESTONE, 2), new ItemStack(Blocks.ANDESITE, 8), 10, 5, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(Blocks.COBBLESTONE_SLAB, 3), new ItemStack(Blocks.ANDESITE_SLAB, 10), 10, 5, 0.07f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 30), new ItemStack(Items.IRON_INGOT, 10), new ItemStack(AllItems.ZINC_INGOT, 11), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Blocks.KELP, 6), new ItemStack(Items.DRIED_KELP, 20), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.STICK, 8), new ItemStack(Blocks.TORCH, 20), 10, 5, 0.07f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.RAW_IRON, 9), new ItemStack(Blocks.IRON_BLOCK, 2), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(AllItems.ZINC_INGOT, 9), new ItemStack(Items.COPPER_INGOT, 9), new ItemStack(AllItems.BRASS_INGOT, 20), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Items.RAW_IRON, 9), new ItemStack(Blocks.IRON_BLOCK, 2), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.ANDESITE, 3), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.COBBLESTONE, 3), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(AllItems.RAW_ZINC, 5), new ItemStack(AllItems.ZINC_INGOT, 7), 4, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(Items.RAW_COPPER, 5), new ItemStack(Items.COPPER_INGOT, 10), 4, 5, 0.05f));
		}
		if (event.getType() == CreateBetterVillagersModVillagerProfessions.COPPERWORKER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 21), new ItemStack(Items.COPPER_INGOT, 1), new ItemStack(AllItems.COPPER_SHEET, 1), 5, 5, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(AllItems.COPPER_SHEET, 2), new ItemStack(AllBlocks.FLUID_PIPE, 2), 3, 5, 0.07f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 31), new ItemStack(AllBlocks.FLUID_PIPE, 2), new ItemStack(AllBlocks.MECHANICAL_PUMP, 1), 5, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 21), new ItemStack(AllBlocks.ANDESITE_ALLOY_BLOCK, 1), new ItemStack(AllBlocks.COPPER_VALVE_HANDLE, 2), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 41), new ItemStack(AllItems.COPPER_NUGGET, 31), new ItemStack(AllBlocks.FLUID_TANK, 2), 5, 5, 0.07f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(AllBlocks.COPPER_CASING, 2), new ItemStack(AllBlocks.HOSE_PULLEY, 1), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 9), new ItemStack(AllBlocks.COPPER_CASING,1),new ItemStack(AllBlocks.ITEM_DRAIN, 1), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 20), new ItemStack(AllItems.GOLDEN_SHEET,10),new ItemStack(AllBlocks.STEAM_ENGINE, 1), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(AllItems.ELECTRON_TUBE, 2), new ItemStack(AllBlocks.SMART_FLUID_PIPE, 2), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Blocks.DRIED_KELP_BLOCK, 2), new ItemStack(AllBlocks.SPOUT, 2), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(AllBlocks.COPPER_CASING, 2), new ItemStack(AllBlocks.CHUTE, 3), new ItemStack(AllBlocks.PORTABLE_FLUID_INTERFACE, 3), 10, 5, 0.05f));
		}
		if (event.getType() == CreateBetterVillagersModVillagerProfessions.BRASSWORKER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 41), new ItemStack(AllItems.BRASS_INGOT, 5), new ItemStack(AllBlocks.FLYWHEEL, 1), 5, 5, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 39), new ItemStack(AllItems.ELECTRON_TUBE, 2), new ItemStack(AllBlocks.SEQUENCED_GEARSHIFT, 3), 3, 5, 0.07f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 31), new ItemStack(AllBlocks.GEARBOX, 2), new ItemStack(AllBlocks.MECHANICAL_CRAFTER, 1), 4, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 53), new ItemStack(AllItems.PRECISION_MECHANISM, 1), new ItemStack(AllBlocks.ROTATION_SPEED_CONTROLLER, 2), 2, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(AllItems.BRASS_SHEET, 10), new ItemStack(AllItems.PRECISION_MECHANISM, 1), new ItemStack(AllBlocks.MECHANICAL_ARM, 2), 2, 5, 0.07f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(AllBlocks.ANDESITE_FUNNEL, 3), new ItemStack(AllItems.ELECTRON_TUBE, 2), new ItemStack(AllBlocks.BRASS_FUNNEL, 3), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 11), new ItemStack(AllBlocks.ANDESITE_TUNNEL,3),new ItemStack(AllBlocks.BRASS_TUNNEL, 2), 2, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 20), new ItemStack(AllItems.ELECTRON_TUBE,2),new ItemStack(AllBlocks.THRESHOLD_SWITCH, 1), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(AllItems.ELECTRON_TUBE, 2), new ItemStack(AllBlocks.SMART_FLUID_PIPE, 2), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 34), new ItemStack(AllItems.BRASS_SHEET, 5), new ItemStack(AllItems.BRASS_HAND, 2), 4, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(AllItems.COPPER_SHEET, 2), new ItemStack(AllBlocks.BRASS_CASING, 2), new ItemStack(AllBlocks.DISPLAY_LINK, 3), 10, 5, 0.05f));
		}
		if (event.getType() == CreateBetterVillagersModVillagerProfessions.ANDESITE_WORKER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 21), new ItemStack(AllBlocks.COGWHEEL, 6), new ItemStack(AllBlocks.GEARBOX, 2), 3, 5, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 19), new ItemStack(AllBlocks.SHAFT, 6), new ItemStack(AllBlocks.COGWHEEL, 3), 3, 5, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 21), new ItemStack(AllBlocks.COGWHEEL, 6), new ItemStack(AllBlocks.GEARBOX, 2), 3, 5, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(AllBlocks.COGWHEEL, 3), new ItemStack(AllBlocks.LARGE_COGWHEEL, 2), 3, 5, 0.07f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 31), new ItemStack(AllItems.ANDESITE_ALLOY, 3), new ItemStack(AllBlocks.SHAFT, 16), 3, 5, 0.07f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 31), new ItemStack(AllBlocks.ANDESITE_ALLOY_BLOCK, 1), new ItemStack(AllBlocks.ANDESITE_FUNNEL, 5), 4, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 53), new ItemStack(AllItems.ANDESITE_ALLOY, 3), new ItemStack(AllBlocks.ANDESITE_TUNNEL, 2), 2, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 43), new ItemStack(AllBlocks.SHAFT, 2), new ItemStack(AllBlocks.COGWHEEL, 4), 2, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(Items.IRON_INGOT, 4), new ItemStack(AllItems.IRON_SHEET, 5), 2, 5, 0.07f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 56), new ItemStack(AllItems.ROSE_QUARTZ, 3), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.IRON_INGOT,1),new ItemStack(AllItems.FILTER, 2), 2, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 40), new ItemStack(AllItems.GOLDEN_SHEET,4),new ItemStack(AllItems.GOGGLES, 1), 2, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(AllItems.IRON_SHEET, 8), new ItemStack(AllItems.PROPELLER, 2), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 39), new ItemStack(AllItems.ANDESITE_ALLOY, 10), new ItemStack(AllItems.WHISK, 2), 2, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Blocks.BARREL, 2), new ItemStack(AllItems.IRON_SHEET, 2), new ItemStack(AllBlocks.ITEM_VAULT, 2), 4, 5, 0.05f));
		}
	}
}
