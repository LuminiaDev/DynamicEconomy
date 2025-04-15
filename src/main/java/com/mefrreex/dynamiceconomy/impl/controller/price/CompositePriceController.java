package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

import java.util.List;

/**
 * A composite price controller that chains multiple price calculation strategies.
 * Applies each controller in sequence, using the previous result as input for the next.
 */
public class CompositePriceController implements PriceController {

    private final List<PriceController> controllers;

    /**
     * Creates a new CompositePriceController instance.
     *
     * @param controllers The list of price controllers to apply in order
     */
    public CompositePriceController(List<PriceController> controllers) {
        this.controllers = controllers;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        double price = data.basePrice();
        for (PriceController controller : controllers) {
            price = controller.calculatePrice(id, currentAmount, new ItemData(price, data.initialAmount()));
        }
        return price;
    }
}
