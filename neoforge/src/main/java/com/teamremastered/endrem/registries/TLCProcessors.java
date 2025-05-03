package com.teamremastered.endrem.registries;

import com.teamremastered.endrem.Constants;
import com.teamremastered.endrem.processors.FoundationProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TLCProcessors {

    public static final DeferredRegister<StructureProcessorType<?>> DEFERRED_REGISTRY_PROCESSOR = DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, Constants.MOD_ID);

    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<FoundationProcessor>> FOUNDATION = DEFERRED_REGISTRY_PROCESSOR.register("foundation_processor", () -> () -> FoundationProcessor.CODEC);
}