package com.teamremastered.endrem.events;

import com.teamremastered.endrem.utils.TLCMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

public class MapTradingEvent {

    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CARTOGRAPHER) {
            event.getTrades().get(3).add(new TLCMap.LCMapTrade());
        }
    }
}