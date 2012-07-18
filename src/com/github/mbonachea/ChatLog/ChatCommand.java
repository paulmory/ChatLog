package com.github.mbonachea.ChatLog;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandHandler;

public class ChatCommand extends DeityCommandHandler  {
	private  ChatLog plugin;
	
	public ChatCommand(String plugin) {
		super(plugin, "ChatLog");
	}

	@Override
	protected void initRegisteredCommands() {
		// TODO Auto-generated method stub
		
	}
}
