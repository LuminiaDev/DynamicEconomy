package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

public class DemandBoostPriceController implements PriceController {

    private final int boostThreshold;
    private final double boostMultiplier;

    /**
     * Creates the DemandBoostPriceController class.
     *
     * @param boostThreshold Quantity threshold below which the surcharge is applied
     * @param boostMultiplier Price multiplier at deficit
     */
    public DemandBoostPriceController(int boostThreshold, double boostMultiplier) {
        this.boostThreshold = boostThreshold;
        this.boostMultiplier = boostMultiplier;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        if (currentAmount <= boostThreshold) {
            return data.basePrice() * boostMultiplier;
        }
        return data.basePrice();
    }
}

