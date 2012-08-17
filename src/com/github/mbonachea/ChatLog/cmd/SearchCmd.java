package com.github.mbonachea.chatlog.cmd;

import org.bukkit.entity.Player;

import com.github.mbonachea.chatlog.obj.Database;
import com.imdeity.deityapi.api.DeityCommandReceiver;


public class SearchCmd extends DeityCommandReceiver {
	static int time;
	static String chat;
	static String name;
	static String unit;

	@Override
	public boolean onConsoleRunCommand(String[] args) {
		if(!(args.length == 3)) {
			return false;
		}
		if(!isInt(args[1])){
			return false;
		}

		name = args[0];
		time = Integer.parseInt(args[1]);
		unit = args[2];
		
		
		if(unit.equalsIgnoreCase("s")){
			Database.getChat(name, "[console]", time * 1000, "s");
		}else if(unit.equalsIgnoreCase("m")){
			Database.getChat(name, "[console]", time * 60 * 1000, "m");
		}else if(unit.equalsIgnoreCase("h")){
			Database.getChat(name, "[console]", time * 60 * 60 * 1000, "h");
		}else{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		if(!(args.length == 3)) {
			return false;
		}
		if(!isInt(args[1])){
			return false;
		}

		name = args[0];
		time = Integer.parseInt(args[1]);
		unit = args[2];
		
		
		if(unit.equalsIgnoreCase("s")){
			Database.getChat(name, player.getName(), time, "s");
		}else if(unit.equalsIgnoreCase("m")){
			Database.getChat(name, player.getName(), time * 60, "m");
		}else if(unit.equalsIgnoreCase("h")){
			Database.getChat(name, player.getName(), time * 60 * 60, "h");
		}else{
			return false;
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
