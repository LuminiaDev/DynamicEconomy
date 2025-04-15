package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

public class FixedPriceController implements PriceController {

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        return data.basePrice();
    }
}
