package com.mefrreex.dynamiceconomy.api.controller.price;

import com.mefrreex.dynamiceconomy.api.model.ItemData;

public interface PriceController {

    double calculatePrice(String id, int currentAmount, ItemData data);
}
