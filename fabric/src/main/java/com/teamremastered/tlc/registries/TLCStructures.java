package com.teamremastered.tlc.registries;

import com.teamremastered.tlc.Constants;
import com.teamremastered.tlc.structures.LostCastle;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class TLCStructures {

    public static StructureType<LostCastle> LOST_CASTLE;

    public static void init() {
        LOST_CASTLE = Registry.register(BuiltInRegistries.STRUCTURE_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "lost_castle"), () -> LostCastle.CODEC);
    }
}
