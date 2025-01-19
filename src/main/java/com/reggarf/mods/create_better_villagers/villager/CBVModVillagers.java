package com.reggarf.mods.create_better_villagers.villager;

import com.google.common.collect.ImmutableSet;
import com.reggarf.mods.create_better_villagers.CreateBetterVillagers;
import com.simibubi.create.AllBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class CBVModVillagers {




    public static final RegistryKey<PointOfInterestType> ANDESITE_WORKER_POI_KEY = poiKey("andesite_worker_poi");
    public static final PointOfInterestType ANDESITE_WORKER_POI = registerPoi("andesite_worker_poi", AllBlocks.BASIN.get());
    public static final VillagerProfession ANDESITE_WORKER = registerProfession("andesite_worker", ANDESITE_WORKER_POI_KEY);



    public static final RegistryKey<PointOfInterestType> BRASS_WORKER_POI_KEY = poiKey("brass_worker_poi");
    public static final PointOfInterestType BRASS_WORKER_POI = registerPoi("brass_worker_poi", AllBlocks.ROTATION_SPEED_CONTROLLER.get());
    public static final VillagerProfession BRASS_WORKER = registerProfession("brass_worker", BRASS_WORKER_POI_KEY);


    public static final RegistryKey<PointOfInterestType> COPPER_WORKER_POI_KEY = poiKey("copper_worker_poi");
    public static final PointOfInterestType COPPER_WORKER_POI = registerPoi("copper_worker_poi", AllBlocks.STEAM_ENGINE.get());
    public static final VillagerProfession COPPER_WORKER = registerProfession("copper_worker", COPPER_WORKER_POI_KEY);



    public static final RegistryKey<PointOfInterestType> MINER_POI_KEY = poiKey("miner_poi");
    public static final PointOfInterestType MINER_POI = registerPoi("miner_poi", AllBlocks.MECHANICAL_ARM.get());
    public static final VillagerProfession MINER = registerProfession("miner", MINER_POI_KEY);



    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(CreateBetterVillagers.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(CreateBetterVillagers.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(CreateBetterVillagers.MOD_ID, name));
    }

    public static void registerVillagers() {
        CreateBetterVillagers.LOGGER.info("Registering Villagers " + CreateBetterVillagers.MOD_ID);
    }
}
