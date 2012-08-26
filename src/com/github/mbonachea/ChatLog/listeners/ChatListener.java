package com.github.mbonachea.chatlog.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityListener;


public class ChatListener extends DeityListener {
	Player player;	
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		if(DeityAPI.plugin.config.getBoolean("log_chat")==true) {
			player = event.getPlayer();
			String chat = event.getMessage();
			String sql = ("insert into `chat_log` (`player_name`, `chat`, `time`) values (?, ?, NOW())");
			DeityAPI.getAPI().getDataAPI().getMySQL().write(sql, player.getName(), chat);
		} 
	}
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
		if(DeityAPI.plugin.config.getBoolean("log_commands")==true) {
			player = event.getPlayer();
			String command = event.getMessage();
			String sql = ("insert into `command_log` (`player_name`, `command`, `time`) values (?, ?, NOW()");
			DeityAPI.getAPI().getDataAPI().getMySQL().write(sql, player, command);
		}
	}
}
