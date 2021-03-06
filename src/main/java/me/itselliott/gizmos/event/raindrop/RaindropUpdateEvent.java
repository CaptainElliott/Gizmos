package me.itselliott.gizmos.event.raindrop;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Created by Elliott on 05/12/2015.
 */
public class RaindropUpdateEvent extends RaindropEvent {

    private static final HandlerList handlers = new HandlerList();

    private int amount;

    public RaindropUpdateEvent(Player player, int amount) {
        super(player);
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
