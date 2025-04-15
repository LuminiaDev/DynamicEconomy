package com.mefrreex.dynamiceconomy.api.model;

/**
 * Represents an item data including its base price and initial amount.
 *
 * @param basePrice The base price of the item
 * @param initialAmount The initial quantity of the item
 */
public record ItemData(double basePrice, int initialAmount) {

    /**
     * An empty item data instance with zero values.
     * Can be used as a default or placeholder value.
     */
    public static final ItemData EMPTY = new ItemData(0, 0);
}
