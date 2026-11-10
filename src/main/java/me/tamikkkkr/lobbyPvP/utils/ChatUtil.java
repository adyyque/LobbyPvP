
package me.tamikkkkr.lobbyPvP.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatUtil {

    private final JavaPlugin plugin;
    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
    private static final LegacyComponentSerializer LEGACY = LegacyComponentSerializer.legacySection();

    public ChatUtil(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static Component color(String text) {
        if (text == null || text.isEmpty()) return Component.empty();
        text = text.replaceAll("(?i)§0", "<black>");
        text = text.replaceAll("(?i)§1", "<dark_blue>");
        text = text.replaceAll("(?i)§2", "<dark_green>");
        text = text.replaceAll("(?i)§3", "<dark_aqua>");
        text = text.replaceAll("(?i)§4", "<dark_red>");
        text = text.replaceAll("(?i)§5", "<dark_purple>");
        text = text.replaceAll("(?i)§6", "<gold>");
        text = text.replaceAll("(?i)§7", "<gray>");
        text = text.replaceAll("(?i)§8", "<dark_gray>");
        text = text.replaceAll("(?i)§9", "<blue>");
        text = text.replaceAll("(?i)§a", "<green>");
        text = text.replaceAll("(?i)§b", "<aqua>");
        text = text.replaceAll("(?i)§c", "<red>");
        text = text.replaceAll("(?i)§d", "<light_purple>");
        text = text.replaceAll("(?i)§e", "<yellow>");
        text = text.replaceAll("(?i)§f", "<white>");
        text = text.replaceAll("(?i)§l", "<bold>");
        text = text.replaceAll("(?i)§o", "<italic>");
        text = text.replaceAll("(?i)§n", "<underlined>");
        text = text.replaceAll("(?i)§m", "<strikethrough>");
        text = text.replaceAll("(?i)§k", "<obfuscated>");
        text = text.replaceAll("(?i)§r", "<reset>");
        text = text.replaceAll("(?i)&#([a-f0-9]{6})", "<#$1>");
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
        if (text == null) return "";
        return LEGACY.serialize(color(text));
    }

    public void sendMessage(Player player, String msg) {
        if (player == null || msg == null || msg.isEmpty()) return;
        player.sendMessage(colorLegacy(msg));
    }

    public void sendTitle(Player player, String msg, String subMsg, int fadeIn, int stay, int fadeOut) {
        if (player == null) return;
        player.sendTitle(colorLegacy(msg), colorLegacy(subMsg), fadeIn, stay, fadeOut);
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
        broadcastTitle(msg, subMsg, 10, 70, 20);
    }

    public void close() {
    }
}
