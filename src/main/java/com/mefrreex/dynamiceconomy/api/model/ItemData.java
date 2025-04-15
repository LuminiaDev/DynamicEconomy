package com.mefrreex.dynamiceconomy.api.model;

public record ItemData(double basePrice, int initialAmount) {
    public static final ItemData EMPTY = new ItemData(0, 0);
}
