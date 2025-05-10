package com.teamremastered.tlc.platform;

import com.teamremastered.tlc.platform.services.IConfigHelper;
import net.neoforged.fml.loading.FMLPaths;

public class NeoForgeConfigHelper implements IConfigHelper {

    @Override
    public String configDirectoryPath() {
        return FMLPaths.CONFIGDIR.get().toString();
    }

    @Override
    public String configFolderName() {
        return "TheLostCastle-NeoForge";
    }

}