package com.reggarf.mods.create_better_villagers;

import com.reggarf.mods.create_better_villagers.util.CBVModCustomTrades;
import com.reggarf.mods.create_better_villagers.villager.CBVModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateBetterVillagers implements ModInitializer {
	public static final String MOD_ID = "create-better-villagers";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CBVModCustomTrades.registerCustomTrades();

		CBVModVillagers.registerVillagers();

		LOGGER.info("Hello Fabric world!");
	}
}