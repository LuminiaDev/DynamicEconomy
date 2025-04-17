# Simple Economy
Example of a simple dynamic economy

```java
import com.mefrreex.dynamiceconomy.api.DynamicEconomy;
import com.mefrreex.dynamiceconomy.api.model.ItemData;
import com.mefrreex.dynamiceconomy.impl.controller.item.BasicItemController;
import com.mefrreex.dynamiceconomy.impl.controller.price.*;

import java.util.HashMap;
import java.util.Map;

public class SimpleEconomy {

    public static void main(String[] args) {
        // Adding and configuring item prices
        Map<String, ItemData> items = new HashMap<>();
        items.put("bread", new ItemData(10, 50));
        items.put("apple", new ItemData(2, 25));
        items.put("milk", new ItemData(4, 25));

        String itemToBuy = "bread"; // for example, we'll buy bread

        // Configuring a dynamic economy
        DynamicEconomy dynamicEconomy = DynamicEconomy.builder()
                // Set the item controller (with the lambda in it, we can dynamically control the items)
                .itemController(new BasicItemController(items::get, ItemData.EMPTY /*<- Default value*/))
                // Set the price controller. For example, 
                // we will use ScaledPriceController with a factor of 0.5
                .priceController(new ScaledPriceController(0.5))
                .build();

        // Emitting the purchase of an item
        for (int i = 0; i < 25; i++) {
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

So we created a dynamic economy and added a controller for items and their prices, as well as emulating item purchase and item reduction. 

Output to the console looks like this:
```
The price of the item bread is 10.0
The price of the item bread is 10.1
The price of the item bread is 10.2
The price of the item bread is 10.3
The price of the item bread is 10.4
The price of the item bread is 10.5
...
```