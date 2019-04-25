package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

// this class runs in the background and retrieves, parses and sends json data to the TableLayout
public class FetchR1Results extends AsyncTask<Void, Void, ArrayList<String>> {
    // this is where the raw json is held until Gson gets to it
    private String dataRead = "";
    private String score1, score2, score3, score4;

    private String score, useScore;

    // interface is needed for an asynctask to be referenced in another class
    public interface AsyncResponse {
        void doInBackground(ArrayList<String> ar);
    }

    // initialise the interface object as delegate
    private AsyncResponse delegate = null;

    // this reads the json data from the internet and converts it to a java object
    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        try {
            URL url = new URL(
                    "https://sportsmanager.ie/dataFeed/index.php?feedType=fixture&type=results&user_id=11064");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            if (line != null) {
                line = bufferedReader.readLine();
                dataRead = dataRead + line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // json data is converted to java objects using the Gson library
        Root3 root = new Gson().fromJson(dataRead, Root3.class);

        //stored in an array to be returned to onPostExecute using delegate function
        ArrayList<String> ar = new ArrayList<>();
        String homeTeam, awayTeam, homeScore, awayScore, date;

        // loop through json data and pull team names, scores and match date for Prem results
        // try catch block in case json data updates to size too small to call
        // gson is used to convert data from json data into java objects that can be put into arrayList
        String score, useScore;
        try {
            // loop through dataRead string
            for (int i = 0; i < dataRead.length(); i++) {
                // if comp name is prem div
                if (root.data.get(i).competitionName.equals("DAWFL Reserve Division 1")) {
                    // get hometeam, homescore, awayteam, awayscore and dates
                    homeTeam = root.data.get(i).homeTeam;
                    homeScore = root.data.get(i).homeScore;
                    awayTeam = root.data.get(i).awayTeam;
                    awayScore = root.data.get(i).awayScore;
                    date = root.data.get(i).fixtureDate;
                    //add teams to arraylist
                    ar.add(homeTeam);
                    ar.add(awayTeam);

                    // check for "2;0" format
                    if (homeScore.length() > 2) {
                        // remove semicolons from json data & add colon for formatting of score
                        score = homeScore + " : " + awayScore;
                        useScore = score.replace(";", "");
                        // remove extra zeros because json format is 2;0 for each team
                        StringBuilder sb = new StringBuilder(useScore);
                        sb.deleteCharAt(1);
                        sb.deleteCharAt(5);
                        String result = sb.toString();
                        ar.add(result);
                        // check for "1;" format
                    } else if (homeScore.length() <= 2) {
                        // remove semicolons from json data & add colon for formatting of score
                        score = homeScore + " : " + awayScore;
                        useScore = score.replace(";", "");
                        ar.add(useScore);
                    }

                    // add to arraylist
                    ar.add(date);
                }
            }
        } catch (IndexOutOfBoundsException n) {
        }


        // return array of Data objects, mixture of strings and ints converted from json
        return ar;
    }

    FetchR1Results(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    // this pushed the array of converted json data to the other activity
    @Override
    protected void onPostExecute(ArrayList<String> ar) {
        delegate.doInBackground(ar);
    }
}
