package com.github.mbonachea.chatlog.cmd;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;

public class LogCmdsCmd extends DeityCommandReceiver {

	@Override
	public boolean onConsoleRunCommand(String[] args) {
		String value = args[0];
		if(value == "true") {
			if(DeityAPI.plugin.config.getBoolean("log_commands")==true) {
				DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "Command logging is already true!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_commands", true);
				DeityAPI.getAPI().getChatAPI().out("ChatLog", "log_commands set to true");
				return true;
			}
		} else if(value == "false") {
			if(DeityAPI.plugin.config.getBoolean("log_commands")==false) {
				DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "Command logging is already false!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_commands", false);
				DeityAPI.getAPI().getChatAPI().out("ChatLog", "log_commands set to false");
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
			if(DeityAPI.plugin.config.getBoolean("log_commands")==true) {
				DeityAPI.getAPI().getChatAPI().sendPlayerError(player, "ChatLog", "Command logging is already true!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_commands", true);
				DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", ChatColor.YELLOW + "log_commands set to true");
				return true;
			}
		} else if(value == "false") {
			if(DeityAPI.plugin.config.getBoolean("log_commands")==false) {
				DeityAPI.getAPI().getChatAPI().sendPlayerError(player, "ChatLog", "Command logging is already false!");
				return true;
			} else {
				DeityAPI.plugin.config.set("log_commands", false);
				DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", ChatColor.YELLOW + "log_commands set to false");
				return true;
			}
		} else {
			DeityAPI.getAPI().getChatAPI().sendPlayerError(player, "ChatLog", "You must specify true or false");
			return true;
		}
	}

}
