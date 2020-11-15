package com.desmondawung;

import java.util.ArrayList;

// generic class: specify the Type Parameter
// this way, we specify what type of player will be passed to this class as it is instantiated. Genius.
// T is a bounded type parameter, with upper bound of type Player - any class passed as T which is not derived from Player will throw a compilation error
// we can have multiple bounds: we can extend only 1 class, and multiple interfaces, or a mix of both (the class must come first tho)
// eg if Coach and Manager are interfaces, then we can have:
// public class Team<T extends Player & Coach & Manager> {
public class Team<T extends Player> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    // this generic works really well with abstract classes
    private ArrayList<T> members = new ArrayList<>();

    // constructor
    public Team(String name) {
        // this.name helps us differentiate from 'name' passed to the constructor. this is not needed in other cases
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // add a player to this team, avoiding duplicates
    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            // if we did not add bounded type param, then we will have to cast to player so compiler knows this is a Player type - pretty ugly
            System.out.println(player.getName() + " is already on this team!" );    // prevent duplicates
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " was picked for team " + name);
            return true;
        }
    }

    public boolean addMultiplePlayers(T[] players) {
        boolean result = true;
        for (T player : players) {
            result &= addPlayer(player);    // ANd the current result with what you get from adding the next players
        }

        return result;
    }

    // get the number of players in this team
    public int numPlayers() {
        return members.size();
    }

    // determines from the scores of the match if we won or lost
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore)
            won++;
        else if (ourScore < theirScore)
            lost++;
        else    // scores were the same
            tied++;

        played++;

        // update the opponent's match result as well. Wow!
        if (opponent != null) { // prevents forever looping
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        // this could be player dependent, since in real life this varies per the sport.
        // here we use soccer rankings ;)
        return (won * 3) + tied;
    }
}

// v1 - not a generic class
/*


public class Team {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    // this generic works really well with abstract classes
    private ArrayList<Player> members = new ArrayList<>();

    // constructor
    public Team(String name) {
        // this.name helps us differentiate from 'name' passed to the constructor. this is not needed in other cases
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // add a player to this team, avoiding duplicates
    public boolean addPlayer(Player player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team!" );    // prevent duplicates
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " was picked for Team " + name);
            return true;
        }
    }

    // get the number of players in this team
    public int numPlayers() {
        return members.size();
    }

    // determines from the scores of the match if we won or lost
    public void matchResult(Team opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore)
            won++;
        else if (ourScore < theirScore)
            lost++;
        else    // scores were the same
            tied++;

        played++;

        // update the opponent's match result as well. Wow!
        if (opponent != null) { // prevents forever looping
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        // this could be player dependent, since in real life this varies per the sport.
        // here we use soccer rankings ;)
        return (won * 3) + tied;
    }
}

 */