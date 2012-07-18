package com.github.mbonachea.ChatLog;

import org.bukkit.plugin.java.JavaPlugin;

import com.imdeity.deityapi.DeityAPI;

public class ChatLog extends JavaPlugin {

	public ChatListener chat = new ChatListener(this);
	public ChatConfig config = new ChatConfig(this);

	

	public void onEnable() {
		DeityAPI.plugin.chat.out("[ChatLog] is enabled.");
		getServer().getPluginManager().registerEvents(chat, this);

		config.setUpConfig();
	}

	public void onDisable() {
		DeityAPI.plugin.chat.out("[ChatLog] is disabled.");
		config.saveConfig();
	}
	
	private void setupDatabase() {
		DeityAPI.getAPI().getDataAPI().getMySQL().write("CREATE TABLE IF NOT EXISTS `chat_log` ("+"`id` INT(16) NOT NULL AUTO_INCREMENT PRIMARY KEY ,"+"`player_name` VARCHAR(16) NOT NULL"+");");
	}
}
