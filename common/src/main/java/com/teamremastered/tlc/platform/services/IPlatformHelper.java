package com.teamremastered.tlc.platform.services;

import com.teamremastered.tlc.structures.LostCastle;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public interface IPlatformHelper {

    StructureType<LostCastle> getStructureType();
    StructureProcessorType<?> getProcessorType();
    TagKey<Structure> getTagKey();
}