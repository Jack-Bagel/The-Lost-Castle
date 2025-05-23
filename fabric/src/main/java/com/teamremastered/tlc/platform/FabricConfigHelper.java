package com.teamremastered.tlc.platform;

import com.teamremastered.tlc.platform.services.IConfigHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricConfigHelper implements IConfigHelper {

    @Override
    public String configDirectoryPath() {
        return FabricLoader.getInstance().getConfigDir().toString();
    }

    @Override
    public String configFolderName() {
        return "TheLostCastle-Fabric";
    }
}