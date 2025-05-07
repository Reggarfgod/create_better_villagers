package com.reggarf.mods.create_better_villagers.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModConfigs {
    public static final ForgeConfigSpec COMMON_SPEC;

    // Villager profession enabling flags
    public static ForgeConfigSpec.BooleanValue ENABLE_IN_GAME_MESSAGE;
    public static ForgeConfigSpec.BooleanValue ENABLE_ANDESITE_WORKER;
    public static ForgeConfigSpec.BooleanValue ENABLE_BRASSWORKER;
    public static ForgeConfigSpec.BooleanValue ENABLE_COPPERWORKER;
    public static ForgeConfigSpec.BooleanValue ENABLE_MINER;
    public static ForgeConfigSpec.BooleanValue ENABLE_BRASS_MINER;
    public static ForgeConfigSpec.BooleanValue ENABLE_COPPER_MINER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Villager Professions");

        ENABLE_IN_GAME_MESSAGE = builder.comment("Enable in game message")
                .define("enableingamemessage", true);

        ENABLE_ANDESITE_WORKER = builder.comment("Enable Andesite Worker Profession")
                .define("enableAndesiteWorker", true);
        ENABLE_BRASSWORKER = builder.comment("Enable Brassworker Profession")
                .define("enableBrassworker", true);
        ENABLE_COPPERWORKER = builder.comment("Enable Copperworker Profession")
                .define("enableCopperworker", true);
        ENABLE_MINER = builder.comment("Enable Miner Profession")
                .define("enableMiner", true);
//        ENABLE_BRASS_MINER = builder.comment("Enable Brass Miner Profession")
//                .define("enableBrassMiner", true);
//        ENABLE_COPPER_MINER = builder.comment("Enable Copper Miner Profession")
//                .define("enableCopperMiner", true);

        builder.pop();

        COMMON_SPEC = builder.build();
    }
    public static void loadConfig(ForgeConfigSpec spec, java.nio.file.Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();
        configData.load();
        spec.setConfig(configData);
    }
}
