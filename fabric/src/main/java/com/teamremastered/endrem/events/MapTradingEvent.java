package com.teamremastered.endrem.events;

import com.teamremastered.endrem.utils.TLCMap;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.mixin.resource.loader.KeyedResourceReloadListenerMixin;
import net.minecraft.world.entity.npc.VillagerProfession;

public class MapTradingEvent {

    public static void registerVillagerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3, factories -> {
            factories.add(new TLCMap.LCMapTrade());
        });
    }
}