package com.desmondawung.sortedCollections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    // keep track of the quantity of each stock item in the basket
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        // this.list = new HashMap<>(); // unsorted - faster :)
        // sorts items for us automatically (according to name), using the compareTo method in the StockItem class
        // so the basket items are printed in alphabetical order. More work for each list.put() ==> performance cost / slower
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            // defaults (initializes) to zero if not already in basket
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        // returns read-only map ==> no way user to modify list from here
        // good security feature to limit the ways in which users can add items to Basket outside of using methods defined
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        System.out.println("----");
        String s = "Shopping basket for " + name + " contains " + list.size() +
                ((list.size() == 1) ? " item" : " items" ) +  "\n"; // ternary operator
        double totalValue = 0.0;
        // iterate thru all entries in the shopping basket
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            // total value for this entry is its price * num of this item in the list
            totalValue += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total Value in Basket " + totalValue + "\n----";
    }
}
