package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

/**
 * Represents a price controller that applies demand-based price boosts.
 * Implements threshold-based price increases when item availability drops below specified levels.
 */
public class DemandBoostPriceController implements PriceController {

    private final int boostThreshold;
    private final double boostMultiplier;

    /**
     * Creates a new DemandBoostPriceController instance.
     *
     * @param boostThreshold The quantity threshold triggering price boost
     * @param boostMultiplier The multiplier applied to base price when threshold is crossed
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

