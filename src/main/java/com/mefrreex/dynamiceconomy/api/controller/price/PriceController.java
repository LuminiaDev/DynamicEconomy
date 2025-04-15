package com.mefrreex.dynamiceconomy.api.controller.price;

import com.mefrreex.dynamiceconomy.api.model.ItemData;

/**
 * Controls price calculation logic for items in the economy system.
 */
public interface PriceController {

    /**
     * Calculates the current price for an item based on market conditions.
     *
     * @param id The unique identifier of the item
     * @param currentAmount The current available quantity of the item
     * @param data The base item data
     * @return The calculated current price
     */
    double calculatePrice(String id, int currentAmount, ItemData data);
}