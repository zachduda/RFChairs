package com.rifledluffy.chairs.command.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.rifledluffy.chairs.RFChairs;
import com.rifledluffy.chairs.messages.Messages;

public class HelpCommand extends SubCommand {
	
	private RFChairs plugin = RFChairs.getInstance();
	
	@Override
	public void onCommand(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			onCommand((Player) sender, args);
		} else if (sender instanceof ConsoleCommandSender) {
			onCommand((ConsoleCommandSender) sender, args);
		} else return;
	}
	
	private void helpCommands(CommandSender s) {
		Messages.send(s, "&f");
    	Messages.send(s, "&7&l&m--------------&r&8&l( &e&lCHAIRS &8&l)&7&l&m--------------");
    	Messages.send(s, "&f&l/chairs reload  &7Reloads the config and messages");
    	Messages.send(s, "&f&l/chairs reset  &7Resets all chairs");
    	Messages.send(s, "&f&l/chairs toggle  &7Disables seating on chairs for the executor");
    	Messages.send(s, "&f&l/chairs mute  &7Mutes event messages from the plugin for the executor");
    	Messages.send(s, "&f&l/chairs update  &7Runs a check on their current version");
    	Messages.send(s, "&f");
	}
    
    @Override
	public void onCommand(ConsoleCommandSender sender, String[] args) {
    	helpCommands(sender);
	}
	
    @Override
    public void onCommand(Player player, String[] args) {
    	helpCommands(player);
    }

    @Override
    public String name() {
        return plugin.commandManager.help;
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}