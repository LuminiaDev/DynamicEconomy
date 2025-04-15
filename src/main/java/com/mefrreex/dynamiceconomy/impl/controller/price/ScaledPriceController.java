package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

public class ScaledPriceController implements PriceController {

    private final double factor;

    public ScaledPriceController(double factor) {
        this.factor = factor;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        return data.basePrice() * (1.0 + factor * ((double) (data.initialAmount() - currentAmount) / data.initialAmount()));
    }
}

