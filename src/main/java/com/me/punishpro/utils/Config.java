package com.me.punishpro.utils;

import com.me.punishpro.PunishPro;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {
    private FileConfiguration config;
    private String name;

    public Config(String name) {
        this.config = YamlConfiguration.loadConfiguration(new File(PunishPro.getInstance().getDataFolder(), name));
        this.name = name;
        loadConfig();
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public void loadConfig() {
        File configFile = new File(PunishPro.getInstance().getDataFolder(), name);
        if (!configFile.exists())
            PunishPro.getInstance().saveResource(name, false);
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveConfig() {
        try {
            this.config.save(new File(PunishPro.getInstance().getDataFolder(), name));
        } catch (Exception e) {
            PunishPro.getInstance().getLogger().severe("Could not save config to" + name);
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        this.config = YamlConfiguration.loadConfiguration(new File(PunishPro.getInstance().getDataFolder(), name));
    }

}
