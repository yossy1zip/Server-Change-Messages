package me.stoofles.ServerChangeMessages;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener {
    @EventHandler
    public void onPostSwitch(ServerSwitchEvent serverSwitchEvent) {
        TextComponent message = new TextComponent(serverSwitchEvent.getPlayer() + " が" + serverSwitchEvent.getPlayer().getServer().getInfo().getName() + "サーバーに移動しました");
        message.setColor( net.md_5.bungee.api.ChatColor.GREEN );
        for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            if(!(serverSwitchEvent.getFrom() == null)){
                player.sendMessage(message);
            }
        }
    }
}
