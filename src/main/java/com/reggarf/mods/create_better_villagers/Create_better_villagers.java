package com.reggarf.mods.create_better_villagers;


import com.reggarf.mods.create_better_villagers.config.ModConfigs;


import com.reggarf.mods.create_better_villagers.init.ModVillagers;
import com.reggarf.mods.create_better_villagers.message.IGMHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Create_better_villagers.MODID)
public class Create_better_villagers {
    public static final String MODID = "create_better_villagers";
    public static final Logger LOGGER = LogManager.getLogger(Create_better_villagers.class);
    public static ModConfigs CONFIG;
    //private static boolean networkingRegistered = false;
    //private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

    public Create_better_villagers(IEventBus modEventBus, ModContainer modContainer) {

        /// /////////////////////////////////////////////////

        AutoConfig.register(ModConfigs.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        CONFIG = AutoConfig.getConfigHolder(ModConfigs.class).getConfig();
        /// ///////////////////////////////////////////////////


        NeoForge.EVENT_BUS.register(this);


        //modEventBus.addListener(ClientIniter::onInitializeClient);
        NeoForge.EVENT_BUS.register(IGMHandler.class);

        //VillagerProfessions.PROFESSIONS.register(modEventBus);
        ModVillagers.register(modEventBus);
        LOGGER.info("Hello 1.21.1 Create!");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (container, parent) -> {
                return AutoConfig.getConfigScreen(ModConfigs.class, parent).get();
            });

        }
    }
}
//    private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
//    }
//
//    public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
//        if (networkingRegistered)
//            throw new IllegalStateException("Cannot register new network messages after networking has been registered");
//        MESSAGES.put(id, new NetworkMessage<>(reader, handler));
//    }
//
//    @SuppressWarnings({"rawtypes", "unchecked"})
//    private void registerNetworking(final RegisterPayloadHandlersEvent event) {
//        final PayloadRegistrar registrar = event.registrar(MODID);
//        MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
//        networkingRegistered = true;
//    }
//
//    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
//
//    public static void queueServerWork(int tick, Runnable action) {
//        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
//            workQueue.add(new Tuple<>(action, tick));
//    }
//
//    @SubscribeEvent
//    public void tick(ServerTickEvent.Post event) {
//        List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
//        workQueue.forEach(work -> {
//            work.setB(work.getB() - 1);
//            if (work.getB() == 0)
//                actions.add(work);
//        });
//        actions.forEach(e -> e.getA().run());
//        workQueue.removeAll(actions);
//    }

