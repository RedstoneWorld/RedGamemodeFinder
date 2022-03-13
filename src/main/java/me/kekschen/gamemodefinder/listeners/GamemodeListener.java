package me.kekschen.gamemodefinder.listeners;

import me.kekschen.gamemodefinder.Gamemodefinder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class GamemodeListener implements Listener {

	Logger l;

	public GamemodeListener() {
		l = Gamemodefinder.getInstance().getLogger();
	}

	@EventHandler
	public void onGamemodeChange(PlayerGameModeChangeEvent e) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		ArrayList<StackTraceElement> stackElements = new ArrayList<>();
		for(int i = 2; i < stackTrace.length; i++) {
			if(stackTrace[i].toString().matches(".+//.+")) {
				stackElements.add(stackTrace[i]);
			}
		}
		l.info("§6§l--------------------------------------------------------------------------------");
		l.info("§6§lGamemode von User " + e.getPlayer().getName() + " zu " + e.getNewGameMode().name() + " geändert!");
		if(stackElements.size() == 0) {
			l.info("§6§lGeändert durch: Minecraft Built-In");
		} else {
			l.info("§6§lCallstack Trace:");
			for(int i = 0; i < stackElements.size(); i++) {
				String[] strSplit = stackElements.get(i).toString().split("//");
				l.info("§6§lPosition " + i + ". im Callstack: ");
				l.info("§6§l - Pluginname: " + strSplit[0]);
				l.info("§6§l - In Methode: " + strSplit[1]);
			}
		}
		l.info("§6§l--------------------------------------------------------------------------------");
	}
}
