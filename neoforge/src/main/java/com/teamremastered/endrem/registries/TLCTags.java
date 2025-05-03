package com.teamremastered.endrem.registries;

import com.teamremastered.endrem.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class TLCTags {

    public static TagKey<Structure> LOST_CASTLE_MAP = TagKey.create(Registries.STRUCTURE,
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "lost_castle_map"));
}