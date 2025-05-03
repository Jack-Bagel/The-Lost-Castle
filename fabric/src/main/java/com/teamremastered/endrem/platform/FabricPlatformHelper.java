package com.teamremastered.endrem.platform;

import com.teamremastered.endrem.platform.services.IPlatformHelper;
import com.teamremastered.endrem.registries.TLCProcessors;
import com.teamremastered.endrem.registries.TLCStructures;
import com.teamremastered.endrem.registries.TLCTags;
import com.teamremastered.endrem.structures.LostCastle;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public StructureType<LostCastle> getStructureType() {
        return TLCStructures.LOST_CASTLE;
    }

    @Override
    public StructureProcessorType<?> getProcessorType() {
        return TLCProcessors.FOUNDATION_PROCESSOR;
    }

    @Override
    public TagKey<Structure> getTagKey() {
        return TLCTags.LOST_CASTLE_MAP;
    }

}
