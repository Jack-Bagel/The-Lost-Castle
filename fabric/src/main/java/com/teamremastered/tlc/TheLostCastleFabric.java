package com.teamremastered.tlc;

import com.teamremastered.tlc.events.MapTradingEvent;
import com.teamremastered.tlc.registries.TLCProcessors;
import com.teamremastered.tlc.registries.TLCStructures;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TheLostCastleFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        TLCStructures.init();
        TLCProcessors.init();
        TheLostCastleCommon.init();

        MapTradingEvent.registerVillagerTrades();
        MinecraftServer
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
        FallingBlockEntity fallingblockentity = new FallingBlockEntity(serverLevel, (double)blockPos.getX() + 0.5D, blockPos.getY(), (double)blockPos.getZ() + 0.5D, serverLevel.getBlockState(blockPos));
    }
}