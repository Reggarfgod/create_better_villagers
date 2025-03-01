
package com.reggarf.mods.create_better_villagers.init;

import com.reggarf.mods.create_better_villagers.Create_better_villagers;
import com.simibubi.create.AllBlocks;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;

import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;


import com.google.common.collect.ImmutableSet;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ModVillagerProfessions {
	private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, Create_better_villagers.MODID);

	public static final DeferredHolder<VillagerProfession, VillagerProfession> ANDESITE_WORKER = registerProfession("andesite_worker",() -> AllBlocks.BASIN.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")));
	public static final DeferredHolder<VillagerProfession, VillagerProfession> BRASS_WORKER = registerProfession("brass_worker", () -> AllBlocks.ROTATION_SPEED_CONTROLLER.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.comparator.click")));
	public static final DeferredHolder<VillagerProfession, VillagerProfession> COPPER_WORKER = registerProfession("copper_worker", () -> AllBlocks.STEAM_ENGINE.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.copper.place")));
	public static final DeferredHolder<VillagerProfession, VillagerProfession> MINER = registerProfession("miner", () -> AllBlocks.MECHANICAL_ARM.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.break")));

	private static DeferredHolder<VillagerProfession, VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
		POI_TYPES.put(name, new ProfessionPoiType(block, null));
		return PROFESSIONS.register(name, () -> {
			Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> (POI_TYPES.get(name).poiType != null) && (poiTypeHolder.value() == POI_TYPES.get(name).poiType.value());
			return new VillagerProfession(Create_better_villagers.MODID + ":" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
		});
	}

	@SubscribeEvent
	public static void registerProfessionPointsOfInterest(RegisterEvent event) {
		event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
			for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
				Block block = entry.getValue().block.get();
				String name = entry.getKey();
				Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
				if (existingCheck.isPresent()) {
					Create_better_villagers.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
					continue;
				}
				PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
				registerHelper.register(ResourceLocation.fromNamespaceAndPath("create_better_villagers", name), poiType);
				entry.getValue().poiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
			}
		});
	}

	private static class ProfessionPoiType {
		final Supplier<Block> block;
		Holder<PoiType> poiType;

		ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
			this.block = block;
			this.poiType = poiType;
		}
	}
}
