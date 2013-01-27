package com.gmail.lopezitospriter.ItemName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.BukkitMetrics;

public class main extends JavaPlugin {
	private Logger log = Logger.getLogger("Minecraft");

    public void load() {
    	if (!getDataFolder().exists())
			getDataFolder().mkdir();
    	try{
			getConfig().load(new File(getDataFolder(), "config.yml"));
    	}catch(FileNotFoundException e){
			log.info("[" + getDescription().getName() + "] Creating configuration file.");
			try{
				new File(getDataFolder(), "config.yml").createNewFile();
				getConfig().set("msg1", "You renamed:");
				getConfig().set("msg2", "to");
				getConfig().set("msg3", "Watch your inventory!");
				try{
					getConfig().save(new File(getDataFolder(), "config.yml"));
					load();
				}catch (IOException e2){
					e2.printStackTrace();
				}
			}catch(Exception e1){
				e1.printStackTrace();
			}
    	}catch (IOException e){
			log.warning("[" + getDescription().getName() + "] Cannot load configuration: " + e);
		}catch (InvalidConfigurationException e){
			log.warning("[" + getDescription().getName() + "] Cannot read configuration: " + e);
		}
    }
    
	@Override
	public void onEnable() {
		log.info("[" + getDescription().getName() + "] now enabling!");
	    getCommand("renamee").setExecutor(new Comando(this));
	    getCommand("rename").setExecutor(new Comando(this));
	    getCommand("renamehand").setExecutor(new Comando(this));
	    getCommand("renameehand").setExecutor(new Comando(this));
	    getCommand("itemrename").setExecutor(new Comando(this));
		load();
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
