package com.github.mbonachea.chatlog.cmd;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;

public class LogChatCmd extends DeityCommandReceiver {

	@Override
	public boolean onConsoleRunCommand(String[] args) {
		String value = args[0];
		if(value == "true") {
			if(DeityAPI.plugin.config.getBoolean("log_chat")==true) {
				DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "Chat logging is already true!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_chat", true);
				DeityAPI.getAPI().getChatAPI().out("ChatLog", "log_chat set to true");
				return true;
			}
		} else if(value == "false") {
			if(DeityAPI.plugin.config.getBoolean("log_chat")==false) {
				DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "Chat logging is already false!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_chat", false);
				DeityAPI.getAPI().getChatAPI().out("ChatLog", "log_chat set to false");
				return true;
			}
		} else {
			DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "You must specify true or false");
			return true;
		}
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		String value = args[0];
		if(value == "true") {
			if(DeityAPI.plugin.config.getBoolean("log_chat")==true) {
				DeityAPI.getAPI().getChatAPI().sendPlayerError(player, "ChatLog", "Chat logging is already true!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_chat", true);
				DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", ChatColor.YELLOW + "log_chat set to true");
				return true;
			}
		} else if(value == "false") {
			if(DeityAPI.plugin.config.getBoolean("log_chat")==false) {
				DeityAPI.getAPI().getChatAPI().sendPlayerError(player, "ChatLog", "Chat logging is already false!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_chat", false);
				DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", ChatColor.YELLOW + "log_chat set to false");
				return true;
			}
		} else {
			DeityAPI.getAPI().getChatAPI().sendPlayerError(player, "ChatLog", "You must specify true or false");
			return true;
		}
	}

}
