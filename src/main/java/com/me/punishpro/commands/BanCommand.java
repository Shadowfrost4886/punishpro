package com.me.punishpro.commands;

import com.me.punishpro.PunishPro;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BanCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can ban!");
            return true;
        }

        // Checks

        if (args.length == 0) {
            sender.sendMessage("Usage: /ban <player> [reason] [length]");
            return true;
        }
        Player target = sender.getServer().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer not found!"));
            return true;
        }

        // Checks

        if (args.length == 1) {
            List<String> banMessage = new ArrayList<>(PunishPro.messagesConfig.getConfig().getStringList("Ban"));
            banMessage.replaceAll(s -> s
                    .replace("{0}", "No reason specified")
                    .replace("{1}", sender.getName().toUpperCase())
                    .replace("{2}", "Indefinitely"));
            banMessage.replaceAll(s -> ChatColor.translateAlternateColorCodes('&', s));
            String formattedMessage = String.join("\n", banMessage);
            target.ban(formattedMessage, (Date) null, sender.getName());
        }


        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {


        return List.of();
    }
}
