package com.github.mbonachea.chatlog.cmd;

import org.bukkit.entity.Player;

import com.github.mbonachea.chatlog.obj.Database;
import com.imdeity.deityapi.api.DeityCommandReceiver;


public class SearchCmd extends DeityCommandReceiver {
	static int time;
	static String type;
	static String chat;
	static String name;
	static String unit;

	@Override
	public boolean onConsoleRunCommand(String[] args) {
		if(!(args.length == 4)) {
			return false;
		}
		if(!isInt(args[2])){
			return false;
		}

		type = args[0];
		name = args[1];
		time = Integer.parseInt(args[2]);
		unit = args[3];
		
		if(type.equalsIgnoreCase("chat")) {
			if(unit.equalsIgnoreCase("s")){
				Database.getChat(name, "[console]", time * 1000, "s");
			}else if(unit.equalsIgnoreCase("m")){
				Database.getChat(name, "[console]", time * 60 * 1000, "m");
			}else if(unit.equalsIgnoreCase("h")){
				Database.getChat(name, "[console]", time * 60 * 60 * 1000, "h");
			}else{
				return false;
			}
		} else if(type.equalsIgnoreCase("command")) {
			if(unit.equalsIgnoreCase("s")){
				Database.getChat(name, "[console]", time * 1000, "s");
			}else if(unit.equalsIgnoreCase("m")){
				Database.getChat(name, "[console]", time * 60 * 1000, "m");
			}else if(unit.equalsIgnoreCase("h")){
				Database.getChat(name, "[console]", time * 60 * 60 * 1000, "h");
			}else{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		if(!(args.length == 4)) {
			return false;
		}
		if(!isInt(args[2])){
			return false;
		}

		type = args[0];
		name = args[1];
		time = Integer.parseInt(args[2]);
		unit = args[3];
		
		if(type.equalsIgnoreCase("chat")) {
			if(unit.equalsIgnoreCase("s")){
				Database.getChat(name, "[console]", time * 1000, "s");
			}else if(unit.equalsIgnoreCase("m")){
				Database.getChat(name, "[console]", time * 60 * 1000, "m");
			}else if(unit.equalsIgnoreCase("h")){
				Database.getChat(name, "[console]", time * 60 * 60 * 1000, "h");
			}else{
				return false;
			}
		} else if(type.equalsIgnoreCase("command")) {
			if(unit.equalsIgnoreCase("s")){
				Database.getChat(name, "[console]", time * 1000, "s");
			}else if(unit.equalsIgnoreCase("m")){
				Database.getChat(name, "[console]", time * 60 * 1000, "m");
			}else if(unit.equalsIgnoreCase("h")){
				Database.getChat(name, "[console]", time * 60 * 60 * 1000, "h");
			}else{
				return false;
			}
		}
		
		return true;
}

private boolean isInt(String i) {

	try {
		Integer.parseInt(i);
		return true;
	} catch (Exception e) {
		return false;
	}
}
}

/*
 * chatlog cliff777 10 s
 * chatlog mbonachea 5 m
 */
