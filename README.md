# DynamicEconomy

This library is designed to dynamically regulate the prices of the game market

## Example of usage:
```java
DynamicEconomy dynamicEconomy = DynamicEconomy.builder()
        .itemController(new BasicItemController(id -> switch (id) {
            case "bread" -> new ItemData(10, 50);
            case "apple" -> new ItemData(5, 25);
            default -> null;
        }, ItemData.EMPTY))
        .priceController(new ScaledPriceController(0.5))
        .build();

double price = dynamicEconomy.getCurrentPrice("bread");
dynamicEconomy.decreaseItemCount("bread", 1);
```

More use cases can be found [here](docs/examples)