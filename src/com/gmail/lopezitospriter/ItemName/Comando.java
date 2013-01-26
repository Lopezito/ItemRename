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
    
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("renamee")) {
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
				    	  p.sendMessage(ChatColor.GREEN + "You rename: " + arg1 + " to " + ChatColor.valueOf(arg4) + newnameitem);
				    	  p.sendMessage(ChatColor.GREEN + "You see inventory!");
				return true;
		    }
		  }
		if(commandLabel.equalsIgnoreCase("rename")) {
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
				    	  p.sendMessage(ChatColor.GREEN + "You rename: " + arg1 + " to " + ChatColor.valueOf(arg4) + newnameitem);
				    	  p.sendMessage(ChatColor.GREEN + "You see inventory!");
				return true;
		    }
		  }
		return true;
	}

}
