package com.teamremastered.tlc.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamremastered.tlc.Constants;
import com.teamremastered.tlc.platform.Services;

import java.io.*;

public class ConfigOptions {
    static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final static String configPath = Services.CONFIG_HELPER.configDirectoryPath() + "/" + Services.CONFIG_HELPER.configFolderName() + "/";
    private final static String configName = Constants.MOD_ID + ".json";
    private static ConfigOptions TLC_CONFIG;
    public boolean DISABLE_VANILLA_STRONGHOLD;

    private ConfigOptions() {
        this.DISABLE_VANILLA_STRONGHOLD = false;
    }

    public static void create() throws IOException {
        File configFolder = new File(configPath);

        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }

        File configFile = new File(configPath + configName);
        if (!configFile.exists()) {
            try (FileWriter fw = new FileWriter(configFile.getPath())) {
                gson.toJson(new ConfigOptions(), fw);
            }
        }

        TLC_CONFIG = load();
    }

    public static ConfigOptions load() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(configPath + configName));
        return gson.fromJson(bufferedReader, ConfigOptions.class);
    }

    public static ConfigOptions getERConfig() {
        return TLC_CONFIG;
    }
}