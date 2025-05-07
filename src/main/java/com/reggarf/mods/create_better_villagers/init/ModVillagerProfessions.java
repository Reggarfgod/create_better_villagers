//package com.reggarf.mods.create_better_villagers.init;
//
//import com.simibubi.create.AllBlocks;
//import net.minecraftforge.registries.RegistryObject;
//import net.minecraftforge.registries.RegisterEvent;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.entity.npc.VillagerProfession;
//import net.minecraft.world.entity.ai.village.poi.PoiTypes;
//import net.minecraft.world.entity.ai.village.poi.PoiType;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.core.Holder;
//
//import java.util.function.Supplier;
//import java.util.function.Predicate;
//import java.util.Optional;
//import java.util.Map;
//import java.util.HashMap;
//
//import com.reggarf.mods.create_better_villagers.CreateBetterVillagersMod;
//import com.reggarf.mods.create_better_villagers.config.ModConfigs;
//
//import com.google.common.collect.ImmutableSet;
//
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//public class CreateBetterVillagersModVillagerProfessions {
//
//	private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();
//	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, CreateBetterVillagersMod.MODID);
//
//	public static RegistryObject<VillagerProfession> ANDESITE_WORKER;
//	public static RegistryObject<VillagerProfession> BRASSWORKER;
//	public static RegistryObject<VillagerProfession> COPPERWORKER;
//	public static RegistryObject<VillagerProfession> MINER;
//	public static RegistryObject<VillagerProfession> BRASS_MINNER;
//	public static RegistryObject<VillagerProfession> COPPERMINNER;
//
//	public static void init() {
//		if (ModConfigs.COMMON.enableAndesiteWorker.get())
//			ANDESITE_WORKER = registerProfession("andesite_worker", AllBlocks.BASIN::get, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use")));
//		if (ModConfigs.COMMON.enableBrassworker.get())
//			BRASSWORKER = registerProfession("brassworker", AllBlocks.ROTATION_SPEED_CONTROLLER::get, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")));
//		if (ModConfigs.COMMON.enableCopperworker.get())
//			COPPERWORKER = registerProfession("copperworker", AllBlocks.STEAM_ENGINE::get, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.copper.place")));
//		if (ModConfigs.COMMON.enableMiner.get())
//			MINER = registerProfession("miner", AllBlocks.MECHANICAL_ARM::get, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")));
//		if (ModConfigs.COMMON.enableBrassMinner.get())
//			BRASS_MINNER = registerProfession("brass_minner", AllBlocks.MECHANICAL_HARVESTER::get, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.break")));
//		if (ModConfigs.COMMON.enableCopperMinner.get())
//			COPPERMINNER = registerProfession("copperminner", AllBlocks.HOSE_PULLEY::get, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")));
//	}
//
//	private static RegistryObject<VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
//		POI_TYPES.put(name, new ProfessionPoiType(block, null));
//		return PROFESSIONS.register(name, () -> {
//			Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> (POI_TYPES.get(name).poiType != null) && (poiTypeHolder.get() == POI_TYPES.get(name).poiType.get());
//			return new VillagerProfession(CreateBetterVillagersMod.MODID + ":" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
//		});
//	}
//
//	@SubscribeEvent
//	public static void registerProfessionPointsOfInterest(RegisterEvent event) {
//		event.register(ForgeRegistries.Keys.POI_TYPES, registerHelper -> {
//			for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
//				Block block = entry.getValue().block.get();
//				String name = entry.getKey();
//				Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
//				if (existingCheck.isPresent()) {
//					CreateBetterVillagersMod.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
//					continue;
//				}
//				PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
//				registerHelper.register(name, poiType);
//				entry.getValue().poiType = ForgeRegistries.POI_TYPES.getHolder(poiType).get();
//			}
//		});
//	}
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
