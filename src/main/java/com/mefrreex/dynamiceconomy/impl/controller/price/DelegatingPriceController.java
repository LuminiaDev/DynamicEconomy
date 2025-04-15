package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

import java.util.function.Function;

/**
 * A delegating price controller that routes price calculations to specific controllers
 * based on item ID, with fallback to a default controller when no specific controller is found.
 */
public class DelegatingPriceController implements PriceController {

    private final Function<String, PriceController> controllerResolver;
    private final PriceController defaultController;

    /**
     * Creates a new DelegatingPriceController instance.
     *
     * @param controllerResolver Function that resolves an appropriate controller for a given item ID
     * @param defaultController Fallback controller to use when resolver returns null
     */
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
