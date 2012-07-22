package com.github.mbonachea.ChatLog.commands;

import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.mbonachea.ChatLog.obj.Database;
import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;
import com.imdeity.deityapi.records.DatabaseResults;

public class SearchCmd extends DeityCommandReceiver {
	@Override
	public boolean onConsoleRunCommand(String[] args) {
		if(args.length==1) {
			Player target = Bukkit.getPlayer(args[0]);
			String chat = Database.getChat();
			DeityAPI.getAPI().getChatAPI().out("ChatLog", target.getName() + "Said:" + chat);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		if(args.length==1) {
			Player target = Bukkit.getPlayer(args[0]);
			DatabaseResults chat = DeityAPI.getAPI().getDataAPI().getMySQL().readEnhanced("select `chat` where `player_name`='"+target.getName()+"'"+");");
			DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", target.getName() + "Said:" + chat);
			return true;
		} else {
			return false;
		}
	}
}
