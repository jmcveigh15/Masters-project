package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import java.util.List;

// this class is used with the Gson library
// to convert json data from the internet to java objects
// class to be called to get an instance of the arrayList full of results info
public class  Root3 {

        List<Data3> data;

        public Root3(List<Data3> data) {
            this.data = data;
        }

    }

// this class sets the parameters for the contents of the arrayList full of results info
class Data3 {
    String fixtureDate, competitionName, homeTeam, awayTeam, homeScore, awayScore ;

    // constructor without args
    public Data3() {
    }

    // constructor with args
    public Data3(String fixtureDate,String competitionName, String homeTeam, String awayTeam, String homeScore, String awayScore) {
        this.fixtureDate=fixtureDate;
        this.competitionName=competitionName;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

}