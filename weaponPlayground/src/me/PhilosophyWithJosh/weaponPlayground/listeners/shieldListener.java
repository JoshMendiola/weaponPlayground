package me.PhilosophyWithJosh.weaponPlayground.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.PhilosophyWithJosh.weaponPlayground.*;
import me.PhilosophyWithJosh.weaponPlayground.utils.utils;

import org.bukkit.entity.Player;


public class shieldListener implements Listener
{
	private static Main plugin;
	
	//this is this classes 'main' if you want to call it that, it functions similarly 
	public shieldListener(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);		
	}
	
	@EventHandler
	//this little paragraph handles the bulk of the code
	public void onPlayerBlock(EntityDamageByEntityEvent b)
	{
		Player p = (Player) b.getEntity();
		if (b.getFinalDamage() == 0.0 & p.isBlocking())
		{
			Bukkit.broadcastMessage(utils.chat("&a" + p.getDisplayName() + "&7 is using a shield"));			
		}
	}
}
