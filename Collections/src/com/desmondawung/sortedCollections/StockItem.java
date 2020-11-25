package com.desmondawung.sortedCollections;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock;
    // private int quantityStock = 0;  // either initialize here

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;     // or here. It's better here.
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    // Setter - note: we can't set name since it is a final var
    public void setPrice(double price) {
        if (price > 0.0)
            this.price = price;
    }

    // add more or reduce to the stock
    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0.0)
            this.quantityStock = newQuantity;
    }

    // in order to use Comparable - for Sorted collections
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");
        if (obj == this) {  // if both are the same object in memory (the very basic .equals code)
            return true;
        }
        // null or different class instance
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        // compare names - if the same then both stock items are equal to each other
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;   // random int
    }


    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering stockItem.compareTo");
        if (this == o) {
            return 0;
        }
        // compare string names - check first that it's not null
        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();   // if we got a null
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
