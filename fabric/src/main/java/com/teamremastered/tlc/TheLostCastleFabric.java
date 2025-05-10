package com.teamremastered.tlc;

import com.teamremastered.tlc.events.MapTradingEvent;
import com.teamremastered.tlc.registries.TLCProcessors;
import com.teamremastered.tlc.registries.TLCStructures;
import net.fabricmc.api.ModInitializer;

public class TheLostCastleFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        TLCStructures.init();
        TLCProcessors.init();
        TheLostCastleCommon.init();

        MapTradingEvent.registerVillagerTrades();
    }
}