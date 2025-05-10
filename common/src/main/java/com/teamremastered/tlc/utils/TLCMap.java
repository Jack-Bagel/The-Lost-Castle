package com.teamremastered.tlc.utils;

import com.teamremastered.tlc.Constants;
import com.teamremastered.tlc.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapDecorationTypes;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class TLCMap {

    public static boolean nullCheck = false;

    public static ItemStack createMap(ServerLevel serverLevel, BlockPos playerPosition) {
        // Get position of marker
        BlockPos structurePos = serverLevel.findNearestMapStructure(Services.PLATFORM.getTagKey(), playerPosition, 100, false);
        ItemStack stack;

        // Create map
        if (structurePos == null) {
            stack = MapItem.create(serverLevel, 0, 0, (byte) 2 , true, true);
            MapItemSavedData.addTargetDecoration(stack, BlockPos.ZERO, "+", MapDecorationTypes.TARGET_X);
            Constants.LOG.error("Something went wrong with The Lost Castle");
            nullCheck = true;
        }
        else {
            stack = MapItem.create(serverLevel, structurePos.getX(), structurePos.getZ(), (byte) 2 , true, true);
            MapItemSavedData.addTargetDecoration(stack, structurePos, "+", MapDecorationTypes.TARGET_X);
        }
        MapItem.renderBiomePreviewMap(serverLevel, stack);

        // Set the name of the map
        stack.set(DataComponents.CUSTOM_NAME, Component.nullToEmpty("Lost Castle Map"));

        return stack;
    }
    //Create The Trade
    public static class LCMapTrade implements VillagerTrades.ItemListing {

        @Override
        public MerchantOffer getOffer(Entity entity, @NotNull RandomSource random){
            int xp = 10;
            int min = 15;
            int max = 25;
            int priceEmeralds = ThreadLocalRandom.current().nextInt(min, max + 1);
            ItemCost cost = new ItemCost(Items.EMERALD, priceEmeralds);
            Optional<ItemCost> optionalCost = Optional.of(new ItemCost(Items.COMPASS));
            if (!entity.level().isClientSide() && entity.level().dimension() == Level.OVERWORLD) {
                ItemStack map = createMap((ServerLevel) entity.level(), entity.blockPosition());
                return new MerchantOffer(cost, optionalCost, map, 2, xp, 0.2F);
            }
            return null;
        }
    }
}
