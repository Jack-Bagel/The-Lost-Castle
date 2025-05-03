package com.teamremastered.endrem;

import com.teamremastered.endrem.config.ConfigOptions;

import java.io.IOException;

public class TheLostCastleCommon {

    public static void init() {
        try {
            ConfigOptions.create();
            Constants.LOG.info("Lost Castle config loaded successfully");
        } catch (IOException e) {
            Constants.LOG.error("Something went wrong with the config");
        }
    }
}