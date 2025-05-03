package com.teamremastered.endrem.platform;

import com.teamremastered.endrem.Constants;
import com.teamremastered.endrem.platform.services.IConfigHelper;
import com.teamremastered.endrem.platform.services.IPlatformHelper;

import java.util.ServiceLoader;


public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IConfigHelper CONFIG_HELPER = load(IConfigHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}