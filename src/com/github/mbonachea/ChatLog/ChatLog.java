package com.github.mbonachea.ChatLog;




import com.github.mbonachea.ChatLog.commands.CmdHandler;
import com.github.mbonachea.ChatLog.listeners.ChatListener;
import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityPlugin;

public class ChatLog extends DeityPlugin {
	public static ChatLog plugin;
	

	@Override
	protected void initCmds() {
		this.registerCommand(new CmdHandler("ChatLog"));
		
	}

	@Override
	protected void initConfig() {
		
	}

	@Override
	protected void initDatabase() {
		DeityAPI.getAPI().getDataAPI().getMySQL().write("CREATE TABLE IF NOT EXISTS `chat_log` (`id` INT(16) NOT NULL AUTO_INCREMENT PRIMARY KEY ,`player_name` VARCHAR(16) NOT NULL, `chat` VARCHAR(256) NOT NULL, `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)");
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
		plugin = this; 
		
	}

	@Override
	protected void initTasks() {
		// TODO Auto-generated method stub
		
	}
	
	public void out(String out) {
		getLogger().info(out);
	}
}
