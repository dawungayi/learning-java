package com.desmondawung;

import java.util.ArrayList;

public class AutoBoxing {

    public void initAutoBoxing() {
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("Tim");
        strArr.add("Boris");
        for (String s : strArr) {   // foreach - pretty cool
            System.out.println(s);
        }
        // does not work for primitive types like int, double, etc - we get an error
        // ArrayList<int> intArr = new ArrayList<int>();

        // but we can solve this by using autoboxing
        ArrayList<Double> doubleArrayList = new ArrayList<>();  // do we need to pass th class 'Double' to the constructor?
        ArrayList<Integer> intArrayList = new ArrayList<>();
        // now we can call ArrayList methods on ints
        // intArrayList.add(3);
        // intArrayList.add(5);

        // better:
        for(int i=0; i < 10; i++) {
            // boxing: converting from primitive type to object wrapper
            // intArrayList.add(Integer.valueOf(i));   // unnecessary boxing
            intArrayList.add(i);    // cleaner
        }
        // for (Integer num: intArrayList) { this works too. Hmm
        for (int i=0; i < intArrayList.size(); i++) {
            // unboxing: from object wrapper to primitive type
            // System.out.println(i + "--> " + intArrayList.get(i).intValue());     // unnecessary unboxing Hmm.
            System.out.println(i + "--> " + intArrayList.get(i));   // cleaner
        }
        int num = 3;
        System.out.println("Is " + num + " in ArrayList? " + intArrayList.contains(num));
    }

    public void smartBoxing() {
        // boxing
        Integer myInt = 42; // whaaaat!!!
        /*
        *  at compile time, it is read as (observe the boxing):
        * Integer myInt = Integer.valueOf(42)   // intelliJ says: redundant boxing - discouraged
        * */
        System.out.println(myInt);

        // unboxing
        // int myIntVal = myInt.intValue();   // unnecessary unboxing
        int myIntVal = myInt;   // at compile time: int myIntVal = myInt.intValue()
        System.out.println(myIntVal);
    }
}
