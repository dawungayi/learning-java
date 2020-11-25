package com.desmondawung.sortedCollections;

import java.util.*;

public class StockList {
    private final Map<String, StockItem> list; // initialized in constructor

    public StockList() {
        // this.list = new HashMap<>();
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // get the item from the list of stock items
            // check if we already have qties of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);    // if key is not in map, return the item by default
            if (inStock != item) {      // if it's in the map, add stock qty
                inStock.adjustStock(inStock.quantityInStock());
            }
            // else we just add it to the list
            list.put(item.getName(), item);
            return item.quantityInStock(); // what's the item's new total stock?
        }
        // else
        return 0;
    }


    public int sellStock(String itemName, int quantity) {
        // deduct stock for this item
        StockItem inStock = list.getOrDefault(itemName, null);
        // make sure this is on list, we have enough to sell and we have non-negative num to sell
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >= 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        // else
        return 0;
    }

    // get the value for a key in the 'list' map, since list is private
    public StockItem get(String key) {
        return list.get(key);
    }

    // get the entire map
    public Map<String, StockItem> Items() {
        // return a read-only view of the map. so user cannot put items into list from here
        // the collection is unmodifiable, but individual objects can be modified tho
        return Collections.unmodifiableMap(list);
    }

    @Override
    // toString - not really useful in production
    public String toString() {
        String s = "\nStock List\n";
        double totalStockValue = 0.0;

        for (Map.Entry<String, StockItem> item: list.entrySet()) {
            StockItem stockItem = item.getValue();
            // total value of this stock item in the store
            double itemValue = stockItem.getPrice()*stockItem.quantityInStock();
            totalStockValue += itemValue; // add to totalStockValue

            s = s +  stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            // limit double to 2 dp
            s = s + String.format("%.2f", itemValue) + "\n";
        }

        return s + "Total stock value: " + String.format("%.2f", totalStockValue);
    }


}
