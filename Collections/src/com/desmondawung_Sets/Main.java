package com.desmondawung_Sets;

import java.util.*;

public class Main {
    // map to model the k,v pairs of the solar system
    private static Map<String, HeavenlyBody> solarsystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        /*
            SETS
            Sets store single value entries (like lists), but have no defined order, and cannot contain duplicates unlike lists
            Ordered sets exist too?
            generally, use generic - single type (unlike maps: two types: one for key, one for values)
            remove, add, clear
            contains
            ** no way to retrieve an elt ==> because there is no index to do this
            best implementation: HashSet
            operations can be really fast - also good for Unions and Intersection
         */

        HeavenlyBody mercury = addPlanet("Mercury", 88);
        HeavenlyBody venus = addPlanet("Venus", 225);
        HeavenlyBody earth = addPlanet("Earth", 365);
        addMoon("Moon", 28, earth);

        HeavenlyBody mars = addPlanet("Mars", 687);
        addMoon("Deimos", 1.3, mars);
        addMoon("Phobos", 0.3, mars);

        HeavenlyBody jupiter = addPlanet("Jupiter", 4332);
        addMoon("Io", 1.8, jupiter);
        addMoon("Europa", 3.5, jupiter);
        addMoon("Callisto", 16.7, jupiter);
        addMoon("Ganymede", 7.1, jupiter);
        // yeah, doesn't work too well
        // System.out.println(planets.toString());
        // System.out.println(solarsystem.toString());

        System.out.println("All Planets:");
        printHeavenlyBodies(planets);
        printPlanetMoons(jupiter);

        // SET THEORY
        // unions - addAll
        // get all moons from different planets' .satellites sets ==> union
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody body: planets) {
            moons.addAll(body.getSatellites()); // add all moons from diff planets to this set
        }

        System.out.println("All moons of all planets:");
        printHeavenlyBodies(moons);

        // adding modified jupiter object - again - modified object to set
        // temp (below) and jupiter (above): these 2 java objects in the set do NOT compare equal ==> set has no problem with this).
        // similar with using an object as key in a map
        HeavenlyBody temp = new HeavenlyBody("Jupiter", 4220);
        planets.add(temp);
        System.out.println("After adding Jupiter again: ");
        printHeavenlyBodies(planets);   // yes we have 2 jupiter objects



    }

    // create planets
    public static HeavenlyBody addPlanet(String name, double orbitalPeriod) {
        HeavenlyBody temp = new HeavenlyBody(name, orbitalPeriod);
        solarsystem.put(name, temp);    // to map
        planets.add(temp);  // add to set
        return temp;
    }

    // create moons for planets
    public static void addMoon(String moonName, double moonPeriod, HeavenlyBody currentPlanet) {
        // don't add this to the planets Set
        HeavenlyBody tempMoon = new HeavenlyBody(moonName, moonPeriod);
        currentPlanet.addMoon(tempMoon);
        solarsystem.put(moonName, tempMoon);
    }

    public static void printHeavenlyBodies(Set<HeavenlyBody> setOfBodies) {
        // System.out.println("Planets");
        for (HeavenlyBody body : setOfBodies) {   // iterating thru the HashSet setOfBodies
            System.out.println("\t" + body.getName() + ": " + body.getOrbitalPeriod());   // not in any order
        }
    }

    public static void printPlanetMoons(HeavenlyBody body) {
        System.out.println(body.getName() + "'s moons are:");
        for(HeavenlyBody moon : body.getSatellites()) {   // iterating thru the planets.satellite HashSet
            System.out.println("\t" + moon.getName());  // yes, a moon is a heavenly body too. Hmm.
        }
    }



}
