package com.github.mbonachea.ChatLog.commands;

import com.imdeity.deityapi.api.DeityCommandHandler;

public class CmdHandler extends DeityCommandHandler  {
	public CmdHandler(String ChatLog, String chatlog) {
		super("ChatLog", "chatlog");
	}

	@Override
	protected void initRegisteredCommands() {
		this.registerCommand("search", "[player] <time>", "Looks up chat history of a player in a specified time", new SearchCmd(), "chatlog.search");
	}
}
