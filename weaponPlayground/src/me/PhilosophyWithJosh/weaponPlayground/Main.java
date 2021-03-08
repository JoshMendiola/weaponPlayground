package me.PhilosophyWithJosh.weaponPlayground;
import org.bukkit.plugin.java.JavaPlugin;

import me.PhilosophyWithJosh.weaponPlayground.listeners.joshDamageListener;
import me.PhilosophyWithJosh.weaponPlayground.listeners.shieldListener;
public class Main extends JavaPlugin
{
	//this is the main, where the plugin is pretty much run from, like the command center
	@Override
	public void onEnable()
	{
		new shieldListener(this);
		new joshDamageListener(this);
	}
}
