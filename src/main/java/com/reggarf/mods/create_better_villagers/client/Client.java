//package com.reggarf.mods.create_better_villagers.client;
//
//import net.neoforged.fml.ModLoadingContext;
//import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
//import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
//import net.createmod.catnip.config.ui.BaseConfigScreen;
//import static com.reggarf.mods.create_better_villagers.Create_better_villagers.MODID;
//
//public class Client {
//    public static void onInitializeClient(final FMLClientSetupEvent event) {
//
//        ModLoadingContext.get().registerExtensionPoint(
//                IConfigScreenFactory.class,
//                () -> (mc, previous) -> new BaseConfigScreen(previous, MODID)
//        );
//    }
//
//}