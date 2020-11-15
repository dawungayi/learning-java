package com.desmondawung;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        manageTheater();
    }

    public static void manageTheater() {

        Theater amc = new Theater("AMC Penn Square Mall", 8, 12);
        // v1(amc);

        // amc.getSeats().get(1).reserve();
        // amc.getSeats().get(1).reserve();
        // amc.getSeats().
        String seatName = "A02";
        amc.reserveSeat(seatName);
        amc.reserveSeat(seatName);

        amc.reserveSeat("D02");
        amc.reserveSeat("F11");

        // printList(amc.getSeats()); // won't work for Collection return

        // copy amc's list to the new List
        List<Theater.Seat> reversedSeats = new ArrayList<>(amc.getSeats());
        Collections.reverse(reversedSeats);
        printList(reversedSeats);

        // using comparator to sort by prices
        List<Theater.Seat> priceSeats = new ArrayList<>(amc.getSeats());
        priceSeats.add(amc.new Seat(  "A00", 13.00));   // creating a seat on the fly
        priceSeats.add(amc.new Seat("B00", 13.00));
        // sort is stable in that it does no swap elts if they don't need to be
        Collections.sort(priceSeats, Theater.PRICE_ORDER);
        System.out.println("After sorting by price:");
        printList(priceSeats);


    }

    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print(seat.getSeatNumber() +  " $" + seat.getPrice() + "; ");
        }
        System.out.println("\n========================");
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
