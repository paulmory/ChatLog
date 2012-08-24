package com.github.mbonachea.chatlog.cmd;

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
		DeityAPI.getAPI().getChatAPI().sendPlayerError(arg0, "ChatLog", "Chat database sucessfully purged!");
		DeityAPI.getAPI().getChatAPI().outSevere("ChatLog", "Chat database sucessfully purged!");
		return false;
	}

}
