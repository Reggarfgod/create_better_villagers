package com.reggarf.mods.create_better_villagers.config;


import com.reggarf.mods.create_better_villagers.CreateBetterVillagers;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = CreateBetterVillagers.MOD_ID)
@Config.Gui.Background("create:textures/block/brass_block.png")
public class ModConfigs extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("message")
    @ConfigEntry.Gui.TransitiveObject()
    public Message MESSAGE = new Message();

    @ConfigEntry.Category("villagers")
    @ConfigEntry.Gui.TransitiveObject()
    public Villagers VILLAGERS = new Villagers();

    @Config(name = "message")
    public static class Message implements ConfigData {

        @ConfigEntry.Gui.Tooltip
        @Comment("Enable in-game message")
        public boolean ENABLE_IN_GAME_MESSAGE = true;
    }

    @Config(name = "villagers")
    public static class Villagers implements ConfigData {

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Enable Andesite Worker profession")
        public boolean ENABLE_ANDESITE_WORKER = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Enable Brassworker profession")
        public boolean ENABLE_BRASSWORKER = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Enable Copperworker profession")
        public boolean ENABLE_COPPERWORKER = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Enable Miner profession")
        public boolean ENABLE_MINER = true;
    }
}