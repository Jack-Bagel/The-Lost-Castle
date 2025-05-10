package com.teamremastered.tlc;

import com.teamremastered.tlc.config.ConfigOptions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.io.IOException;

public class TheLostCastleCommon {

    public static void init() {
        try {
            ConfigOptions.create();
            Constants.LOG.info("Lost Castle config loaded successfully");
        } catch (IOException e) {
            Constants.LOG.error("Something went wrong with the config");
        }

        MinecraftServer
    }
}