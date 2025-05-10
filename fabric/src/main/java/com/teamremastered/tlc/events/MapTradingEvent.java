package com.teamremastered.tlc.events;

import com.teamremastered.tlc.utils.TLCMap;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;

public class MapTradingEvent {

    public static void registerVillagerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3, factories -> {
            factories.add(new TLCMap.LCMapTrade());
        });
    }
}