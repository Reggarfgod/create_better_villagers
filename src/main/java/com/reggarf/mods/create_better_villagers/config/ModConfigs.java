package com.reggarf.mods.create_better_villagers.config;

import com.reggarf.mods.create_better_villagers.Create_better_villagers;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;


@Config(name = "create_better_villagers")
@Config.Gui.Background("minecraft:textures/block/mossy_cobblestone.png")
public class ModConfigs extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject()
    public Common common = new Common();

    @Config(name = "common")
    public static final class Common implements ConfigData {

        @ConfigEntry.Gui.Tooltip
        @Comment("Enable or disable the welcome message, Requires game restart after changing this setting.")
        public Boolean ENABLE_IN_GAME_MESSAGE = true;

        @ConfigEntry.Gui.Tooltip
        @Comment("Enable Andesite Worker Profession, Requires game restart after changing this setting.")
        public Boolean ENABLE_ANDESITE_WORKER = true;

        @ConfigEntry.Gui.Tooltip
        @Comment("Enable Brassworker Profession, Requires game restart after changing this setting.")
        public Boolean ENABLE_BRASSWORKER = true;

        @ConfigEntry.Gui.Tooltip
        @Comment("Enable Copperworker Profession, Requires game restart after changing this setting.")
        public Boolean ENABLE_COPPERWORKER = true;

        @ConfigEntry.Gui.Tooltip
        @Comment("Enable Miner Profession, Requires game restart after changing this setting.")
        public Boolean ENABLE_MINER = true;
    }
}
