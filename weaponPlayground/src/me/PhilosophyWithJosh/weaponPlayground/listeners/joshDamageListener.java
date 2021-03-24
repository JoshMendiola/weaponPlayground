package me.PhilosophyWithJosh.weaponPlayground.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import me.PhilosophyWithJosh.weaponPlayground.*;
import me.PhilosophyWithJosh.weaponPlayground.utils.utils;

public class joshDamageListener implements Listener
{
	private static Main plugin;
	
	public joshDamageListener(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	//this sends a message to any players who are taking damage from me, or are damaging me, just Joshua damage in general
	@EventHandler
	public void onJoshDamage(EntityDamageByEntityEvent d)
	{
		//checks if both entity's are players
		if (d.getEntity() instanceof Player && d.getDamager() instanceof Player)
		{
			
			Player p = (Player) d.getEntity();
			Player a = (Player) d.getDamager();
			if(a.getDisplayName().equals("PhilosophyWithJ"))
			{
				//runs it 3 times
				for(int i = 0; i < 3; i++)
				{
					p.sendMessage(utils.chat("&cOBEY"));			
				}
			}
			//sends damage to all players if one player hurts Josh(the king)
			else if(p.getDisplayName().equals("PhilosophyWithJ"))
			{
				for(Player everyP: Bukkit.getServer().getOnlinePlayers())
				{
					//provides blame for all players to see in the case they receive damage from hurting Josh, and then damages all of them
					if(everyP instanceof LivingEntity && !everyP.getDisplayName().equals("PhilosophyWithJ"))
					{
						LivingEntity victim = (LivingEntity)everyP;
						victim.damage(1.0);
					}
				}
				Bukkit.broadcastMessage(utils.chat("&a" + a.getDisplayName() + "&7 is hurting the king!"));
			}
			
		}
	}
}