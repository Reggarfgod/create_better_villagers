package com.reggarf.mods.create_better_villagers.datagen;

import com.reggarf.mods.create_better_villagers.CreateBetterVillagers;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.concurrent.CompletableFuture;

public class CBVModPoiTagProvider extends TagProvider<PointOfInterestType> {
    public CBVModPoiTagProvider(DataOutput output,
                                CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new Identifier(CreateBetterVillagers.MOD_ID, "andesite_worker_poi"));
        this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new Identifier(CreateBetterVillagers.MOD_ID, "brass_worker_poi"));
        this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new Identifier(CreateBetterVillagers.MOD_ID, "copper_worker_poi"));
        this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new Identifier(CreateBetterVillagers.MOD_ID, "miner_poi"));
    }
}
