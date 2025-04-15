package com.mefrreex.dynamiceconomy.impl.controller.price;

import com.mefrreex.dynamiceconomy.api.controller.price.PriceController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

import java.util.Map;

/**
 * Represents a price controller that applies multiplier factors based on quantity thresholds.
 * Prices increase when item quantities exceed configured threshold levels.
 */
public class ThresholdPriceController implements PriceController {

    private final Map<Double, Double> thresholds;

    /**
     * Creates a new ThresholdPriceController instance.
     *
     * @param thresholds A map of quantity thresholds to price multipliers where:
     *                   - Key: Minimum quantity threshold
     *                   - Value: Price multiplier to apply when threshold is reached
     *                   Example:
     *                   {@code Map.of(
     *                       100.0, 2.0,  // When stock ≥ 100, price doubles
     *                       50.0, 1.5,   // When stock ≥ 50, price ×1.5
     *                       10.0, 1.2    // When stock ≥ 10, price ×1.2
     *                   )}
     */
    public ThresholdPriceController(Map<Double, Double> thresholds) {
        this.thresholds = thresholds;
    }

    @Override
    public double calculatePrice(String id, int currentAmount, ItemData data) {
        // Pass through the thresholds and apply the appropriate coefficient
        for (Map.Entry<Double, Double> threshold : thresholds.entrySet()) {
            double thresholdAmount = threshold.getKey();
            double priceFactor = threshold.getValue();

            // If the current quantity is greater than the threshold, we apply the coefficient
            if (currentAmount >= thresholdAmount) {
                return data.basePrice() * priceFactor;
            }
        }

        // If we don't match any of the thresholds return the base price
        return data.basePrice();
    }
}

