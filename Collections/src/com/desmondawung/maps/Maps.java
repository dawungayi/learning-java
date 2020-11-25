package com.desmondawung.maps;

import java.util.*;

public class Maps {

    public static void main(String[] args) {

        // Recommended that key is an immutable type ==> Strings and Integers, for example.
        // Undefined behavior might result if we use a mutable type. e.g. using classes as keys
        // System.out.println("Algol".replace("A", "XXXXXXXXXX"));

        // Map<key_type, value_type> varName = new HashMap<>()
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A compiled, high level, object-oriented programming language");
        // languages.put("Python", "An interpreted, high level, object-oriented programming language");
        languages.put("C", "A structure-oriented, middle-level programming language, mostly used to develop low-level applications.");

        languages.put("Ruby", "An open-sourced, object-oriented scripting language, usually used with the Ruby on Rails framework.");
        //  .put() returns null for keys that are brand new key-val pair
        //  but for duplicate ==> returns the val that existed prior to the put
        // this is good if we want to know whether the key already exists or not.
        System.out.println(languages.put("C#", "A multi-paradigm that features imperative, declarative and object-oriented disciplines"));
        // each key cannot be duplicated ==> when we try .put() for the same key, old values get overwritten - no error tho.
        System.out.println(languages.put("Java", "Best language for CS majors."));


        // System.out.println(languages.toString());    // again, yr best friend
        // .get(key) ==>
        System.out.println(languages.get("Java"));

        System.out.println("\ncontainsKey method");
        // to put a key only if it does not exist yet, check with .containsKey()
        if (languages.containsKey("Python")) {
            System.out.println("SORRY: Python is already in the Map");
        } else {
            languages.put("Python", "The best language for beginner programmers.");
            System.out.println("Python added successfully");
        }

        // putIfAbsent ==> helps to prevent concurrency issues, so one thread cannot override vals for a key

        printMap(languages);

        System.out.println("\nremove method");
        // remove using key ==>  returns value
        // languages.remove("Java");
        languages.remove("Python");
        // remove a key if it only maps to a certain value
        if (languages.remove("Java", "Best language for CS majors.")) {
            System.out.println("Java entry removed");
        } else {
            System.out.println("SORRY: Java entry not removed; key/value pair not found.");
        }
        printMap(languages);

        System.out.println("\nreplace method");
        // replace the entry for a key
        // returns null if there was no entry for this key, and does nothing
        System.out.println(languages.replace("PHP", "an open-source scripting language designed for creating dynamic web pages that effectively work with databases."));
        // returns the old key if an entry for this key exists
        System.out.println(languages.replace("Ruby", "An open-sourced, object-oriented scripting language, used for web development."));

        // check for old val before replacing with new val
        // really useful when updating, say someone's address - first verify the old addr to make sure.
        if(languages.replace("C", "A structure-oriented, middle-level programming language, mostly used to develop low-level applications.",
                "a strong typed language used for writing apps that interact directly with hardware.")) {
            System.out.println("C was replaced");
        } else {
            System.out.println("C was not replaced");
        }

        printMap(languages);

        // MAP BULK Operations:
        /*
        The clear operation does exactly what you would think it could do: It removes all the mappings from the Map.
        The putAll operation is the Map analogue of the Collection interface's addAll operation. In addition to its
        obvious use of dumping one Map into another, it has a second, more subtle use. Suppose a Map is used to
        represent a collection of attribute-value pairs; the putAll operation, in combination with the Map conversion
        constructor, provides a neat way to implement attribute map creation with default values. The following is a
         static factory method that demonstrates this technique.

        static <K, V> Map<K, V> newAttributeMap(Map<K, V>defaults, Map<K, V> overrides) {
            Map<K, V> result = new HashMap<K, V>(defaults);
            result.putAll(overrides);
            return result;
        }
         */

    }

    public static void printMap(Map<String, String> stringMap) {
        // looping thru map and printing out all k,v pairs - using keySet(). No guaranteed order :(
        System.out.println("==========================");
        for(String key: stringMap.keySet()) {
            System.out.println(key + " : " + stringMap.get(key));
        }
        System.out.println("==========================");
    }

    // remove a specific key, val pair
}
