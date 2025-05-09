//
//package com.reggarf.mods.create_better_villagers.init;
//
//import com.reggarf.mods.create_better_villagers.Create_better_villagers;
//import com.simibubi.create.AllBlocks;
//import net.neoforged.neoforge.registries.RegisterEvent;
//import net.neoforged.neoforge.registries.DeferredRegister;
//import net.neoforged.neoforge.registries.DeferredHolder;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.bus.api.SubscribeEvent;
//
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.entity.npc.VillagerProfession;
//import net.minecraft.world.entity.ai.village.poi.PoiTypes;
//import net.minecraft.world.entity.ai.village.poi.PoiType;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.core.Holder;
//
//import java.util.function.Supplier;
//import java.util.function.Predicate;
//import java.util.Optional;
//import java.util.Map;
//import java.util.HashMap;
//
//
//import com.google.common.collect.ImmutableSet;
//
//@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
//public class VillagerProfessions {
//	private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();
//	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, Create_better_villagers.MODID);
//
//	public static final DeferredHolder<VillagerProfession, VillagerProfession> ANDESITE_WORKER =
//			Create_better_villagers.CONFIG.common.ENABLE_ANDESITE_WORKER ? registerProfession("andesite_worker", () -> AllBlocks.BASIN.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use"))) : null;
//
//	public static final DeferredHolder<VillagerProfession, VillagerProfession> BRASSWORKER =
//			Create_better_villagers.CONFIG.common.ENABLE_BRASSWORKER ? registerProfession("brassworker", () -> AllBlocks.ROTATION_SPEED_CONTROLLER.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.comparator.click"))) : null;
//
//	public static final DeferredHolder<VillagerProfession, VillagerProfession> COPPERWORKER =
//			Create_better_villagers.CONFIG.common.ENABLE_COPPERWORKER ? registerProfession("copperworker", () -> AllBlocks.STEAM_ENGINE.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.copper.place"))) : null;
//
//	public static final DeferredHolder<VillagerProfession, VillagerProfession> MINER =
//			Create_better_villagers.CONFIG.common.ENABLE_MINER ? registerProfession("miner", () -> AllBlocks.MECHANICAL_ARM.get(), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.break"))) : null;
//
//	private static DeferredHolder<VillagerProfession, VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
//		POI_TYPES.put(name, new ProfessionPoiType(block, null));
//		return PROFESSIONS.register(name, () -> {
//			Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> (POI_TYPES.get(name).poiType != null) && (poiTypeHolder.value() == POI_TYPES.get(name).poiType.value());
//			return new VillagerProfession(Create_better_villagers.MODID + ":" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
//		});
//	}
//
//	@SubscribeEvent
//	public static void registerProfessionPointsOfInterest(RegisterEvent event) {
//		event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
//			for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
//				String name = entry.getKey();
//
//				// Skip if disabled in config
//				if ((name.equals("andesite_worker") && !Create_better_villagers.CONFIG.common.ENABLE_ANDESITE_WORKER)
//						|| (name.equals("brassworker") && !Create_better_villagers.CONFIG.common.ENABLE_BRASSWORKER)
//						|| (name.equals("copperworker") && !Create_better_villagers.CONFIG.common.ENABLE_COPPERWORKER)
//						|| (name.equals("miner") && !Create_better_villagers.CONFIG.common.ENABLE_MINER)) {
//					continue;
//				}
//
//				Block block = entry.getValue().block.get();
//				Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
//				if (existingCheck.isPresent()) {
//					Create_better_villagers.LOGGER.error("Skipping villager profession " + name + " due to POI conflict with block " + block);
//					continue;
//				}
//
//				PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
//				registerHelper.register(ResourceLocation.fromNamespaceAndPath(Create_better_villagers.MODID, name), poiType);
//				entry.getValue().poiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
//			}
//		});
//	}
//
//
//	private static class ProfessionPoiType {
//		final Supplier<Block> block;
//		Holder<PoiType> poiType;
//
//		ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
//			this.block = block;
//			this.poiType = poiType;
//		}
//	}
//}
