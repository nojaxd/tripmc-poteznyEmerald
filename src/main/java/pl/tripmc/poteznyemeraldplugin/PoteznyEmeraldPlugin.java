package pl.tripmc.poteznyemeraldplugin;

import org.bukkit.plugin.java.JavaPlugin;
import pl.tripmc.poteznyemeraldplugin.listeners.PlayerInteractListener;

public final class PoteznyEmeraldPlugin extends JavaPlugin {
    public static PoteznyEmeraldPlugin poteznyEmeraldPlugin;
    @Override
    public void onEnable() {
        poteznyEmeraldPlugin = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static PoteznyEmeraldPlugin getPoteznyEmeraldPlugin() {
        return poteznyEmeraldPlugin;
    }
}
