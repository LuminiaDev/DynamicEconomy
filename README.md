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

## Maven
Adding repo:
```xml
<repository>
    <id>luminiadev-repository-snapshots</id>
    <url>https://repo.luminiadev.com/snapshots</url>
</repository>
```

Adding dependency:
```xml
<dependency>
    <groupId>com.mefrreex.dynamiceconomy</groupId>
    <artifactId>dynamiceconomy</artifactId>
    <version>1.0.4-SNAPSHOT</version>
</dependency>
```

## Gradle
Adding repo:
```groovy
maven {
    name = "luminiadevRepositorySnapshots"
    url = uri("https://repo.luminiadev.com/snapshots")
}
```

Adding dependency:
```groovy
implementation "com.mefrreex.dynamiceconomy:dynamiceconomy:1.0.4-SNAPSHOT"
```
