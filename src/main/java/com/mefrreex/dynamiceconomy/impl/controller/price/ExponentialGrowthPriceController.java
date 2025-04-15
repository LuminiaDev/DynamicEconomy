package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

/**
 * Represents a price controller that implements exponential price growth.
 * Prices increase exponentially based on item scarcity using
 * the formula: basePrice × e^(growthRate × missingAmount)
 */
public class ExponentialGrowthPriceController implements PriceController {

    private final double growthRate;

    /**
     * Creates a new ExponentialGrowthPriceController instance.
     *
     * @param growthRate The exponential growth coefficient (e.g. 0.05 for 5% growth rate)
     */
    public ExponentialGrowthPriceController(double growthRate) {
        this.growthRate = growthRate;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        // The price calculation formula:
        // basePrice × e^(growthRate × (initialAmount - currentAmount))
        int missing = data.initialAmount() - currentAmount;
        double multiplier = Math.exp(growthRate * missing);
        return data.basePrice() * multiplier;
    }
}
