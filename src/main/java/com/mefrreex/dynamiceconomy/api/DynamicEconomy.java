package com.mefrreex.dynamiceconomy.api;

import com.mefrreex.dynamiceconomy.api.controller.item.ItemController;
import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.impl.DynamicEconomyImpl;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the core interface for managing a dynamic economy.
 * Provides methods to query and manipulate item counts, as well as retrieve dynamic pricing.
 */
public interface DynamicEconomy {

    /**
     * Gets the current price of an item by its ID.
     *
     * @param id The item identifier
     * @return The current price of the item
     */
    double getCurrentPrice(String id);

    /**
     * Increases the count of an item in the economy.
     *
     * @param id The item identifier
     * @param count The amount to increase by
     */
    void increaseItemCount(String id, int count);

    /**
     * Decreases the count of an item in the economy.
     *
     * @param id The item identifier
     * @param count The amount to decrease by
     */
    void decreaseItemCount(String id, int count);

    /**
     * Sets the exact count of an item in the economy.
     *
     * @param id The item identifier
     * @param count The new count value
     */
    void setItemCount(String id, int count);

    /**
     * Creates a new DynamicEconomy instance with specified controllers.
     *
     * @param itemController The item controller implementation
     * @param priceController The price controller implementation
     * @return A new DynamicEconomy instance
     * @throws NullPointerException if any controller is null
     */
    static DynamicEconomy create(@NotNull ItemController itemController, @NotNull PriceController priceController) {
        return new DynamicEconomyImpl(itemController, priceController);
    }

    /**
     * Returns a builder for creating DynamicEconomy instances.
     *
     * @return A new builder instance
     */
    static DynamicEconomyImpl.DynamicEconomyImplBuilder builder() {
        return DynamicEconomyImpl.builder();
    }
}