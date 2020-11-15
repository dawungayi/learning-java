package com.desmondawung;

import java.util.ArrayList;

// project to demo List and ArrayList
public class ArrayLists {

//    private int[] intArr = new int[8];
//     we don't define the type on LHS like arrays above.
    private ArrayList<String> groceryList = new ArrayList<String>();    // this is a class, so we define it using a constructor, hence the ()
    private ArrayList<Integer> kidsAges = new ArrayList<Integer>();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    // non static ==> belongs to instances of this class ==> can use this class' fields
    public void addGrocery(String item) {
        groceryList.add(item);  // append to end of the list
    }

    public void printGroceryList() {
        System.out.println("\n******************");
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        // System.out.println(groceryList.toString());
        // don't use foreach here: we need the indices!
        // for (String item: groceryList) {
        for (int i = 0; i < groceryList.size(); i++)
            System.out.println(i + ". " + groceryList.get(i));    // groceryList[i] does not work for ArrayList
    }

    // replace/update item at a position
    // use overloading to call private method which does more internal handling

    public void modifyGroceryItem(String oldItem, String newItem) {
        int position = findItem(oldItem);
        if (position >= 0) {    // if we have a valid index
            modifyGroceryItem(position, newItem);
        }
        else {
            System.out.println("Unsuccessful modifying item: " + oldItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item at position " + position + " has been modified" );
    }

    // use overloading to call private method which does more internal handling
    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {    // if we have a valid index
            removeGroceryItem(position);
        }
        else {
            System.out.println("Unsuccessful removing item: " + item);
        }
    }

    private void removeGroceryItem(int position) {
        // get the item to be removed
        String removedItem = groceryList.get(position);
        groceryList.remove(position);   // this is how we remove an elt from an arraylist. automatically fills up any gaps
        System.out.println("Grocery item " + removedItem + " has been removed");
    }

    public int findItem(String item) {
        return groceryList.indexOf(item);
    }
    /*
    // not ideal way to find
    public String findItem(String item) {
        // boolean exists = groceryList.contains(item); // return true or false if the object "item" is in the ArrayList
        int position = groceryList.indexOf(item);  // returns the index of the first occurrence. -1 if not in arrList

        if (position >= 0) {
            // if elt is in
            return groceryList.get(position);
        }
        // else
        return null;
    }
    */

//    public static void main(String[] args) {
//
//    }


}
