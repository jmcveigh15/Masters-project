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
public class FetchD2Fixtures extends AsyncTask<Void, Void, ArrayList<String>> {
    // this is where the raw json is held until Gson gets to it
    private String dataRead = "";


    // interface is needed for an asynctask to be referenced in another class
    public interface AsyncResponse {
        void doInBackground(ArrayList<String> strings);
    }

    // initialise the interface object as delegate
    private AsyncResponse delegate = null;

    // this reads the json data from the internet and converts it to a java object
    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        try {
            URL url = new URL(
                    "https://sportsmanager.ie/dataFeed/index.php?feedType=fixture&type=fixtures&user_id=11064");
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
        Root2 root = new Gson().fromJson(dataRead, Root2.class);

        //stored in an array to be returned to onPostExecute using delegate function
        ArrayList<String> strings = new ArrayList<>();
        String homeTeam, awayTeam, venue, date;

        // this loops through all fixtures and gets hometeam, awayteam, venue and date
        // for premier division teams and adds them to an array
        // the try catch block ensures all the json is looped through
        // and will not crash app when size of json file changes
        try {
            for (int i = 0; i < 50; i++) {
                if (root.data.get(i).competitionName.equals("DAWFL Division 2")) {
                    homeTeam = root.data.get(i).homeTeam;
                    venue = root.data.get(i).venue;
                    awayTeam = root.data.get(i).awayTeam;
                    date = root.data.get(i).fixtureDate;
                    strings.add(homeTeam);
                    strings.add(awayTeam);
                    strings.add(venue);
                    strings.add(date);
                }
            }
        } catch (IndexOutOfBoundsException n) {
        }

        // return array of Data objects, mixture of strings and ints converted from json
        return strings;
    }

    FetchD2Fixtures(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    // this pushed the array of converted json data to the other activity
    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        delegate.doInBackground(strings);
    }
}
