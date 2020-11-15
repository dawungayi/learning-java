package com.desmondawung;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        intro();
    }

    public static void intro() {

        Theater amc = new Theater("AMC Penn Square Mall", 5, 10 );
        // v1(amc);

        // shallow copy seats objects from amc.seats to seatCopy
        // they are distinct lists, but they both point to the same object references
        List<Theater.Seat> seatCopy = new ArrayList<>(amc.seats);

        // to prove that they both refer to the same objects: one list changes an obj's fields, it is reflected in the other list
        seatCopy.get(1).reserve();
        amc.seats.get(1).reserve();


        // original:
        System.out.println("Original: ");
        printList(amc.seats);
        // System.out.println("seatCopy reversed: ");
        // Collections.reverse(seatCopy);
        System.out.println("seatCopy shuffled: ");
        Collections.shuffle(seatCopy);
        printList(seatCopy);

        // get the min and max in a collection, according to sort order in the compareTo sort order in the Seat class
        // still goes and finds min and max even after we've shuffled it.
        Theater.Seat minSeat = Collections.min(seatCopy);
        Theater.Seat maxSeat = Collections.max(seatCopy);

        System.out.println("Min seat number: " + minSeat.getSeatNumber());
        System.out.println("Max seat number: " + maxSeat.getSeatNumber());

        // sort the shuffled array
        sortList(seatCopy);
        System.out.println("After sorting seatCopy:");
        printList(seatCopy);

        // Note: Do not use Collections.copy !!!
    }

    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print(seat.getSeatNumber() + ", ");
        }
        System.out.println("\n========================");
    }

    // public static void sortList(List<Theater.Seat> list) {
    public static void sortList(List<? extends Theater.Seat> list) {    // using generic ==> more flexible
        // we use bubble sort algorithm here => higher time complexity (O(n^2)) but better memory use than mergeSort

        for(int i = 0; i < list.size(); i++) {
            for (int j=i+1; j < list.size(); j++) {
                // compare elt i with all subsequent elts in the list
                // comparing two objects ==> we need to have the compareTo already setup in the Seat class
                if(list.get(i).compareTo(list.get(j)) >= 0) {
                    // swap i and j elts ==> larger elts bubble all the way up to the end of the array
                    Collections.swap(list, i, j);
                }

            }
        }
    }

    public static void v1(Theater amc) {
        System.out.println(amc.getTheaterName());
        // System.out.println('A' + String.format("%02d", 29));
        // amc.printSeats();
        amc.reserveSeat("B03");
        amc.reserveSeat("E11");
        amc.reserveSeat("B03");
    }
}
