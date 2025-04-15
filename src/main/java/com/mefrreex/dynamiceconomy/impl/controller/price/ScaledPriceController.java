package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

/**
 * Represents a price controller that implements dynamic scaling based on item availability.
 * Adjusts prices proportionally to the difference between current and initial stock levels.
 */
public class ScaledPriceController implements PriceController {

    private final double factor;

    /**
     * Creates a new ScaledPriceController instance.
     *
     * @param factor The scaling intensity (0 = no scaling, 1 = full scaling)
     */
    public ScaledPriceController(double factor) {
        this.factor = factor;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        // The price calculation formula:
        // basePrice × (1 + factor × (initialAmount - currentAmount) / initialAmount)
        return data.basePrice() * (1.0 + factor * ((double) (data.initialAmount() - currentAmount) / data.initialAmount()));
    }
}

