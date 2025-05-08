package com.reggarf.mods.create_better_villagers.init;

import com.google.common.collect.ImmutableSet;
import com.reggarf.mods.create_better_villagers.config.ModConfigs;
import com.simibubi.create.AllBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.reggarf.mods.create_better_villagers.CreateBetterVillagersMod.MODID;


public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MODID);

    public static RegistryObject<PoiType> ANDESITE_WORKER_POI;
    public static RegistryObject<VillagerProfession> ANDESITE_WORKER;

    public static RegistryObject<PoiType> BRASSWORKER_POI;
    public static RegistryObject<VillagerProfession> BRASSWORKER;

    public static RegistryObject<PoiType> COPPERWORKER_POI;
    public static RegistryObject<VillagerProfession> COPPERWORKER;

    public static RegistryObject<PoiType> MINER_POI;
    public static RegistryObject<VillagerProfession> MINER;

    public static RegistryObject<PoiType> TECHWRIGHT_POI;
    public static RegistryObject<VillagerProfession> TECHWRIGHT;

    public static void register(IEventBus eventBus) {
        if (ModConfigs.ENABLE_ANDESITE_WORKER.get()) {
            ANDESITE_WORKER_POI = POI_TYPES.register("andesite_worker_poi",
                    () -> new PoiType(ImmutableSet.copyOf(AllBlocks.BASIN.get().getStateDefinition().getPossibleStates()), 1, 1));
            ANDESITE_WORKER = VILLAGER_PROFESSIONS.register("andesite_worker",
                    () -> new VillagerProfession("andesite_worker",
                            holder -> holder.get() == ANDESITE_WORKER_POI.get(), holder -> holder.get() == ANDESITE_WORKER_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }

        if (ModConfigs.ENABLE_BRASSWORKER.get()) {
            BRASSWORKER_POI = POI_TYPES.register("brassworker_poi",
                    () -> new PoiType(ImmutableSet.copyOf(AllBlocks.ROTATION_SPEED_CONTROLLER.get().getStateDefinition().getPossibleStates()), 1, 1));
            BRASSWORKER = VILLAGER_PROFESSIONS.register("brassworker",
                    () -> new VillagerProfession("brassworker",
                            holder -> holder.get() == BRASSWORKER_POI.get(), holder -> holder.get() == BRASSWORKER_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }

        if (ModConfigs.ENABLE_COPPERWORKER.get()) {
            COPPERWORKER_POI = POI_TYPES.register("copperworker_poi",
                    () -> new PoiType(ImmutableSet.copyOf(AllBlocks.STEAM_ENGINE.get().getStateDefinition().getPossibleStates()), 1, 1));
            COPPERWORKER = VILLAGER_PROFESSIONS.register("copperworker",
                    () -> new VillagerProfession("copperworker",
                            holder -> holder.get() == COPPERWORKER_POI.get(), holder -> holder.get() == COPPERWORKER_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }

        if (ModConfigs.ENABLE_MINER.get()) {
            MINER_POI = POI_TYPES.register("miner_poi",
                    () -> new PoiType(ImmutableSet.copyOf(AllBlocks.MECHANICAL_ARM.get().getStateDefinition().getPossibleStates()), 1, 1));
            MINER = VILLAGER_PROFESSIONS.register("miner",
                    () -> new VillagerProfession("miner",
                            holder -> holder.get() == MINER_POI.get(), holder -> holder.get() == MINER_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }
//        if (ModConfigs.ENABLE_TECHWRIGHT.get()) {
//            TECHWRIGHT_POI = POI_TYPES.register("techwright_poi",
//                    () -> new PoiType(ImmutableSet.copyOf(AllBlocks.PACKAGE_FROGPORT.get().getStateDefinition().getPossibleStates()), 1, 1));
//            TECHWRIGHT = VILLAGER_PROFESSIONS.register("techwright",
//                    () -> new VillagerProfession("techwright",
//                            holder -> holder.get() == TECHWRIGHT_POI.get(), holder -> holder.get() == TECHWRIGHT_POI.get(),
//                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
//        }

        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
