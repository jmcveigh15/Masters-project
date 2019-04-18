package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import java.util.List;

// this class is used with the Gson library
// to convert json data from the internet to java objects
// the hierarchy is root - data - leagueTable
public class Root {
    Data data;
}

class Data {
    List<LeagueTable> leagueTable;

    public Data(List<LeagueTable> leagueTable) {
        this.leagueTable = leagueTable;
    }

    public static class LeagueTable {
        // these are all items within the json data that will be converted
        String team;
        String played;
        String gamesWon;
        String gamesDraw;
        String gameLost;
        String goalsFor;
        String goalsAgainst;
        String goalsDifference;
        String points;

        // constructor with args for the leagueTable objects
        public LeagueTable(String team, String played, String gamesWon, String gamesDraw, String gameLost, String goalsFor,
                           String goalsAgainst, String goalsDifference, String points) {
            this.team = team;
            this.played = played;
            this.gamesWon = gamesWon;
            this.gamesDraw = gamesDraw;
            this.gameLost = gameLost;
            this.goalsFor = goalsFor;
            this.goalsAgainst = goalsAgainst;
            this.goalsDifference = goalsDifference;
            this.points = points;
        }
    }



}