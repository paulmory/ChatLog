package com.github.mbonachea.ChatLog;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class ChatConfig {
	private final ChatLog plugin;
	
	public ChatConfig(ChatLog plugin) {
		this.plugin = plugin;
	}
	
	public static File configFile;
	public static YamlConfiguration config;
	
	
	public void setUpConfig() {
		configFile = new File(plugin.getDataFolder(), "config.yml");
		config = new YamlConfiguration();

		if(!configFile.exists()){
			try { configFile.createNewFile(); } catch (Exception e) { e.printStackTrace(); }
			config.set("log-to-file", Boolean.valueOf(true));
			config.set("length-of-messages-in-memory", Integer.valueOf(1));
		}
	}
	
	public void saveConfig() {
		try {
			config.save(configFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean shouldLog() {
		if(config.getBoolean("log-to-file")){
			return true;
		}else{
			return false;
		}
	}
	
	public int getMessageTimeLimit() {
		return config.getInt("length-of-messages-in-memory");
	}

}
