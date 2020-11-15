package com.desmondawung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static ArrayLists arrList = new ArrayLists();    // accessible across the different static methods in the Main class

    public static void main(String[] args) {

        // Autoboxing
        runAutoBoxing();

        // ArrayLists
        // runArrayList();

        /*
        // Arrays
        reverseArrayChallenge();
        refTypes();
        sandbox();
        int[] intArray = getIntegers(5);
        printArray(intArray);
        System.out.println("Average for array is: " + getAverage(intArray));
*/
    }

    // Autoboxing
    public static void runAutoBoxing() {
        AutoBoxing myBoxing = new AutoBoxing();
        // myBoxing.initAutoBoxing();
        myBoxing.smartBoxing();
    }


    // ArrayLists
    public static void runArrayList() {
        initArrayList();

        // copying arrayLists
        // initializing an arrayList to equal to another - copy the entire content of one array to another
        // method #1 ==> we know the old array at the point we are creating the new array
        ArrayList<String> newArrList = new ArrayList<String>(arrList.getGroceryList());
        // method #2 ==> we don't
        ArrayList<String> anotherArrList = new ArrayList<String>();
        // do some stuff here...
        anotherArrList.addAll(arrList.getGroceryList());

        System.out.println(arrList.getGroceryList() + " ~~ should be equiv to ~~ \n" + newArrList
                + " ~~ which is also equiv to ~~ \n" + anotherArrList );

        // convert from ArrayList to array - it actually keeps the ArrayList order
        int arrLen = arrList.getGroceryList().size();
        String[] myArray = new String[arrLen];
        myArray = arrList.getGroceryList().toArray(myArray);
        System.out.println("Array: " + Arrays.toString(myArray));
        System.out.println("Array #2: " + myArray[2]);

    }

    public static void initArrayList() {

        arrList.addGrocery("Tomatoes");
        arrList.addGrocery("Avocados");
        arrList.addGrocery("Spinach");
        arrList.addGrocery("Sugar");
        arrList.addGrocery("Flour");
        arrList.printGroceryList();
        arrList.modifyGroceryItem("Rice", "Lettuce");
        arrList.modifyGroceryItem("Avocados", "Lettuce");
        arrList.printGroceryList();
        arrList.removeGroceryItem("Tomatoes");
        arrList.removeGroceryItem("Popcorn");
        arrList.printGroceryList();
        String searchItem = "Flour";
        System.out.println("\nFinding " + searchItem + " in grocery list: "  + arrList.findItem(searchItem));
    }

    // Arrays
    public static void reverseArrayChallenge() {
        int[] intArr = {90, 2, 3, 4, 5, 7};
        System.out.println("Before reverse: " + Arrays.toString(intArr));
        reverseArray(intArr);
        System.out.println("After reverse: " + Arrays.toString(intArr));
    }

    public static void reverseArray(int[] array) {
        /*
        // approach #1: does not work since we are pointing array to new reference: old reference stays unchanged
        int arrLen = array.length;
        int[] reversed = new int[arrLen];
        for(int i = 0; i < arrLen; i++) {
            reversed[i] = array[arrLen-1 - i];
        }
        System.out.println(Arrays.toString(reversed));
        array = reversed;
        */

        // approach #2: reverse in place
        // as i moves from 0 to halfLength, each elt is swapped with its mirror elt: 1st with the last; 2nd with the 2nd to the last; etc
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;  // if odd length, rounds down to truncated int value
        int temp;

        for(int i = 0; i < halfLength; i++) {
            temp = array[i];
            array[i] = array[maxIndex -i];  // swap 2 elts equidistant from the halfway point
            array[maxIndex-i] = temp;
        }
    }

    public static void refTypes() {
        // value types
        int myInt = 6;
        int anotherInt = myInt;
        System.out.println("myInt: " + myInt);
        System.out.println("another Int: " + anotherInt);

        anotherInt++;
        System.out.println("myInt: " + myInt);
        System.out.println("another Int: " + anotherInt);

        System.out.println("************************\n");

        // new ==> reference types
        int[] intArr = new int[5];
        // both intArr and anotherArr point to the same reference in memory (references pointing the same array in memory).
        // updating contents of one array object updates the other as well
        int[] anotherArr = intArr;
        System.out.println("intArr: " + Arrays.toString(intArr));  // pretty cool method: Arrays.toString
        System.out.println("anotherArr: " + Arrays.toString(anotherArr));  // pretty cool method: Arrays.toString

        anotherArr[0] = 1;
        System.out.println("intArr after change: " + Arrays.toString(intArr));  // pretty cool method: Arrays.toString
        System.out.println("anotherArr after change: " + Arrays.toString(anotherArr));  // pretty cool method: Arrays.toString

        modifyArray(intArr);
        System.out.println("intArr after modify: " + Arrays.toString(intArr));  // pretty cool method: Arrays.toString
        System.out.println("anotherArr after modify: " + Arrays.toString(anotherArr));  // pretty cool method: Arrays.toString


    }

    public static void modifyArray(int[] array) {
        array[0] = 2;
        array = new int[]{1,2,3,4,5};   // we cannot change the reference in a function: this now points to a new array in memory
    }

    public static int[] getIntegers(int num) {
        System.out.println("Enter " + num + " integer values: ");
        int[] array = new int[num];

        for (int i = 0; i < array.length ; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static double getAverage(int[] array) {
        int sum = 0;
        int numElts = array.length;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return (double)sum/ (double) numElts;
    }


    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Element %d is %d\n", i, array[i]);
        }
    }

    private static void sandbox() {
        int[] myIntArr = new int[10];

        for (int i = 0; i < myIntArr.length; i++ ) {
            myIntArr[i] = i*2;
        }

        System.out.println(myIntArr[7]);
        System.out.println(myIntArr[9]);

        int[] intArr2 = {7, 12, 9, 3, 5};    // only applicable the first time we define the array variable
        printArray(intArr2);
    }

}
