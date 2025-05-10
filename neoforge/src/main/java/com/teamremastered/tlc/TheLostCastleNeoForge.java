package com.teamremastered.tlc;

import com.teamremastered.tlc.events.MapTradingEvent;
import com.teamremastered.tlc.registries.TLCProcessors;
import com.teamremastered.tlc.registries.TLCStructures;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = Constants.MOD_ID)
public class TheLostCastleNeoForge {

    public TheLostCastleNeoForge(IEventBus eventBus) {

        TLCStructures.DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
        TLCProcessors.DEFERRED_REGISTRY_PROCESSOR.register(eventBus);
        TheLostCastleCommon.init();

        NeoForge.EVENT_BUS.addListener(MapTradingEvent::onVillagerTradesEvent);
    }
}