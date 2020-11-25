package com.desmondawung.sets;

import java.util.*;

// model the solar system
public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites; // = new Set<>() won't work (not a class). Got to use HashSet, LinkedHashSet, etc

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        // create a copy (new Set instance) and return this copy - so external code doesn't mess with the object's set
        return new HashSet<>(satellites);
    }

    // option to add a moon
    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);   // adds this moon to the set if its not present yet
    }



}
