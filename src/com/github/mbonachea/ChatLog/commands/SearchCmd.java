package com.github.mbonachea.ChatLog.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.mbonachea.ChatLog.obj.Database;
import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;

public class SearchCmd extends DeityCommandReceiver {
	@Override
	public boolean onConsoleRunCommand(String[] args) {
		if(args.length==1) {
			Player target = Bukkit.getPlayer(args[0]);
			String chatText = Database.getChat();
			DeityAPI.getAPI().getChatAPI().out("ChatLog", target.getName() + "Said: " + chatText);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		if(args.length==1) {
			Player target = Bukkit.getPlayer(args[0]);
			String chatText = Database.getChat();
			DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", target.getName() + "Said: " + chatText);
			return true;
		} else {
			return false;
		}
	}
}
