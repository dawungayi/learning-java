package com.desmondawung;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        intro();
        // LinkedList: a lot easier to insert and remove O(1), unlike ArrayLists: O(n)
        // In JAva, the LinkedList class is actually a double linked list ==> we can move forward and backward.

    }

    public static void intro() {
        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;

        anotherCustomer = customer; // anotherCustomer points to address of customer instance ==> changing one changes to another
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is: " + customer.getBalance());


        ArrayList<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i=0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
        System.out.println("*******");
        intList.add(1, 22);     // insert at position 1 and move the other entries down
        // this makes inserting and removing very cumbersome for an ArrayList with millions of elements
        // the alternative: LinkedList

        // System.out.println(intList.toString());  // your best friend ;)
        for (int i=0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
    }

}
