package com.github.mbonachea.ChatLog.commands;

import com.github.mbonachea.ChatLog.ChatLog;
import com.imdeity.deityapi.api.DeityCommandHandler;

public class CmdHandler extends DeityCommandHandler  {
	@SuppressWarnings("unused")
	private  ChatLog plugin;
	
	public CmdHandler(String plugin) {
		super(plugin, "ChatLog");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void initRegisteredCommands() {
		this.registerCommand("search", "[player] <time>", "Looks up chat history of a player in a specified time", new SearchCmd(), "chatlog.search");
	}
}
