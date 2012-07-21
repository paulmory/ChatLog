package com.github.mbonachea.ChatLog.commands;

import com.github.mbonachea.ChatLog.ChatLog;
import com.imdeity.deityapi.api.DeityCommandHandler;

public class CmdHandler extends DeityCommandHandler  {
	private  ChatLog plugin;
	
	public CmdHandler(String plugin) {
		super(plugin, "ChatLog");
	}

	@Override
	protected void initRegisteredCommands() {
		this.registerCommand("search", "[player] <time>", "Looks up chat history of a player in a specified time", new SearchCmd(), "chatlog.lookup");
	}
}
