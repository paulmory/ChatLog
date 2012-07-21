package com.github.mbonachea.ChatLog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityListener;


public class ChatListener extends DeityListener {
	Player player;	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		player = event.getPlayer();
		String chat = event.getMessage();
		DeityAPI.getAPI().getDataAPI().getMySQL().write("insert into `chat_log` (`player_name`, `chat`) values ('" + player.getName() + "', '" + chat + "');");
	}
}
