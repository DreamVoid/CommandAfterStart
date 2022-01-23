package me.dreamvoid.commandafterstart;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class main extends JavaPlugin implements Listener {
    List<String> commands;
    int delay;

    @Override // 启用插件
    public void onEnable() {
        saveDefaultConfig();
        commands = getConfig().getStringList("commands");
        delay = getConfig().getInt("delay");
        new BukkitRunnable() {
            @Override
            public void run() {
                for(String cmd : commands){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                }
            }
        }.runTaskLater(this, delay * 20L);
    }
}
