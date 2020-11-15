package com.desmondawung;

import java.util.*;
// import java.util.List;

public class Theater {
    private final String theaterName;
    // final ==> has to be initialized in constructor
    private final int numSeatsPerRow;

    // *** Different data structures based on what the use case is
    // private List<Seat> seats = new LinkedList<>();
    // private List<Seat> seats = new ArrayList<>();    // brute force - inefficient in searching
    // Collection ==> advantage: enables us to us any of the collections classes ==> super generic!
    // private Collection<Seat> seats = new HashSet<>();    // completely different order. wow!
    // private Collection<Seat> seats = new TreeSet<>();    // won't work if Seat class does not implement the comparable interface
    // private Collection<Seat> seats = new Vector<>();     // all good!
    // private Collection<Seat> seats = new Stack<>();      // all good.

    // testing diff data xtures
    public List<Seat> seats = new ArrayList<>();

    // constructor
    public Theater (String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        this.numSeatsPerRow = seatsPerRow;
        int lastRow = 'A' + (numRows - 1);  // first row is always row A. last row is ascii for letter corresp 1st row + numRows
        // create a new seat for the number of seats per row for each row
        // at the end of the for loops, we get a sorted list. Pretty cool!
        for (char row='A'; row <= lastRow; row++) {
            for (int seatNum=1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);    // add this seat object to the list of seats
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void printSeats() {
        System.out.println("Here are all the seats in the " + theaterName + " theater:");
        System.out.println("==================");
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
        /*
        // will not work with HashSet
        for (int i=0; i < seats.size(); i++) {
            if (i % numSeatsPerRow == 0) {
                System.out.println();   // new line between rows
            } else {
                System.out.print(seats. .get(i).getSeatNumber() + ", ");    // will
            }
        }
         */
        System.out.println("\n==================");
    }

    public boolean reserveSeat(String seatNumber) {
        // without comparable, yup, we have to iterate.
        // we cannot use seats.contains() because seats is a list of objects, and we have a string
        // even if we create a new object, we cannot compare both objects, since each object has multiple fields, etc
        /*
        // Not gonna work :(
        Seat requestedSeat = new Seat(seatNumber);

        if (seats.contains(requestedSeat)) {
            // yes, this seat is on the list
            requestedSeat = seats.get(seats.indexOf(requestedSeat));    // get this seat from the list of seats
            return requestedSeat.reserve();
        } else {
            // this seat is not on the list of seats
            System.out.println("There is no seat " + seatNumber + " in the " + theaterName + " theater.");
            return false;
        }
        */

        /*
        // Using iteration
        Seat requestedSeat = null;
        int count = 0;
        for (Seat seat : seats) {
            // scan the seats list for the one with a seatNumber matching the arg 'seatNumber'
            count +=1;
            if (seat.seatNumber.equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        System.out.println("Number of checks = " + count);
        if (requestedSeat == null) {
            // could not find the seat in the entire list
            System.out.println("There is no seat " + seatNumber + " in the " + theaterName + " theater.");
            return false;
        }
        // else
        return requestedSeat.reserve();
         */

        // Using binary search ==> O(log n) - really good since the seats List is sorted and each elt in it is unique
        Seat requestedSeat = new Seat(seatNumber);
        // of all seats, check for requestedSeat. Good thing is this takes in objects, and will use the compareTo method in our class.
        // binarySearch returns non-negative index if elt is found, else returns -(insertion_point index) ==> -ve elt
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        System.out.println("DEBUG: foundSeat = " + foundSeat);
        if (foundSeat >= 0) {   // yes found it
            return seats.get(foundSeat).reserve();
        }
        // else
        // could not find the seat in the entire list
        System.out.println("There is no seat " + seatNumber + " in the " + theaterName + " theater.");
        return false;

    }


    //======================
    // nested class: Seat
    //======================
    // add the Comparable interface, so we can use one of these Set implementations: HashSet, LinkedHashSet, etc
    // this will be a lot more efficient for searching
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean isReserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        // this method is needed to implement the Comparable interface
        // specify the field in the Seat class for comparison
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        // getter
        public String getSeatNumber() {
            return seatNumber;
        }

        // reserve a seat
        public boolean reserve() {
            if (!this.isReserved) {
                this.isReserved = true;
                System.out.println("Seat " + seatNumber + " reserved successfully.");
                return true;
            }
            // else
            System.out.println("SORRY: Seat " + seatNumber + " is already reserved.");
            return false;
        }

        // cancel reservation on a set
        public boolean cancel() {
            if (this.isReserved) {
                this.isReserved = false;
                System.out.println("Reservation for seat " + seatNumber + " cancelled.");
                return true;
            }
            // else
            System.out.println("SORRY: Seat " + seatNumber + " could not be cancelled, since it is not reserved.");
            return false;
        }

    }


}
