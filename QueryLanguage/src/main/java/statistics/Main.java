package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        // yhteensä 18 pelaajaa
//        Matcher m = new Not(new HasAtLeast(1, "goals"));
//
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
//        
//        // yhteensä 8 pelaajaa
//        Matcher m = new Or( new HasAtLeast(40, "goals"),
//                    new HasAtLeast(60, "assists"),
//                    new HasAtLeast(85, "points")
//        );
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
//        
        // yhteensä 18 pelaajaa
        Matcher m = new HasFewerThan(1, "goals");
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
    }
}
