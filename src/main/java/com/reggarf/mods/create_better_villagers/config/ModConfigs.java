package com.reggarf.mods.create_better_villagers.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModConfigs {
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final String CATAGORY_VILLAGERS = "villagers";
    public static final String CATAGORY_MESSAGE = "message";
    public static ForgeConfigSpec.BooleanValue ENABLE_IN_GAME_MESSAGE;
    public static ForgeConfigSpec.BooleanValue ENABLE_ANDESITE_WORKER;
    public static ForgeConfigSpec.BooleanValue ENABLE_BRASSWORKER;
    public static ForgeConfigSpec.BooleanValue ENABLE_COPPERWORKER;
    public static ForgeConfigSpec.BooleanValue ENABLE_MINER;
   // public static ForgeConfigSpec.BooleanValue ENABLE_TECHWRIGHT;
   // public static ForgeConfigSpec.BooleanValue ENABLE_COPPER_MINER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        //builder.push("Villager Professions");
        builder.comment("Basic Motor").push(CATAGORY_MESSAGE);
        ENABLE_IN_GAME_MESSAGE = builder.comment("Enable In Game Message")
                .define("enableingamemessage", true);
        builder.pop();

        builder.comment("Basic Motor").push(CATAGORY_VILLAGERS);
        ENABLE_ANDESITE_WORKER = builder.comment("Enable Andesite Worker Profession",
                        "Requires game restart after changing this setting.")
                .define("enableAndesiteWorker", true);
        ENABLE_BRASSWORKER = builder.comment("Enable Brassworker Profession",
                        "Requires game restart after changing this setting.")
                .define("enableBrassworker", true);
        ENABLE_COPPERWORKER = builder.comment("Enable Copperworker Profession",
                        "Requires game restart after changing this setting.")
                .define("enableCopperworker", true);
        ENABLE_MINER = builder.comment("Enable Miner Profession",
                        "Requires game restart after changing this setting.")
                .define("enableMiner", true);
//        ENABLE_TECHWRIGHT = builder.comment("Enable Techwright Profession",
//                        "Requires game restart after changing this setting.")
//                .define("enabletechwrith", true);
//

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
