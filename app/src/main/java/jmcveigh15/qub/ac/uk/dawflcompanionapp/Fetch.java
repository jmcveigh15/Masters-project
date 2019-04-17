package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// this class runs in the background and retrieves, parses and sends json data to the TableLayout
public class Fetch extends AsyncTask<Void, Void, String[]> {
    // this is where the raw json is held until Gson gets to it
    private String dataRead = "";

    // interface is needed for an asynctask to be referenced in another class
    public interface AsyncResponse {
        void doInBackground(String[] ar);
    }

    // initialise the interface object as delegate
    private AsyncResponse delegate = null;

    // this reads the json data from the internet
    // and converts it to a java object
    @Override
    protected String[] doInBackground(Void... voids) {
        try {
            URL url = new URL(
                    "https://sportsmanager.ie/dataFeed/index.php?feedType=fixture&type=league_table&competition_id=131409");
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
        Root root = new Gson().fromJson(dataRead, Root.class);

        // stored in an array to be returned to onPostExecute using delegate function
        String[] ar = new String[81];

        // adding team names data to array
        ar[0] = root.data.leagueTable.get(0).team;
        ar[1] = root.data.leagueTable.get(1).team;
        ar[2] = root.data.leagueTable.get(2).team;
        ar[3] = root.data.leagueTable.get(3).team;
        ar[4] = root.data.leagueTable.get(4).team;
        ar[5] = root.data.leagueTable.get(5).team;
        ar[6] = root.data.leagueTable.get(6).team;
        ar[7] = root.data.leagueTable.get(7).team;
        ar[8] = root.data.leagueTable.get(8).team;

        // adding games played data to array
        ar[9] = root.data.leagueTable.get(0).played;
        ar[10] = root.data.leagueTable.get(1).played;
        ar[11] = root.data.leagueTable.get(2).played;
        ar[12] = root.data.leagueTable.get(3).played;
        ar[13] = root.data.leagueTable.get(4).played;
        ar[14] = root.data.leagueTable.get(5).played;
        ar[15] = root.data.leagueTable.get(6).played;
        ar[16] = root.data.leagueTable.get(7).played;
        ar[17] = root.data.leagueTable.get(8).played;

        // adding games won data to array
        ar[18] = root.data.leagueTable.get(0).gamesWon;
        ar[19] = root.data.leagueTable.get(1).gamesWon;
        ar[20] = root.data.leagueTable.get(2).gamesWon;
        ar[21] = root.data.leagueTable.get(3).gamesWon;
        ar[22] = root.data.leagueTable.get(4).gamesWon;
        ar[23] = root.data.leagueTable.get(5).gamesWon;
        ar[24] = root.data.leagueTable.get(6).gamesWon;
        ar[25] = root.data.leagueTable.get(7).gamesWon;
        ar[26] = root.data.leagueTable.get(8).gamesWon;

        // adding games drawn data to array
        ar[27] = root.data.leagueTable.get(0).gamesDraw;
        ar[28] = root.data.leagueTable.get(1).gamesDraw;
        ar[29] = root.data.leagueTable.get(2).gamesDraw;
        ar[30] = root.data.leagueTable.get(3).gamesDraw;
        ar[31] = root.data.leagueTable.get(4).gamesDraw;
        ar[32] = root.data.leagueTable.get(5).gamesDraw;
        ar[33] = root.data.leagueTable.get(6).gamesDraw;
        ar[34] = root.data.leagueTable.get(7).gamesDraw;
        ar[35] = root.data.leagueTable.get(8).gamesDraw;

        // adding games lost data to array
        ar[36] = root.data.leagueTable.get(0).gameLost;
        ar[37] = root.data.leagueTable.get(1).gameLost;
        ar[38] = root.data.leagueTable.get(2).gameLost;
        ar[39] = root.data.leagueTable.get(3).gameLost;
        ar[40] = root.data.leagueTable.get(4).gameLost;
        ar[41] = root.data.leagueTable.get(5).gameLost;
        ar[42] = root.data.leagueTable.get(6).gameLost;
        ar[43] = root.data.leagueTable.get(7).gameLost;
        ar[44] = root.data.leagueTable.get(8).gameLost;

        // adding goals for data to array
        ar[45] = root.data.leagueTable.get(0).goalsFor;
        ar[46] = root.data.leagueTable.get(1).goalsFor;
        ar[47] = root.data.leagueTable.get(2).goalsFor;
        ar[48] = root.data.leagueTable.get(3).goalsFor;
        ar[49] = root.data.leagueTable.get(4).goalsFor;
        ar[50] = root.data.leagueTable.get(5).goalsFor;
        ar[51] = root.data.leagueTable.get(6).goalsFor;
        ar[52] = root.data.leagueTable.get(7).goalsFor;
        ar[53] = root.data.leagueTable.get(8).goalsFor;

        // adding goals against data to array
        ar[54] = root.data.leagueTable.get(0).goalsAgainst;
        ar[55] = root.data.leagueTable.get(1).goalsAgainst;
        ar[56] = root.data.leagueTable.get(2).goalsAgainst;
        ar[57] = root.data.leagueTable.get(3).goalsAgainst;
        ar[58] = root.data.leagueTable.get(4).goalsAgainst;
        ar[59] = root.data.leagueTable.get(5).goalsAgainst;
        ar[60] = root.data.leagueTable.get(6).goalsAgainst;
        ar[61] = root.data.leagueTable.get(7).goalsAgainst;
        ar[62] = root.data.leagueTable.get(8).goalsAgainst;

        // adding goal difference data to array
        ar[63] = root.data.leagueTable.get(0).goalsDifference;
        ar[64] = root.data.leagueTable.get(1).goalsDifference;
        ar[65] = root.data.leagueTable.get(2).goalsDifference;
        ar[66] = root.data.leagueTable.get(3).goalsDifference;
        ar[67] = root.data.leagueTable.get(4).goalsDifference;
        ar[68] = root.data.leagueTable.get(5).goalsDifference;
        ar[69] = root.data.leagueTable.get(6).goalsDifference;
        ar[70] = root.data.leagueTable.get(7).goalsDifference;
        ar[71] = root.data.leagueTable.get(8).goalsDifference;

        // adding points data to array
        ar[72] = root.data.leagueTable.get(0).points;
        ar[73] = root.data.leagueTable.get(1).points;
        ar[74] = root.data.leagueTable.get(2).points;
        ar[75] = root.data.leagueTable.get(3).points;
        ar[76] = root.data.leagueTable.get(4).points;
        ar[77] = root.data.leagueTable.get(5).points;
        ar[78] = root.data.leagueTable.get(6).points;
        ar[79] = root.data.leagueTable.get(7).points;
        ar[80] = root.data.leagueTable.get(8).points;



        // return array of Data objects, mixture of strings and ints converted from json
        return ar;
    }

    public Fetch(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    // this pushed the array of converted json data to the other activity
    @Override
    protected void onPostExecute(String[] ar) {
        delegate.doInBackground(ar);
    }
}
