package com.desmondawung;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // rawType();
        // intro();

        FootballPlayer mahomes = new FootballPlayer("Patrick Mahomes"); // raw type
        BasketballPlayer lebron = new BasketballPlayer("Lebron James");

        SoccerPlayer ronaldo = new SoccerPlayer("Christiano Ronaldo");

        // without generics, one big problem is that different player types can all be added to one team - no bueno!
        // Lebron prolly knows nothing about soccer!

        // with generics - it checks for the type and throws a compilation error right here. Pretty cool.
        // but we need to restrict the type of class passed as a parameter type T for Team class: bounded type parameters
        // Team<String> brokenTeam = new Team<String>("This is bad");
        // if we don't restrict <T> types this will not throw a compilation error, only throws error at runtime- no bueno!
        // brokenTeam.addPlayer("no one");


        Team<FootballPlayer> chiefs = new Team<>("Kansas City Chiefs");
        chiefs.addPlayer(mahomes);

        Team<BasketballPlayer> lakers = new Team<>("Los Angeles Lakers");
        lakers.addPlayer(lebron);
        // chiefs.addPlayer(ronaldo);

        System.out.println(chiefs.numPlayers());
        System.out.println(lakers.numPlayers());

        // Liverpool Team
        Team<SoccerPlayer> liverpool = new Team<>("Liverpool");
        SoccerPlayer salah = new SoccerPlayer("Mo Salah");
        SoccerPlayer mane = new SoccerPlayer("Sadio Mane");
        SoccerPlayer vanDijk = new SoccerPlayer("Virgil Van Dijk");
        SoccerPlayer[] liverpoolPlayers = new SoccerPlayer[] {salah, mane, vanDijk};
        liverpool.addMultiplePlayers(liverpoolPlayers);

        // Barcelona Team
        Team<SoccerPlayer> barcelona = new Team<>("Barcelona");
        SoccerPlayer messi = new SoccerPlayer("Lionel Messi");
        SoccerPlayer griezmann = new SoccerPlayer("Antoine Griezmann");
        SoccerPlayer pique = new SoccerPlayer("Gerard Pique");
        SoccerPlayer[] barcaPlayers = new SoccerPlayer[] {messi, griezmann, pique};
        barcelona.addMultiplePlayers(barcaPlayers);

        Team<SoccerPlayer> juventus = new Team<>("Juventus");
        Team<SoccerPlayer> psg = new Team<>("PSG");

        liverpool.matchResult(barcelona, 2, 1);
        juventus.matchResult(psg, 1, 3);
        psg.matchResult(liverpool, 2, 2);
        barcelona.matchResult(juventus, 1, 0);

        // Rankings
        System.out.println("Rankings:");
        System.out.println(liverpool.getName() + " : " + liverpool.ranking());
        System.out.println(barcelona.getName() + " : " + barcelona.ranking());
        System.out.println(psg.getName() + " : " + psg.ranking());
        System.out.println(juventus.getName() + " : " + juventus.ranking());
        // throws an error
        // barcelona.matchResult(lakers, 3, 4);

    }


    private static void intro() {
        // for Java 7+ the explicit type argument on RHS <Integer> can be replaced with the diamond, <>
        ArrayList<Integer> moreItems = new ArrayList<>();
        // this ArrayList can contain only contain Integer type in it. Yayy. It's called a PARAMETERIZED TYPE
        moreItems.add(1);
        moreItems.add(2);
        moreItems.add(3);
        // moreItems.add("Des");   // this throws an error at compile time. Good!
        moreItems.add(4);
        moreItems.add(5);

        printDoubled(moreItems);
    }

    private static void printDoubled(ArrayList<Integer> list) {
        // for (int element : list) {      // this works too: autoboxing
        for (Integer element : list) {  // we know exactly what object type we are using. easier to catch errors
            System.out.println(element * 2);     //
        }

    }

    private static void rawType() {
        ArrayList items = new ArrayList();
        // this ArrayList can contain any type in it. Yayy. It's called a RAW TYPE
        // unfortunately, without specifying the type, Java compiler does not do any type checking :(
        // compilees fine, but only breaks at runtime. NEVER USE THESE RAW TYPES!
        items.add(1);
        items.add(2);
        items.add(3);
        // items.add("Des");   // and this could really blow up in out face!
        items.add(4);
        items.add(5);

        printDoubledRaw(items);
    }

    private static void printDoubledRaw(ArrayList list) {

        for (Object element : list) {
            System.out.println((Integer)element * 2);     // cast element to an integer - we HAVE to tell Java what type it is
        }

    }
}
