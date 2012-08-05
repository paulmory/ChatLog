package com.github.mbonachea.chatlog.cmd;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import com.github.mbonachea.chatlog.ChatLog;
import com.github.mbonachea.chatlog.Database;
import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;


public class SearchCmd extends DeityCommandReceiver {
	static Player target;

	@Override
	public boolean onConsoleRunCommand(String[] args) {
		if(args.length==1) {
			try{
				target = Bukkit.getPlayer(args[0]);
			}catch (Exception e){
				ChatLog.plugin.out("The player " + args[0] + " has never chatted on your server!");
				return false;
			}
			String chatText = Database.getChat(args[0]);
			DeityAPI.getAPI().getChatAPI().out("ChatLog", target.getName() + " said: " + chatText);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		if(args.length == 1) {
			try{
				target = Bukkit.getPlayer(args[0]);
			}catch (Exception e){
				DeityAPI.getAPI().getChatAPI().out("ChatLog", "That player has never chatted on this server!");
			}
			String chatText = Database.getChat(args[0]);
			DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", target.getName() + " said: " + chatText);
			return true;
		} else {
			return false;
		}
	}
}
