package com.reggarf.mods.create_better_villagers;

import com.reggarf.mods.create_better_villagers.client.ClientIniter;
import com.reggarf.mods.create_better_villagers.config.ModConfigs;
import com.reggarf.mods.create_better_villagers.init.ModVillagers;
import com.reggarf.mods.create_better_villagers.message.IGMHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("create_better_villagers")
public class CreateBetterVillagersMod {
	public static final Logger LOGGER = LogManager.getLogger(CreateBetterVillagersMod.class);
	public static final String MODID = "create_better_villagers";

	public CreateBetterVillagersMod() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON_SPEC);
		ModConfigs.loadConfig(ModConfigs.COMMON_SPEC, FMLPaths.CONFIGDIR.get().resolve("create_better_villagers-common.toml"));
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientIniter::onInitializeClient);
		//CreateBetterVillagersModVillagerProfessions.PROFESSIONS.register(bus);
		ModVillagers.register(bus);
		MinecraftForge.EVENT_BUS.register(IGMHandler.class);
		LOGGER.info("Hello Forge world!");
	}

//	// Network packet handler
//	private static final String PROTOCOL_VERSION = "1";
//	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
//	private static int messageID = 0;
//
//	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
//		PACKET_HANDLER.registerMessage(messageID++, messageType, encoder, decoder, messageConsumer);
//	}
//
//	// Task scheduling
//	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
//
//	public static void queueServerWork(int tick, Runnable action) {
//		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
//			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
//	}
//
//	@SubscribeEvent
//	public void tick(TickEvent.ServerTickEvent event) {
//		if (event.phase == TickEvent.Phase.END) {
//			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
//			workQueue.forEach(work -> {
//				work.setValue(work.getValue() - 1);
//				if (work.getValue() == 0)
//					actions.add(work);
//			});
//			actions.forEach(e -> e.getKey().run());
//			workQueue.removeAll(actions);
//		}
//	}
}
