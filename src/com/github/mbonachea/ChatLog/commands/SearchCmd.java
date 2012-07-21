package com.github.mbonachea.ChatLog.commands;

import org.bukkit.entity.Player;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;
import com.imdeity.deityapi.records.DatabaseResults;

public class SearchCmd extends DeityCommandReceiver {
	@Override
	public boolean onConsoleRunCommand(String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		DatabaseResults chat = DeityAPI.getAPI().getDataAPI().getMySQL().readEnhanced("select `chat` where `player_name`='"+player.getName()+"'"+");");
		DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "ChatLog", player.getName() + "Said:" + chat);
		return false;
	}

}
