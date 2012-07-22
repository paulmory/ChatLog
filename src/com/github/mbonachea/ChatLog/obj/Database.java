package com.github.mbonachea.ChatLog.obj;

import java.sql.SQLDataException;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.records.DatabaseResults;

public class Database {
	private String playerName;
	
	public void getChat() {
		String sql = "SELECT * FROM `chat_log` WHERE `player_name` = ?;";
		DatabaseResults query = DeityAPI.getAPI().getDataAPI().getMySQL().readEnhanced(sql, playerName);
		if(query != null) {
			try {
				query.getString(0, "chat");
			} catch(SQLDataException exception) {
				exception.printStackTrace();
			}
		}
	}
}
