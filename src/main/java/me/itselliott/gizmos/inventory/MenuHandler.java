package me.itselliott.gizmos.inventory;

import me.itselliott.gizmos.Gizmos;
import me.itselliott.gizmos.inventory.interactables.useables.Usable;
import me.itselliott.gizmos.inventory.menus.GizmoMenu;
import me.itselliott.gizmos.utils.ItemBuilder;
import me.itselliott.gizmos.utils.constants.StringConstants;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;


/**
 * Created by Elliott2 on 31/12/2015.
 */
public class MenuHandler implements Listener {

    public MenuHandler() {
        Gizmos.get().registerListener(this);
    }

    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
        // Gives player item to access the gizmo menu with
        player.getInventory().setItem(0, new Usable(new ItemBuilder(Material.GHAST_TEAR).setName(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + StringConstants.GIZMOS).createItem()) {
            @Override
            @EventHandler
            public void action(PlayerInteractEvent event) {
                if (event.getItem() != null && event.getItem().equals(this.getItemStack())) {
                    new GizmoMenu().open(event.getActor());
                    event.setCancelled(true);
                }
            }
        }.getItemStack());
        // Gives player gizmo place holder
        player.getInventory().setItem(4, new ItemBuilder(Material.THIN_GLASS).setName(ChatColor.BOLD + "" + ChatColor.AQUA + "Equipped Gizmo: None").createItem());
    }


}
