package com.desmondawung.sortedCollections;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        // TreeMap and TreeSet: sorted versions (based on .compare of T) of HashMap and HashSet
        //      ==> comes at a performance cost tho
        // LinkedHashMap and LinkedHashSet - they maintain order based on how they were added

        // add items in alphabetical order
        StockItem temp = new StockItem("apples", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("bread", 1.50, 50);
        stockList.addStock(temp);
        temp = new StockItem("grapes", 3.80, 100);
        stockList.addStock(temp);
        temp = new StockItem("juice", 4.50, 50);
        stockList.addStock(temp);
        // duplicate ==>  overrides previous
        temp = new StockItem("juice", 3.50, 30);
        stockList.addStock(temp);
        temp = new StockItem("lemons", 0.55, 120);
        stockList.addStock(temp);
        temp = new StockItem("plastic cup", 4.50, 50);
        stockList.addStock(temp);
        temp = new StockItem("water melon", 3.95, 400);
        stockList.addStock(temp);

        // HashMap: does not printout in any order tho.
        // whereas LinkedHashMap prints ion the order items were put in
        System.out.println(stockList.toString());
        // order in unMod map is the same as original Map
        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        // let's sell
        System.out.println("====================");
        Basket tylerBasket = new Basket("Tyler");
        sellItem(tylerBasket, "apples", 10);
        System.out.println(tylerBasket);    // uses .toString() in Basket class hmm

        sellItem(tylerBasket, "apples", 150);
        System.out.println(tylerBasket);

        sellItem(tylerBasket, "coffee", 30);
        System.out.println(tylerBasket);
        sellItem(tylerBasket, "lemons", 50);
        System.out.println(tylerBasket);
        sellItem(tylerBasket, "juice", 30);     // buy all
        System.out.println(tylerBasket);
        if ( sellItem(tylerBasket, "juice", 15) != 15) {
            System.out.println("There are no more juices in stock");
        }
        sellItem(tylerBasket, "water melon", 30);
        System.out.println(tylerBasket);
        System.out.println(stockList);  // updated

    }

    public static int sellItem(Basket basket, String itemName, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            // item not found in stock
            System.out.println("We don't sell " + itemName);
            return 0;
        }
        // can we sell this item? if so add to basket
        if (stockList.sellStock(itemName, quantity) != 0) { // if we have enough to sell
            // if using TreeMap, compares to all existing stockItems in basket before "putting" this to list
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        // else .sellstock() == 0 => not enough to sell
        System.out.println("Not enough of " + itemName + " item in stock to meet the quantity you wanted");
        return 0;
    }
}
