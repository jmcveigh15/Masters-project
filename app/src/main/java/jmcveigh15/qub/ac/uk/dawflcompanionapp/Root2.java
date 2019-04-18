package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import java.util.List;

// this class is used with the Gson library
// to convert json data from the internet to java objects
// the hierarchy is root - data - leagueTable
// class to be called to get an instance of the arrayList full of fixtures info
public class  Root2 {

        List<Data2> data;

        public Root2(List<Data2> data) {
            this.data = data;
        }

    }

    // this class sets the parameters for the contents of the arrayList full of fixtures info
    class Data2 {
        String competitionName, homeTeam, awayTeam, venue;

        // constructor without args
        public Data2() {
        }

        // constructor with args
        public Data2(String competitionName, String homeTeam, String awayTeam, String venue) {
            this.competitionName = competitionName;
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.venue = venue;
        }

    }