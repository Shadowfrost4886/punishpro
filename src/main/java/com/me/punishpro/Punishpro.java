package com.me.punishpro;

import org.bukkit.plugin.java.JavaPlugin;
import com.me.punishpro.commands.BanCommand;
import com.me.punishpro.commands.KickCommand;
import com.me.punishpro.commands.MuteCommand;

public class Punishpro extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("""
                ██████╗░██╗░░░██╗███╗░░██╗██╗░██████╗██╗░░██╗██████╗░██████╗░░█████╗░
                ██╔══██╗██║░░░██║████╗░██║██║██╔════╝██║░░██║██╔══██╗██╔══██╗██╔══██╗
                ██████╔╝██║░░░██║██╔██╗██║██║╚█████╗░███████║██████╔╝██████╔╝██║░░██║
                ██╔═══╝░██║░░░██║██║╚████║██║░╚═══██╗██╔══██║██╔═══╝░██╔══██╗██║░░██║
                ██║░░░░░╚██████╔╝██║░╚███║██║██████╔╝██║░░██║██║░░░░░██║░░██║╚█████╔╝
                ╚═╝░░░░░░╚═════╝░╚═╝░░╚══╝╚═╝╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝░░╚═╝░╚════╝░
                Punishpro has been enabled!
                """);

        registerCommands();
    }

    private void registerCommands() {
        // Register command executors with null checks
        if (getCommand("mute") != null) {
            getCommand("mute").setExecutor(new MuteCommand());
        } else {
            getLogger().warning("Mute command is not defined in plugin.yml");
        }

        if (getCommand("ban") != null) {
            getCommand("ban").setExecutor(new BanCommand());
        } else {
            getLogger().warning("Ban command is not defined in plugin.yml");
        }

        if (getCommand("kick") != null) {
            getCommand("kick").setExecutor(new KickCommand());
        } else {
            getLogger().warning("Kick command is not defined in plugin.yml");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Punishpro has been disabled!");
    }
}
