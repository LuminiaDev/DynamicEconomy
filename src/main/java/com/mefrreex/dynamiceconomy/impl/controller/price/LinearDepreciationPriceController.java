package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

/**
 * Represents a price controller that implements linear depreciation pricing.
 * Prices decrease linearly as item availability increases, with a minimum price floor.
 */
public class LinearDepreciationPriceController implements PriceController {

    private final double minPriceFactor;

    /**
     * Creates a new LinearDepreciationPriceController instance.
     *
     * @param minPriceFactor The minimum price factor (e.g. 0.2 for 20% of base price)
     */
    public LinearDepreciationPriceController(double minPriceFactor) {
        this.minPriceFactor = minPriceFactor;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        // The price calculation formula:
        // basePrice × max(minPriceFactor, 1 - (currentAmount / initialAmount))
        double ratio = 1.0 - ((double) currentAmount / data.initialAmount());
        double factor = Math.max(minPriceFactor, ratio);
        return data.basePrice() * factor;
    }
}
