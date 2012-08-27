package com.github.mbonachea.chatlog.cmd;

import com.imdeity.deityapi.api.DeityCommandHandler;

public class CmdHandler extends DeityCommandHandler  {
	
	public CmdHandler(String plugin) {
		super(plugin, "ChatLog");
	}
	

	@Override
	protected void initRegisteredCommands() {
		this.registerCommand("search", null, "[type] [player] [time] [s/m/h]" +
				"", "Searches a user's chat history", new SearchCmd(), "ChatLog.search");
		this.registerCommand("purge", null, "", "Purges the chat database", new PurgeCmd(), "ChatLog.purge");
		this.registerCommand("logchat", null, "[true/false]", "Sets whether or not to log chat", new LogChatCmd(), "ChatLog.logchat");
		this.registerCommand("logcmds", null, "[true/false]", "Sets whether or not to log commands", new LogCmdsCmd(), "ChatLog.logcmds");
	}
}
