package com.reggarf.mods.create_better_villagers.init;

import com.google.common.collect.ImmutableSet;
import com.reggarf.mods.create_better_villagers.Create_better_villagers;
import com.simibubi.create.AllBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.reggarf.mods.create_better_villagers.Create_better_villagers.MODID;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, MODID);

    public static Holder<PoiType> ANDESITE_WORKER_POI;
    public static Holder<VillagerProfession> ANDESITE_WORKER;

    public static Holder<PoiType> BRASSWORKER_POI;
    public static Holder<VillagerProfession> BRASSWORKER;

    public static Holder<PoiType> COPPERWORKER_POI;
    public static Holder<VillagerProfession> COPPERWORKER;

    public static Holder<PoiType> MINER_POI;
    public static Holder<VillagerProfession> MINER;

    public static Holder<PoiType> TECHWRIGHT_POI;
    public static Holder<VillagerProfession> TECHWRIGHT;

    public static void register(IEventBus eventBus) {
        // Register POIs
        ANDESITE_WORKER_POI = POI_TYPES.register("andesite_worker_poi",
                () -> new PoiType(ImmutableSet.copyOf(AllBlocks.BASIN.get().getStateDefinition().getPossibleStates()), 1, 1));

        BRASSWORKER_POI = POI_TYPES.register("brassworker_poi",
                () -> new PoiType(ImmutableSet.copyOf(AllBlocks.ROTATION_SPEED_CONTROLLER.get().getStateDefinition().getPossibleStates()), 1, 1));

        COPPERWORKER_POI = POI_TYPES.register("copperworker_poi",
                () -> new PoiType(ImmutableSet.copyOf(AllBlocks.STEAM_ENGINE.get().getStateDefinition().getPossibleStates()), 1, 1));

        MINER_POI = POI_TYPES.register("miner_poi",
                () -> new PoiType(ImmutableSet.copyOf(AllBlocks.MECHANICAL_ARM.get().getStateDefinition().getPossibleStates()), 1, 1));

        // Register Professions conditionally
        if (Create_better_villagers.CONFIG.common.ENABLE_ANDESITE_WORKER) {
            ANDESITE_WORKER = VILLAGER_PROFESSIONS.register("andesite_worker",
                    () -> new VillagerProfession("andesite_worker",
                            holder -> holder.value() == ANDESITE_WORKER_POI.value(), holder -> holder.value() == ANDESITE_WORKER_POI.value(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }

        if (Create_better_villagers.CONFIG.common.ENABLE_BRASSWORKER) {
            BRASSWORKER = VILLAGER_PROFESSIONS.register("brassworker",
                    () -> new VillagerProfession("brassworker",
                            holder -> holder.value() == BRASSWORKER_POI.value(), holder -> holder.value() == BRASSWORKER_POI.value(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }

        if (Create_better_villagers.CONFIG.common.ENABLE_COPPERWORKER) {
            COPPERWORKER = VILLAGER_PROFESSIONS.register("copperworker",
                    () -> new VillagerProfession("copperworker",
                            holder -> holder.value() == COPPERWORKER_POI.value(), holder -> holder.value() == COPPERWORKER_POI.value(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }

        if (Create_better_villagers.CONFIG.common.ENABLE_MINER) {
            MINER = VILLAGER_PROFESSIONS.register("miner",
                    () -> new VillagerProfession("miner",
                            holder -> holder.value() == MINER_POI.value(), holder -> holder.value() == MINER_POI.value(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
        }



        // Register POI and professions to the event bus just once
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
