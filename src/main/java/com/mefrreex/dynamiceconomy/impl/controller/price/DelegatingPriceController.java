package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

import java.util.function.Function;

public class DelegatingPriceController implements PriceController {

    private final Function<String, PriceController> controllerResolver;
    private final PriceController defaultController;

    public DelegatingPriceController(Function<String, PriceController> controllerResolver, PriceController defaultController) {
        this.controllerResolver = controllerResolver;
        this.defaultController = defaultController;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        PriceController controller = controllerResolver.apply(id);
        if (controller == null) {
            controller = defaultController;
        }
        return controller.calculatePrice(id, currentAmount, data);
    }
}
