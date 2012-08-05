package com.github.mbonachea.chatlog.cmd;

import com.imdeity.deityapi.api.DeityCommandHandler;

public class CmdHandler extends DeityCommandHandler  {
	
	public CmdHandler(String plugin) {
		super(plugin, "ChatLog");
	}

	@Override
	protected void initRegisteredCommands() {
		this.registerCommand("search", "[player] [time] [s/m/h]", "Looks up chat history of a player in a specified time", new SearchCmd(), "chatlog.search");
	}
}
