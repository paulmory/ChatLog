package com.github.mbonachea.chatlog.cmd;

import com.imdeity.deityapi.api.DeityCommandHandler;

public class CmdHandler extends DeityCommandHandler  {
	
	public CmdHandler(String plugin) {
		super(plugin, "ChatLog");
	}
	

	@Override
	protected void initRegisteredCommands() {
		this.registerCommand("search", null, "[player] [time] [s/m/h]" +
				"", "Searches a user's chat history", new SearchCmd(), "ChatLog.search");
	}
}
