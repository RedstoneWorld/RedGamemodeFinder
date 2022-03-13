package me.kekschen.gamemodefinder;

import me.kekschen.gamemodefinder.listeners.GamemodeListener;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Gamemodefinder extends JavaPlugin {

	private static Gamemodefinder INSTANCE;

	public static Gamemodefinder getInstance() {
		return INSTANCE;
	}

	@Override
	public void onLoad() {
		INSTANCE = this;
	}

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new GamemodeListener(), this);
		/*new BukkitRunnable() {
			@Override
			public void run() {
				Bukkit.getOnlinePlayers().forEach(player -> {
					player.setGameMode(player.getGameMode() == GameMode.CREATIVE ? GameMode.SURVIVAL : GameMode.CREATIVE);
				});
			}
		}.runTaskLater(this, 40L);*/
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
