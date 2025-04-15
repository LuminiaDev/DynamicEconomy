package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

public class ExponentialGrowthPriceController implements PriceController {

    private final double growthRate;

    /**
     * Creates the ExponentialGrowthPriceController class.
     *
     * @param growthRate Growth rate (e.g. 0.05)
     */
    public ExponentialGrowthPriceController(double growthRate) {
        this.growthRate = growthRate;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        int missing = data.initialAmount() - currentAmount;
        double multiplier = Math.exp(growthRate * missing);
        return data.basePrice() * multiplier;
    }
}
