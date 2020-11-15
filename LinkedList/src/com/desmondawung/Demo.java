package com.desmondawung;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    private static LinkedList<String> placesToVisit = new LinkedList<>();

    public static void main(String[] args) {
        // warmup();
        // this forces the linked list items to always be in alphabetical order every time an item is added

        addInOrder(placesToVisit, "Fredericksburg");
        addInOrder(placesToVisit, "Austin");
        // visit(placesToVisit);
        addInOrder(placesToVisit, "San Antonio");
        addInOrder(placesToVisit, "South Padre");
        addInOrder(placesToVisit, "Houston");
        addInOrder(placesToVisit, "Dallas");
        addInOrder(placesToVisit, "El Paso");

        // printList(placesToVisit);

        // testing
        // addInOrder(placesToVisit, "Dallas");
        addInOrder(placesToVisit, "Fort worth");
        // printList(placesToVisit);
        printList(placesToVisit);
        visit(placesToVisit);
    }


    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        // more flexible than 'iterator' - really cool.
        ListIterator<String> stringListIterator = linkedList.listIterator();

        // we gotta do ListIterator.next() to point to the first node at the beginning
        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);  // compare one str to another
            // string1.compareTo(newString)
            // 0 ==> both str match
            if(comparison == 0)  {
                // do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            }

            // positive ==> string1 > newString
            else if(comparison > 0){
                // new city should be inserted before current city
                stringListIterator.previous();      // go 1 step back on the list
                stringListIterator.add(newCity);    // then insert the newCity
                return true;
            }

            // negative (comparison > 0) ==> string1 < newString
            // move on to next city
            // else {   // nothing to do here, since we already did .next() on comparison line
            // }
        }
        // if we got to the end of the linked list, then the new item has to go to the end of the list
        stringListIterator.add(newCity);
        return true;
    }

    public static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        int action;
        // ListIterator has no current position: always in b/w elts. .next() and .previous() gives us the actual elt
        ListIterator<String> listIterator = cities.listIterator();

        // if(cities.size() == 0) { // if we have a non-empty list
        if(cities.isEmpty()) {  // better way to check for empty list
            System.out.println("No cities on the list. Exiting.");
            return;
        }
        // else {
        //     System.out.println("Now visiting: " + listIterator.next());
        // }

        printMenu();
        while(!quit) {
            // get user input
            action = scanner.nextInt();

            switch (action) {
                case 0:     // quit
                    quit = true;
                    System.out.println("Ending your vacation. Bye.");
                    System.out.println("====================");
                    break;

                case 1: // go to next city
                    // first check the current direction
                    if(!goingForward) {
                        // if we were previously going backward, now we need to move iterator one extra step forward
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Yikes. We have reached the end of the list.");
                        goingForward = false;    // no way to go forward
                    }
                    break;

                case 2: // go to previous city
                    // first check the current direction
                    if(goingForward) {
                        // if we were previously going forward, now we need to move iterator one extra step backward
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("Back to visiting " + listIterator.previous());
                    } else {
                        System.out.println("Oops! Reached the start of the list.");
                        goingForward = true;    // no way to go backward
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available options:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to visit next city\n" +
                "2 - to visit previous city\n" +
                "3 - to print this menu");
    }

    private static void printList(LinkedList<String> linkedList) {
        // we use an iterator
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            // i.next() returns the value of the current node before moving i to next node. pretty cool.
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==========");
    }

    private static void warmup() {

            placesToVisit.add("Fredericksburg");
            placesToVisit.add("Austin");
            placesToVisit.add("San Antonio");
            placesToVisit.add("South Padre");
            placesToVisit.add("Houston");
            placesToVisit.add("Dallas");
            placesToVisit.add("El Paso");

            // System.out.println(placesToVisit.toString());
            // printList(placesToVisit);    // ***

            // INSERT
            placesToVisit.add(2, "Corpus Christi");
        // printList(placesToVisit);        // ***

            // REMOVE
            // placesToVisit.remove("South Padre");
            // OR
            placesToVisit.remove(4);
            // printList(placesToVisit);    // ***
    }

    // public class mobilePhone implements ITelephone {}
}
