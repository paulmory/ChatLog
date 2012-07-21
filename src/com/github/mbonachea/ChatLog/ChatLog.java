package com.github.mbonachea.ChatLog;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityPlugin;
import com.github.mbonachea.ChatLog.ChatListener;
import com.github.mbonachea.ChatLog.commands.CmdHandler;

public class ChatLog extends DeityPlugin {

	@Override
	protected void initCmds() {
		this.registerCommand(new CmdHandler("ChatLog"));
		
	}

	@Override
	protected void initConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDatabase() {
		DeityAPI.getAPI().getDataAPI().getMySQL().write("CREATE TABLE IF NOT EXISTS `chat_log` ("+"`id` INT(16) NOT NULL AUTO_INCREMENT PRIMARY KEY ,"+"`player_name` VARCHAR(16) NOT NULL"+"`chat` VARCHAR(28) NOT NULL"+");");
	}

	@Override
	protected void initInternalDatamembers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLanguage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initListeners() {
		this.registerListener(new ChatListener());
	}

	@Override
	protected void initPlugin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTasks() {
		// TODO Auto-generated method stub
		
	}
}
