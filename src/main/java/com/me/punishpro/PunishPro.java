package com.me.punishpro;

import com.me.punishpro.commands.BanCommand;
import com.me.punishpro.utils.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class PunishPro extends JavaPlugin {


    public static Config mainConfig;
    public static Config messagesConfig;

    public static PunishPro getInstance() {
        return getPlugin(PunishPro.class);
    }

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
                Plugin In Beta Report Bugs!
                """);

        registerCommands();
        mainConfig = new Config("config.yml");
        messagesConfig = new Config("Messages.yml");
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("ban")).setExecutor(new BanCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Punishpro has been disabled!");
    }
}
