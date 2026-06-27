package com.reggarf.mods.create_better_villagers;

import com.reggarf.mods.create_better_villagers.config.ModConfigs;
import com.reggarf.mods.create_better_villagers.message.IGMHandler;
import com.reggarf.mods.create_better_villagers.util.CBVModCustomTrades;
import com.reggarf.mods.create_better_villagers.villager.CBVModVillagers;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateBetterVillagers implements ModInitializer {
	public static final String MOD_ID = "create-better-villagers";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ModConfigs CONFIG;
	@Override
	public void onInitialize() {

		AutoConfig.register(
				ModConfigs.class,
				PartitioningSerializer.wrap(GsonConfigSerializer::new)
		);

		CONFIG = AutoConfig.getConfigHolder(ModConfigs.class).getConfig();

		IGMHandler.init();

		if (System.getProperty("fabric-api.datagen") != null) {
			LOGGER.info("Datagen detected, skipping villager registration");
			return;
		}

		CBVModVillagers.registerVillagers();
		CBVModCustomTrades.registerCustomTrades();

		LOGGER.info("Hello Fabric world!");
	}
}