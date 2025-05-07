package com.reggarf.mods.create_better_villagers.client;



import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientIniter {
    public static void onInitializeClient(final FMLClientSetupEvent event) {
        Client.onInitializeClient(event);
    }
}
