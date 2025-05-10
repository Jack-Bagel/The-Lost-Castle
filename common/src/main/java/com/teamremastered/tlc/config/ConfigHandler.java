package com.teamremastered.tlc.config;

public class ConfigHandler {
    private static final ConfigOptions CONFIG = ConfigOptions.getERConfig();

    public static final boolean DISABLE_VANILLA_STRONGHOLD = CONFIG.DISABLE_VANILLA_STRONGHOLD;
}