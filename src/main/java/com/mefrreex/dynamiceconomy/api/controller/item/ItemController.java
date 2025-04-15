package com.mefrreex.dynamiceconomy.api.controller.item;

import com.mefrreex.dynamiceconomy.api.model.ItemData;

/**
 * Manages item data retrieval.
 */
public interface ItemController {

    /**
     * Retrieves item data by its id.
     *
     * @param id The unique identifier of the item
     * @return The item data, or null if not found
     */
    ItemData getItemData(String id);
}