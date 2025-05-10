package com.teamremastered.tlc.processors;

import com.mojang.blaze3d.MethodsReturnNonnullByDefault;
import com.mojang.serialization.MapCodec;
import com.teamremastered.tlc.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.concurrent.ThreadLocalRandom;

@MethodsReturnNonnullByDefault
public class FoundationProcessor extends StructureProcessor {

    public static final FoundationProcessor INSTANCE = new FoundationProcessor();
    public static final MapCodec<FoundationProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state().is(Blocks.YELLOW_CONCRETE)) {
            if (levelReader instanceof WorldGenRegion worldGenRegion && !worldGenRegion.getCenter().equals(new ChunkPos(blockInfoGlobal.pos()))) {
                return blockInfoGlobal;
            }

            BlockState[] foundationBlocks = {
                    Blocks.STONE.defaultBlockState(),
                    Blocks.STONE_BRICKS.defaultBlockState(),
                    Blocks.CRACKED_STONE_BRICKS.defaultBlockState(),
                    Blocks.CRACKED_STONE_BRICKS.defaultBlockState(),
                    Blocks.MOSSY_STONE_BRICKS.defaultBlockState(),
                    Blocks.POLISHED_ANDESITE.defaultBlockState(),
                    Blocks.POLISHED_ANDESITE.defaultBlockState()
            };

            // Replace the yellow concrete itself
            if (blockInfoGlobal.state().is(Blocks.YELLOW_CONCRETE)) {
                blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), RandomBlocks(foundationBlocks), blockInfoGlobal.nbt());
            }

            // Reusable mutable
            BlockPos.MutableBlockPos mutable = blockInfoGlobal.pos().mutable().move(Direction.DOWN); // Move down since we already processed the first block
            BlockState currBlockState = levelReader.getBlockState(mutable);

            while (mutable.getY() > levelReader.getMinY()
                    && mutable.getY() < levelReader.getMaxY()
                    && (currBlockState.isAir() || !levelReader.getFluidState(mutable).isEmpty())) {

                // Place block in vertical pillar
                levelReader.getChunk(mutable).setBlockState(mutable, RandomBlocks(foundationBlocks));

                // Move down
                mutable.move(Direction.DOWN);
                currBlockState = levelReader.getBlockState(mutable);
            }
        }
        return blockInfoGlobal;
    }

    public BlockState RandomBlocks (BlockState[] randomBlocks) {
        int min = 0;
        int max = randomBlocks.length;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max);

        return randomBlocks[randomNum];
    }

    protected StructureProcessorType<?> getType() {
        return Services.PLATFORM.getProcessorType();
    }
}