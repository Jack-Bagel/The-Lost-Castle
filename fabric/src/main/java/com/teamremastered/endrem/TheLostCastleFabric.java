package com.teamremastered.endrem;

import com.teamremastered.endrem.events.MapTradingEvent;
import com.teamremastered.endrem.registries.TLCProcessors;
import com.teamremastered.endrem.registries.TLCStructures;
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