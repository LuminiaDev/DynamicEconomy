# Item Controller

What is an ItemController? This interface is required to manage items: prices and real quantities.

## You can create your own item controller
```java
import com.mefrreex.dynamiceconomy.api.controller.item.ItemController;
import com.mefrreex.dynamiceconomy.api.model.ItemData;

import java.util.HashMap;
import java.util.Map;

public class CustomItemController implements ItemController {

    private final Map<String, ItemData> items = new HashMap<>();

    public CustomItemController() {
        items.put("bread", new ItemData(10, 50));
        items.put("apple", new ItemData(2, 25));
        items.put("milk", new ItemData(4, 25));
    }

    @Override
    public ItemData getItemData(String id) {
        return items.get(id);
    }
}
```
## Or use the basic implementation
You can use the basic implementation of ItemController - BasicItemController, which is enough to work with
```java
temController controller = new BasicItemController(id -> switch (id) {
        case "bread" -> new ItemData(10, 50);
        case "apple" -> new ItemData(5, 25);
        default -> null;
}, ItemData.EMPTY);
```

Or use Map<String, ItemData> for this purpose
```java
ItemController controller = new BasicItemController(id -> items.get(id), ItemData.EMPTY);
```