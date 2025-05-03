package com.teamremastered.endrem.registries;

import com.teamremastered.endrem.Constants;
import com.teamremastered.endrem.structures.LostCastle;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TLCStructures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registries.STRUCTURE_TYPE, Constants.MOD_ID);

    public static final DeferredHolder<StructureType<?>, StructureType<LostCastle>> LOST_CASTLE = DEFERRED_REGISTRY_STRUCTURE.register("lost_castle", () -> () -> LostCastle.CODEC);
}
