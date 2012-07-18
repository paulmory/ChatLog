package com.github.mbonachea.ChatLog;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;


public class ChatListener implements Listener {
	private final ChatLog plugin;
	
	public ChatListener(ChatLog plugin) {
		this.plugin  = plugin;
	}
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		
	}
}
