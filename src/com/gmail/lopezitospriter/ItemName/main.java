package com.gmail.lopezitospriter.ItemName;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.BukkitMetrics;

public class main extends JavaPlugin {
	private Logger log = Logger.getLogger("Minecraft");
    
	@Override
	public void onEnable() {
		log.info("[" + getDescription().getName() + "] now enabling!");
	    getCommand("renamee").setExecutor(new Comando());
	    getCommand("rename").setExecutor(new Comando());
	    try {
	        BukkitMetrics metrics = new BukkitMetrics(this);
	        metrics.start();
	    } catch (IOException e) {
	        // Failed to submit the stats :-(
	    }
	}
	@Override
	public void onDisable() {
		log.info("[" + getDescription().getName() + "] now disabling! :/");
	}
	
}
