package com.gmail.lopezitospriter.ItemName;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Comando implements CommandExecutor {
	main plugin;
	 
	public Comando(main instance) {
	plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		//Rename an item without enchantment
		if(commandLabel.equalsIgnoreCase("rename")) {
			//Rename
		    if (args.length > 3) {
			      Player p = (Player)sender;
						  String arg1 = args[0];
						  String arg4 = args[2].toUpperCase();
					      PlayerInventory inventory = p.getInventory();
					      ItemStack itemstack = new ItemStack(Material.matchMaterial(arg1), Integer.parseInt(args[1])); 
					      ItemMeta test = (ItemMeta) itemstack.getItemMeta();
					      StringBuilder string = new StringBuilder();
					      for (int s = 3; s < args.length; s++) {
					      if (s > 3) string.append(" ");
					      string.append(args[s]);
					      }
					      String newnameitem = string.toString();
					      test.setDisplayName(ChatColor.valueOf(arg4) + newnameitem);
					      itemstack.setItemMeta(test);
					      inventory.addItem(itemstack);
					      String itemrenamed = Material.matchMaterial(arg1).name();
				    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg1") + " " + itemrenamed.toLowerCase() + ChatColor.WHITE + " " + plugin.getConfig().getString("msg2") + " " + ChatColor.valueOf(arg1) + newnameitem);
				    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg3"));
				return true;
		    } else {
			    Player p = (Player)sender;
		    	p.sendMessage(plugin.getCommand("rename").getUsage());
		    }
		  }
		//Rename an item with enchantment
		else if(commandLabel.equalsIgnoreCase("renamee")) {
		    if (args.length > 3) {
				      Player p = (Player)sender;
						  String arg1 = args[0];
						  String arg4 = args[2].toUpperCase();
						  String arg5 = args[3].toUpperCase();
					      PlayerInventory inventory = p.getInventory();
					      ItemStack itemstack = new ItemStack(Material.matchMaterial(arg1), Integer.parseInt(args[1])); 
					      ItemMeta test = (ItemMeta) itemstack.getItemMeta();
					      StringBuilder string = new StringBuilder();
					      for (int s = 4; s < args.length; s++) {
					      if (s > 4) string.append(" ");
					      string.append(args[s]);
					      }
					      String newnameitem = string.toString();
					      test.setDisplayName(ChatColor.valueOf(arg4) + newnameitem);
					      itemstack.setItemMeta(test);
					      itemstack.addEnchantment(Enchantment.getByName(arg5), 1);
					      inventory.addItem(itemstack);
					      String itemrenamed = Material.matchMaterial(arg1).name();
				    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg1") + " " + itemrenamed.toLowerCase() + ChatColor.WHITE + " " + plugin.getConfig().getString("msg2") + " " + ChatColor.valueOf(arg1) + newnameitem);
				    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg3"));
				return true;
		    } else {
			    Player p = (Player)sender;
		    	p.sendMessage(plugin.getCommand("renamee").getUsage());
		    }
		  }
		//Rename the item on your hand without enchantment
		else if(commandLabel.equalsIgnoreCase("renamehand")) {
			if (args.length > 0) {
				Player p = (Player)sender;
				String arg1 = args[0].toUpperCase();
	            ItemStack itemstack = p.getInventory().getItemInHand();
			      String itemrenamed = itemstack.getItemMeta().getDisplayName();
			      ItemMeta test = (ItemMeta) itemstack.getItemMeta();
			      StringBuilder string = new StringBuilder();
			      for (int s = 1; s < args.length; s++) {
			      if (s > 1) string.append(" ");
			      string.append(args[s]);
			      }
			      String newnameitem = string.toString();
			      test.setDisplayName(ChatColor.valueOf(arg1) + newnameitem);
			      itemstack.setItemMeta(test);
			      p.getInventory().setItemInHand(itemstack);
		    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg1") + " " + itemrenamed.toLowerCase() + ChatColor.WHITE +  " " + plugin.getConfig().getString("msg2") + " " + ChatColor.valueOf(arg1) + newnameitem);
		    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg3"));
				return true;
			} else {
			    Player p = (Player)sender;
		    	p.sendMessage(plugin.getCommand("renamehand").getUsage());
		    }
		  }
		//Rename the item on your hand with enchantment
		else if(commandLabel.equalsIgnoreCase("renameehand")) {
		    if (args.length > 1) {
				Player p = (Player)sender;
				String arg1 = args[0].toUpperCase();
				String arg2 = args[1].toUpperCase();
	            ItemStack itemstack = p.getInventory().getItemInHand();
			      String itemrenamed = itemstack.getItemMeta().getDisplayName();
			      ItemMeta test = (ItemMeta) itemstack.getItemMeta();
			      StringBuilder string = new StringBuilder();
			      for (int s = 2; s < args.length; s++) {
			      if (s > 2) string.append(" ");
			      string.append(args[s]);
			      }
			      String newnameitem = string.toString();
			      test.setDisplayName(ChatColor.valueOf(arg1) + newnameitem);
			      itemstack.setItemMeta(test);
			      itemstack.addEnchantment(Enchantment.getByName(arg2), 1);
			      p.getInventory().setItemInHand(itemstack);
		    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg1") + " " + itemrenamed.toLowerCase() + ChatColor.WHITE +  " " + plugin.getConfig().getString("msg2") + " " + ChatColor.valueOf(arg1) + newnameitem);
		    	  p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("msg3"));
				return true;
		    } else {
			    Player p = (Player)sender;
		    	p.sendMessage(plugin.getCommand("renameehand").getUsage());
		    }
		  }
		else if(commandLabel.equalsIgnoreCase("itemrename")) {
				Player p = (Player)sender;
				p.sendMessage(ChatColor.RED + "- ItemRename/Help -");
				p.sendMessage(ChatColor.GOLD + "/rename" + ChatColor.WHITE + ": This command is used to change the name of the item without adding enchants");
				p.sendMessage(ChatColor.GOLD + "/renamee" + ChatColor.WHITE + ": This command is used to change the name of the item with adding enchants");
				p.sendMessage(ChatColor.GOLD + "/renamehand" + ChatColor.WHITE + ": This command is to change the name of the item you have on hand without adding enchants");
				p.sendMessage(ChatColor.GOLD + "/renameehand" + ChatColor.WHITE + ": This command is to change the name of the item you have on hand with adding enchants");
				p.sendMessage(ChatColor.RED + "- Created by Lopezito -");
		}
		return true;
	}

}
