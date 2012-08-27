package com.github.mbonachea.chatlog;




import com.github.mbonachea.chatlog.cmd.CmdHandler;
import com.github.mbonachea.chatlog.listeners.ChatListener;
import com.github.mbonachea.chatlog.obj.Database;
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
		this.config.addDefaultConfigValue("log-chat", true);
		this.config.addDefaultConfigValue("log-commands", true);
		this.config.addDefaultConfigValue("database-auto-purge-days", 30);
		this.config.addDefaultConfigValue("last-purge", System.currentTimeMillis());
	}

	@Override
	protected void initDatabase() {
		DeityAPI.getAPI().getDataAPI().getMySQL().write("CREATE TABLE IF NOT EXISTS `chat_log` (`id` INT(16) NOT NULL AUTO_INCREMENT PRIMARY KEY ,`player_name` VARCHAR(16) NOT NULL, `chat` VARCHAR(256) NOT NULL, `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)");
		DeityAPI.getAPI().getDataAPI().getMySQL().write("CREATE TABLE IF NOT EXISTS `command_log` (`id` INT(16) NOT NULL AUTO_INCREMENT PRIMARY KEY ,`player_name` VARCHAR(16) NOT NULL, `command` VARCHAR(256) NOT NULL, `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)");
	}

	@Override
	protected void initInternalDatamembers() {
		if(System.currentTimeMillis() - this.config.getLong("last-purge") > (this.config.getLong("database-auto-purge-days") * 24 * 60 * 60 * 1000)) {
			Database.purgeDatabase();
		}
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
}
