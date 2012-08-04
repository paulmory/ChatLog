package com.github.mbonachea.ChatLog;

import java.sql.SQLDataException;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.records.DatabaseResults;

public class Database {
	
	public static String getChat(String playerName) {
		String sql = "SELECT * FROM `chat_log` WHERE `player_name` = ?;";
		DatabaseResults query = DeityAPI.getAPI().getDataAPI().getMySQL().readEnhanced(sql, playerName);
		if(query != null) {
			try {
				String chat = query.getString(0, "chat");
				return chat;
			} catch(SQLDataException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}
}
