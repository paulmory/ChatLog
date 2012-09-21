package com.github.mbonachea.chatlog.cmd;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.github.mbonachea.chatlog.obj.Database;
import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;

public class PurgeCmd extends DeityCommandReceiver {

	@Override
	public boolean onConsoleRunCommand(String[] arg0) {
		Database.purgeDatabase();
		DeityAPI.getAPI().getChatAPI().outSevere("ChatLog", "Chat database sucessfully purged!");
		return false;
	}

	@Override
	public boolean onPlayerRunCommand(Player arg0, String[] arg1) {
		Database.purgeDatabase();
		if(Database.purgeDatabase() == true) {
			DeityAPI.getAPI().getChatAPI().sendPlayerMessage(arg0, "ChatLog", ChatColor.RED + "Database sucessfully purged!");
			DeityAPI.getAPI().getChatAPI().outSevere("ChatLog", "Database sucessfully purged!");
		} else {
			DeityAPI.getAPI().getChatAPI().sendPlayerError(arg0, "ChatLog", "Database purge unsuccessful!");
			DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "Database purge unsuccessful!");
		}
		return false;
	}

}
