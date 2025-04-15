package com.mefrreex.dynamiceconomy.api;

import com.mefrreex.dynamiceconomy.api.controller.item.ItemController;
import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.impl.DynamicEconomyImpl;
import org.jetbrains.annotations.NotNull;

public interface DynamicEconomy {

    double getCurrentPrice(String id);

    void increaseItemCount(String id, int count);

    void decreaseItemCount(String id, int count);

    void setItemCount(String id, int count);

    static DynamicEconomy create(@NotNull ItemController itemController, @NotNull PriceController priceController) {
        return new DynamicEconomyImpl(itemController, priceController);
    }

    static DynamicEconomyImpl.DynamicEconomyImplBuilder builder() {
        return DynamicEconomyImpl.builder();
    }
}
