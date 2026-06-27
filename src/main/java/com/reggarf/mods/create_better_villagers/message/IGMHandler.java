package com.reggarf.mods.create_better_villagers.message;

import com.reggarf.mods.create_better_villagers.CreateBetterVillagers;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public class IGMHandler {

    public static String titleColor = "DDA0FF";
    public static String zapColor = "00FFFF";
    public static String discordColor = "5599FF";
    public static String hostingColor = "00FFAA";
    public static String disableColor = "00FF66";
    public static String githubColor = "A9A9A9";

    public static void init() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.getPlayer();

            if (!CreateBetterVillagers.CONFIG.MESSAGE.ENABLE_IN_GAME_MESSAGE) {
                return;
            }
            NbtCompound persistentData = player.getCustomData();
            NbtCompound ig_data = persistentData.getCompound("ig_message_data");

            if (!ig_data.getBoolean("hasJoinedBefore")) {
                sendStyledMessages(player);

                ig_data.putBoolean("hasJoinedBefore", true);
                persistentData.put("ig_message_data", ig_data);
            }
        });
    }

    private static void sendStyledMessages(ServerPlayerEntity player) {
        Text title = Text.literal("Hello, thank you for downloading ")
                .append(Text.literal("Create: Better Villagers")
                        .setStyle(Style.EMPTY.withColor(parseTextColor(titleColor))));

        Text blankLine = Text.literal("");

        Text discord = Text.literal(" - ")
                .append(Text.literal("Join our Discord ")
                        .setStyle(Style.EMPTY
                                .withClickEvent(new ClickEvent(
                                        ClickEvent.Action.OPEN_URL,
                                        "https://discord.com/invite/CN962KMpJk"))
                                .withColor(parseTextColor(discordColor))
                                .withUnderline(true)))
                .append(Text.literal(" (support, updates)"));

        Text zap = Text.literal(" - ")
                .append(Text.literal("ZAP-Hosting ")
                        .setStyle(Style.EMPTY
                                .withClickEvent(new ClickEvent(
                                        ClickEvent.Action.OPEN_URL,
                                        "https://zap-hosting.com/reggarf"))
                                .withColor(parseTextColor(zapColor))
                                .withUnderline(true)))
                .append(Text.literal(" (20% off with code Reggarf-1047)"));

        Text disable = Text.literal(" - ")
                .append(Text.literal("Disable this message")
                        .setStyle(Style.EMPTY
                                .withClickEvent(new ClickEvent(
                                        ClickEvent.Action.OPEN_URL,
                                        "https://www.curseforge.com/minecraft/mc-mods/create-better-villager"))
                                .withColor(parseTextColor(disableColor))
                                .withUnderline(true)))
                .append(Text.literal(" (Mod config)"));

        Text issueTracker = Text.literal(" - ")
                .append(Text.literal("Issue Tracker")
                        .setStyle(Style.EMPTY
                                .withClickEvent(new ClickEvent(
                                        ClickEvent.Action.OPEN_URL,
                                        "https://github.com/Reggarfgod/create_better_villagers/issues"))
                                .withColor(parseTextColor(githubColor))
                                .withUnderline(true)))
                .append(Text.literal(" (github/wiki)"));

        player.sendMessage(title, false);
        player.sendMessage(blankLine, false);
        player.sendMessage(discord, false);
        player.sendMessage(zap, false);
        player.sendMessage(issueTracker, false);
        player.sendMessage(disable, false);
    }

    private static TextColor parseTextColor(String hex) {
        try {
            if (hex.startsWith("#")) hex = hex.substring(1);
            int rgb = Integer.parseInt(hex, 16);
            return TextColor.fromRgb(rgb);
        } catch (NumberFormatException e) {
            System.err.println("Invalid color format: " + hex);
            return TextColor.fromRgb(0xFFFFFF);
        }
    }
}