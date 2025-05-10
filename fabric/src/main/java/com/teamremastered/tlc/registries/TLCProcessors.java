package com.teamremastered.tlc.registries;

import com.teamremastered.tlc.Constants;
import com.teamremastered.tlc.processors.FoundationProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class TLCProcessors {

    public static StructureProcessorType<FoundationProcessor> FOUNDATION_PROCESSOR = () -> FoundationProcessor.CODEC;

    public static void init() {
        Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "foundation_processor"), FOUNDATION_PROCESSOR);
    }
}