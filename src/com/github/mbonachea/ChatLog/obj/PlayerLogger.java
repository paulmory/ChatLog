package com.github.mbonachea.chatlog.obj;

import org.bukkit.entity.Player;

public abstract class PlayerLogger {
	
	protected Player p;
	
	protected int time;
	
	protected long millis;
	
	public PlayerLogger(Player p, int time){
		this.p = p;
		this.time = time;
		millis = time * 60 * 60;
	}
	
	
	
	

}
