package com.teamremastered.endrem;


import com.teamremastered.endrem.events.MapTradingEvent;
import com.teamremastered.endrem.registries.TLCProcessors;
import com.teamremastered.endrem.registries.TLCStructures;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

@Mod(Constants.MOD_ID)
public class TheLostCastleNeoForge {

    public TheLostCastleNeoForge(IEventBus eventBus) {
        TLCStructures.DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
        TLCProcessors.DEFERRED_REGISTRY_PROCESSOR.register(eventBus);
        TheLostCastleCommon.init();

        NeoForge.EVENT_BUS.addListener(MapTradingEvent::onVillagerTradesEvent);
    }
}