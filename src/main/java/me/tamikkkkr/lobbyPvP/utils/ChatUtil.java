package me.tamikkkkr.lobbyPvP.utils;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;

public class ChatUtil {

    private final JavaPlugin plugin;
    private final BukkitAudiences adventure;
    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    public ChatUtil(JavaPlugin plugin) {
        this.plugin = plugin;
        this.adventure = BukkitAudiences.create(plugin);
    }

    public static Component color(String text) {
        if (text == null) return Component.empty();

        text = text.replaceAll("&#([a-fA-F0-9]{6})", "<#$1>");
        text = text.replaceAll("(?i)&0", "<black>");
        text = text.replaceAll("(?i)&1", "<dark_blue>");
        text = text.replaceAll("(?i)&2", "<dark_green>");
        text = text.replaceAll("(?i)&3", "<dark_aqua>");
        text = text.replaceAll("(?i)&4", "<dark_red>");
        text = text.replaceAll("(?i)&5", "<dark_purple>");
        text = text.replaceAll("(?i)&6", "<gold>");
        text = text.replaceAll("(?i)&7", "<gray>");
        text = text.replaceAll("(?i)&8", "<dark_gray>");
        text = text.replaceAll("(?i)&9", "<blue>");
        text = text.replaceAll("(?i)&a", "<green>");
        text = text.replaceAll("(?i)&b", "<aqua>");
        text = text.replaceAll("(?i)&c", "<red>");
        text = text.replaceAll("(?i)&d", "<light_purple>");
        text = text.replaceAll("(?i)&e", "<yellow>");
        text = text.replaceAll("(?i)&f", "<white>");
        text = text.replaceAll("(?i)&k", "<obfuscated>");
        text = text.replaceAll("(?i)&l", "<bold>");
        text = text.replaceAll("(?i)&m", "<strikethrough>");
        text = text.replaceAll("(?i)&n", "<underlined>");
        text = text.replaceAll("(?i)&o", "<italic>");
        text = text.replaceAll("(?i)&r", "<reset>");

        return MINI_MESSAGE.deserialize(text);
    }
    public static String colorLegacy(String text) {
        if (text == null) {
            return "";
        }

        return LegacyComponentSerializer.legacySection()
                .serialize(color(text));
    }
    public void sendMessage(Player player, String msg) {
        adventure.player(player).sendMessage(color(msg));
    }

    public void sendTitle(Player player, String msg, String subMsg, int fadeIn, int stay, int fadeOut) {
        adventure.player(player).showTitle(
                Title.title(color(msg), color(subMsg), Title.Times.times(
                                Duration.ofMillis(fadeIn * 50L),
                                Duration.ofMillis(stay * 50L),
                                Duration.ofMillis(fadeOut * 50L)
                        )
                )
        );
    }

    public void sendTitle(Player player, String msg, String subMsg) {
        sendTitle(player, msg, subMsg, 10, 70, 20);
    }

    public void broadcastMessage(String msg) {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            sendMessage(player, msg);
        }
    }

    public void broadcastTitle(String msg, String subMsg, int fadeIn, int stay, int fadeOut) {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            sendTitle(player, msg, subMsg, fadeIn, stay, fadeOut);
        }
    }

    public void broadcastTitle(String msg, String subMsg) {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            sendTitle(player, msg, subMsg);
        }
    }
    public void close() {
        adventure.close();
    }
}