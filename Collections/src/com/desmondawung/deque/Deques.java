package com.desmondawung.deque;

import java.util.*;
// import java.util.LinkedList;

public class Deques {
    public static void main(String[] args) {

        // *** Deque is likely to be faster than a Stack ***
        // It is considered good practice to always specify a generic type when declaring a Java Deque variable.
        // That way the compiler can help you check what types are inserted into the Deque and you don't have to
        // cast the objects when you take them out of the Deque again. Also, it is more clear to the next person
        // reading your code what type of objects this Deque is supposed to contain. (source: http://tutorials.jenkov.com/java-collections/deque.html)
        // Deque<String> deque = new LinkedList<>();
        Deque<String> deque = new ArrayDeque<>();   // faster than LinkedList?

        System.out.println("Elt at head of deque: " + deque.peek());    // returns null if deque is empty

        //*** adding at beginning ***
        deque.add("Tom");   // to head - exception
        deque.push("Sarah");       // to head - exception

        deque.offer("Aria");      // to tail - true/false

        deque.addFirst("Mark"); // exception if full
        deque.addFirst("James");
        deque.addLast("Shaquille"); // to tail
        deque.addLast("Simon"); // exception if full

        System.out.println(deque.toString());
        //*** peeking: access/return elt without removing ***
        System.out.println("Elt at head of deque: " + deque.peek());    // @ head returns null if deque is empty
        System.out.println("Elt at tail of deque: " + deque.peekLast());    // returns null if deque is empty
        System.out.println("Elt at head of deque: " + deque.getFirst());    // @ head returns exception if deque is empty

        //*** popping ==> returning and removing ***
        System.out.println(deque.poll());   // remove and return from head - returns null if empty
        System.out.println(deque.toString());
        System.out.println(deque.removeLast()); // remove and return  - exception if empty
        System.out.println(deque.toString());
        System.out.println(deque.pop());    // remove from head - exception if empty
        System.out.println(deque.toString());

        System.out.println("Size: " + deque.size());
        if (deque.contains("Sarah")) {
            System.out.println("YESS! Deque contains her name!");
        }
        //*** looping through deque ***
        // for (String s : deque) {
        // Iterator<String> iterator = deque.iterator();   // iterate from head to tail
        // while(iterator.hasNext()) {
        //     System.out.println("Deque elt: " + iterator.next());
        // }
        Iterator<String> reversedIter = deque.descendingIterator();  // iterate in descending order: from tail to head
        while(reversedIter.hasNext()) {
            System.out.println("Deque elt: " + reversedIter.next());
        }

    }


}
