package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

public class LinearDepreciationPriceController implements PriceController {

    private final double minPriceFactor;

    /**
     * Creates the LinearDepreciationPriceController class.
     *
     * @param minPriceFactor Minimum price factor (e.g. 0.2 = minimum 20% of base price)
     */
    public LinearDepreciationPriceController(double minPriceFactor) {
        this.minPriceFactor = minPriceFactor;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        double ratio = 1.0 - ((double) currentAmount / data.initialAmount());
        double factor = Math.max(minPriceFactor, ratio);
        return data.basePrice() * factor;
    }
}
