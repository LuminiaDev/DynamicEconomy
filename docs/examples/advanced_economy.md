# Advanced Economy
Example of an advanced dynamic economy with advanced price controllers

```java
import com.mefrreex.dynamiceconomy.api.DynamicEconomy;
import com.mefrreex.dynamiceconomy.api.model.ItemData;
import com.mefrreex.dynamiceconomy.impl.controller.item.BasicItemController;
import com.mefrreex.dynamiceconomy.impl.controller.price.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedEconomy {

    public static void main(String[] args) {
        // Adding and configuring item prices
        Map<String, ItemData> items = new HashMap<>();
        items.put("bread", new ItemData(10, 50));
        items.put("apple", new ItemData(2, 25));
        items.put("milk", new ItemData(4, 25));

        // Configuring a dynamic economy
        DynamicEconomy dynamicEconomy = DynamicEconomy.builder()
                // Set the item controller (with the lambda in it, we can dynamically control the items)
                .itemController(new BasicItemController(items::get, ItemData.EMPTY /*<- Default value*/))
                // Set the price controller to DelegatingPriceController to delegate controllers for individual items
                .priceController(new DelegatingPriceController(id -> switch (id) {
                    // Use CompositePriceController to combine several controllers in sequence
                    case "bread" -> new CompositePriceController(List.of(
                            new ScaledPriceController(2),
                            new DemandBoostPriceController(3, 1.5)
                    ));
                    case "apple" -> new ScaledPriceController(0.3);
                    case "milk" -> new ScaledPriceController(0.5);
                    default -> null;
                }, new FixedPriceController())) // If no controller for the item is found, we use FixedPriceController
                .build();

        emitBuyItems(dynamicEconomy, "bread", 5);
        emitBuyItems(dynamicEconomy, "apple", 5);
        emitBuyItems(dynamicEconomy, "milk", 5);
    }

    private static void emitBuyItems(DynamicEconomy dynamicEconomy, String itemToBuy, int amount) {
        System.out.println("Emit the purchase of an item " + itemToBuy);

        // Emitting the purchase of an item
        for (int i = 0; i < amount; i++) {
            // Get the current price of the item
            double currentPrice = dynamicEconomy.getCurrentPrice(itemToBuy);
            // Decrease the current item quantity by 1
            dynamicEconomy.decreaseItemCount(itemToBuy, 1);

            System.out.printf("The price of the item %s is %s", itemToBuy, currentPrice);
            System.out.println();
        }
    }
}
```

So we created a dynamic economy with price controllers for different types of items, and emulated the purchase of each item and their reduction.

Output to the console looks like this:
```
Emit the purchase of an item bread
The price of the item bread is 10.0
The price of the item bread is 10.4
The price of the item bread is 10.8
The price of the item bread is 11.200000000000001
The price of the item bread is 11.6
Emit the purchase of an item apple
The price of the item apple is 2.0
The price of the item apple is 2.024
The price of the item apple is 2.048
The price of the item apple is 2.072
The price of the item apple is 2.096
Emit the purchase of an item milk
The price of the item milk is 4.0
The price of the item milk is 4.08
The price of the item milk is 4.16
The price of the item milk is 4.24
The price of the item milk is 4.32
```