package com.github.mbonachea.chatlog.obj;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.records.DatabaseResults;

public class Database {

	static Date past;
	static ChatColor g = ChatColor.GRAY;
	static ChatColor dg = ChatColor.DARK_GRAY;
	static ChatColor y = ChatColor.YELLOW;
	static ChatColor gr = ChatColor.GREEN;
	static DatabaseResults query;

	public static void getChat(String target, String sender, int time, String unit) {
		String sql = "SELECT * FROM `chat_log` WHERE `player_name` = ?;";
		try{ query = DeityAPI.getAPI().getDataAPI().getMySQL().readEnhanced(sql, target); }catch (Exception e){ Bukkit.getPlayer(sender).sendMessage(y + "That player has no chat records."); return; }
		if(query == null) return;
		if(query.hasRows()) {
			for(int i = 0; i < query.rowCount(); i++) {
				try { past = query.getDate(i, "time"); }catch (Exception e){ e.printStackTrace(); }
				Date now = new Date();
				if(!(now.getTime() - past.getTime() > time)){
					long timePassed = now.getTime() - past.getTime();
					if(unit.equalsIgnoreCase("s")){
						try {
							if(sender.equalsIgnoreCase("[console]")){
								DeityAPI.getAPI().getChatAPI().out("ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "chat"));
							}else{
								DeityAPI.getAPI().getChatAPI().sendPlayerMessage(Bukkit.getPlayer(sender), "ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "chat"));
							}
						} catch (SQLDataException e) {
							e.printStackTrace();
						}
					}else if(unit.equalsIgnoreCase("m")){
						timePassed = timePassed / 60;
						try {
							if(sender.equalsIgnoreCase("[console]")){
								DeityAPI.getAPI().getChatAPI().out("ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "chat"));
							}else{
								DeityAPI.getAPI().getChatAPI().sendPlayerMessage(Bukkit.getPlayer(sender), "ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "chat"));
							}
						} catch (SQLDataException e) {
							e.printStackTrace();
						}
					}else if(unit.equalsIgnoreCase("h")){
						timePassed = timePassed / 60 / 60;
						try {
							if(sender.equalsIgnoreCase("[console]")){
								DeityAPI.getAPI().getChatAPI().out("ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "chat"));
							}else{
								DeityAPI.getAPI().getChatAPI().sendPlayerMessage(Bukkit.getPlayer(sender), "ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "chat"));
							}
						} catch (SQLDataException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			if(sender.equalsIgnoreCase("[console]")) {
				DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "No chat!");
			} else {
				DeityAPI.getAPI().getChatAPI().sendPlayerError(Bukkit.getPlayer(sender), "ChatLog", "No chat!");
			}
		}
	}
	
	public static void getCommand(String target, String sender, int time, String unit) {
		String sql = "SELECT * FROM `command_log` WHERE `player_name` = ?;";
		try{ query = DeityAPI.getAPI().getDataAPI().getMySQL().readEnhanced(sql, target); }catch (Exception e){ Bukkit.getPlayer(sender).sendMessage(y + "That player has no command records."); return; }
		if(query == null) return;
		if(query.hasRows()) {
			for(int i = 0; i < query.rowCount(); i++) {
				try { past = query.getDate(i, "time"); }catch (Exception e){ e.printStackTrace(); }
				Date now = new Date();
				if(!(now.getTime() - past.getTime() > time)){
					long timePassed = now.getTime() - past.getTime();
					if(unit.equalsIgnoreCase("s")){
						try {
							if(sender.equalsIgnoreCase("[console]")){
								DeityAPI.getAPI().getChatAPI().out("ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "command"));
							}else{
								DeityAPI.getAPI().getChatAPI().sendPlayerMessage(Bukkit.getPlayer(sender), "ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "chat"));
							}
						} catch (SQLDataException e) {
							e.printStackTrace();
						}
					}else if(unit.equalsIgnoreCase("m")){
						timePassed = timePassed / 60;
						try {
							if(sender.equalsIgnoreCase("[console]")){
								DeityAPI.getAPI().getChatAPI().out("ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "command"));
							}else{
								DeityAPI.getAPI().getChatAPI().sendPlayerMessage(Bukkit.getPlayer(sender), "ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "command"));
							}
						} catch (SQLDataException e) {
							e.printStackTrace();
						}
					}else if(unit.equalsIgnoreCase("h")){
						timePassed = timePassed / 60 / 60;
						try {
							if(sender.equalsIgnoreCase("[console]")){
								DeityAPI.getAPI().getChatAPI().out("ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "command"));
							}else{
								DeityAPI.getAPI().getChatAPI().sendPlayerMessage(Bukkit.getPlayer(sender), "ChatLog", g + "[" + dg + timePassed + unit + g + "] " + y + target + ": " + gr + query.getString(i, "command"));
							}
						} catch (SQLDataException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			if(sender.equalsIgnoreCase("[console]")) {
				DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "No commands!");
			} else {
				DeityAPI.getAPI().getChatAPI().sendPlayerError(Bukkit.getPlayer(sender), "ChatLog", "No commands!");
			}
		}
	}
	
	public static void purgeDatabase(Player sender) {
		try {
			String sql3 = "SELECT * FROM `chat_log`";
			DatabaseResults query = DeityAPI.getAPI().getDataAPI().getMySQL().readEnhanced(sql3, new Object[0]);
			if(query.hasRows() && query != null) {
				int time = query.getInteger(0, "time");
				long now = System.currentTimeMillis();
				if((DeityAPI.plugin.config.getInt("purge-since-days") * 24 * 60 * 60 * 1000) - now > time) {
					String sql = "TRUNCATE TABLE `chat_log`";
					String sql2 = "TRUNCATE TABLE `command_log`";
					DeityAPI.getAPI().getDataAPI().getMySQL().write(sql, new Object[0]);//Credit to vanZeben for params
					DeityAPI.getAPI().getDataAPI().getMySQL().write(sql2, new Object[0]);//Credit again
					DeityAPI.plugin.config.set("last-purge", System.currentTimeMillis());
					DeityAPI.getAPI().getChatAPI().sendPlayerError(sender, "ChatLog", "Database sucessfully purged!");
					if(sender == null) {
						DeityAPI.getAPI().getChatAPI().outSevere("ChatLog", "Database sucessfully purged!");
					}
				}
			} else {
				DeityAPI.getAPI().getChatAPI().sendPlayerError(sender, "ChatLog", "Database purge unsuccessful!");
				if(sender == null) {
					DeityAPI.getAPI().getChatAPI().outWarn("ChatLog", "Database purge unsuccessful!");
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
