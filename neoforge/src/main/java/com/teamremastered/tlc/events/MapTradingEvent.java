package com.teamremastered.tlc.events;

import com.teamremastered.tlc.utils.TLCMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

public class MapTradingEvent {

    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CARTOGRAPHER) {
            event.getTrades().get(3).add(new TLCMap.LCMapTrade());
        }
    }
}