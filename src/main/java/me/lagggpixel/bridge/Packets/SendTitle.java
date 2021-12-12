package me.lagggpixel.bridge.Packets;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SendTitle implements Listener {

    public static void SendPlayer(Player player, String StringTitle) {
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        IChatBaseComponent title = IChatBaseComponent.ChatSerializer.a("{'text': '" + StringTitle + "'}");

        PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, title, 1, 19, 1);
        connection.sendPacket(packetPlayOutTitle);
    }

}
