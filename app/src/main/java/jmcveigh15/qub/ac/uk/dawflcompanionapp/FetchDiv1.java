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
public class FetchDiv1 extends AsyncTask<Void, Void, String[]> {
    // this is where the raw json is held until Gson gets to it
    private String dataRead = "";

    // interface is needed for an asynctask to be referenced in another class
    public interface AsyncResponse {
        void doInBackground(String[] ar);
    }

    // initialise the interface object as delegate
    private AsyncResponse delegate = null;

    // this reads the json data from the internet and converts it to a java object
    @Override
    protected String[] doInBackground(Void... voids) {
        try {
            URL url = new URL(
                    "https://sportsmanager.ie/dataFeed/index.php?feedType=fixture&type=league_table&competition_id=131223");
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
        Root4 root = new Gson().fromJson(dataRead, Root4.class);

        // stored in an array to be returned to onPostExecute using delegate function
        String[] ar = new String[108];
        ArrayList<String> str = new ArrayList<>();

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
        ar[9] = root.data.leagueTable.get(9).team;
        ar[10] = root.data.leagueTable.get(10).team;
        ar[11] = root.data.leagueTable.get(11).team;

        // adding games played data to array
        ar[12] = root.data.leagueTable.get(0).played;
        ar[13] = root.data.leagueTable.get(1).played;
        ar[14] = root.data.leagueTable.get(2).played;
        ar[15] = root.data.leagueTable.get(3).played;
        ar[16] = root.data.leagueTable.get(4).played;
        ar[17] = root.data.leagueTable.get(5).played;
        ar[18] = root.data.leagueTable.get(6).played;
        ar[19] = root.data.leagueTable.get(7).played;
        ar[20] = root.data.leagueTable.get(8).played;
        ar[21] = root.data.leagueTable.get(9).played;
        ar[22] = root.data.leagueTable.get(10).played;
        ar[23] = root.data.leagueTable.get(11).played;

        // adding games won data to array
        ar[24] = root.data.leagueTable.get(0).gamesWon;
        ar[25] = root.data.leagueTable.get(1).gamesWon;
        ar[26] = root.data.leagueTable.get(2).gamesWon;
        ar[27] = root.data.leagueTable.get(3).gamesWon;
        ar[28] = root.data.leagueTable.get(4).gamesWon;
        ar[29] = root.data.leagueTable.get(5).gamesWon;
        ar[30] = root.data.leagueTable.get(6).gamesWon;
        ar[31] = root.data.leagueTable.get(7).gamesWon;
        ar[32] = root.data.leagueTable.get(8).gamesWon;
        ar[33] = root.data.leagueTable.get(9).gamesWon;
        ar[34] = root.data.leagueTable.get(10).gamesWon;
        ar[35] = root.data.leagueTable.get(11).gamesWon;

        // adding games drawn data to array
        ar[36] = root.data.leagueTable.get(0).gamesDraw;
        ar[37] = root.data.leagueTable.get(1).gamesDraw;
        ar[38] = root.data.leagueTable.get(2).gamesDraw;
        ar[39] = root.data.leagueTable.get(3).gamesDraw;
        ar[40] = root.data.leagueTable.get(4).gamesDraw;
        ar[41] = root.data.leagueTable.get(5).gamesDraw;
        ar[42] = root.data.leagueTable.get(6).gamesDraw;
        ar[43] = root.data.leagueTable.get(7).gamesDraw;
        ar[44] = root.data.leagueTable.get(8).gamesDraw;
        ar[45] = root.data.leagueTable.get(9).gamesDraw;
        ar[46] = root.data.leagueTable.get(10).gamesDraw;
        ar[47] = root.data.leagueTable.get(11).gamesDraw;

        // adding games lost data to array
        ar[48] = root.data.leagueTable.get(0).gameLost;
        ar[49] = root.data.leagueTable.get(1).gameLost;
        ar[50] = root.data.leagueTable.get(2).gameLost;
        ar[51] = root.data.leagueTable.get(3).gameLost;
        ar[52] = root.data.leagueTable.get(4).gameLost;
        ar[53] = root.data.leagueTable.get(5).gameLost;
        ar[54] = root.data.leagueTable.get(6).gameLost;
        ar[55] = root.data.leagueTable.get(7).gameLost;
        ar[56] = root.data.leagueTable.get(8).gameLost;
        ar[57] = root.data.leagueTable.get(9).gameLost;
        ar[58] = root.data.leagueTable.get(10).gameLost;
        ar[59] = root.data.leagueTable.get(11).gameLost;

        // adding goals for data to array
        ar[60] = root.data.leagueTable.get(0).goalsFor;
        ar[61] = root.data.leagueTable.get(1).goalsFor;
        ar[62] = root.data.leagueTable.get(2).goalsFor;
        ar[63] = root.data.leagueTable.get(3).goalsFor;
        ar[64] = root.data.leagueTable.get(4).goalsFor;
        ar[65] = root.data.leagueTable.get(5).goalsFor;
        ar[66] = root.data.leagueTable.get(6).goalsFor;
        ar[67] = root.data.leagueTable.get(7).goalsFor;
        ar[68] = root.data.leagueTable.get(8).goalsFor;
        ar[69] = root.data.leagueTable.get(9).goalsFor;
        ar[70] = root.data.leagueTable.get(10).goalsFor;
        ar[71] = root.data.leagueTable.get(11).goalsFor;

        // adding goals against data to array
        ar[72] = root.data.leagueTable.get(0).goalsAgainst;
        ar[73] = root.data.leagueTable.get(1).goalsAgainst;
        ar[74] = root.data.leagueTable.get(2).goalsAgainst;
        ar[75] = root.data.leagueTable.get(3).goalsAgainst;
        ar[76] = root.data.leagueTable.get(4).goalsAgainst;
        ar[77] = root.data.leagueTable.get(5).goalsAgainst;
        ar[78] = root.data.leagueTable.get(6).goalsAgainst;
        ar[79] = root.data.leagueTable.get(7).goalsAgainst;
        ar[80] = root.data.leagueTable.get(8).goalsAgainst;
        ar[81] = root.data.leagueTable.get(9).goalsAgainst;
        ar[82] = root.data.leagueTable.get(10).goalsAgainst;
        ar[83] = root.data.leagueTable.get(11).goalsAgainst;

        // adding goal difference data to array
        ar[84] = root.data.leagueTable.get(0).goalsDifference;
        ar[85] = root.data.leagueTable.get(1).goalsDifference;
        ar[86] = root.data.leagueTable.get(2).goalsDifference;
        ar[87] = root.data.leagueTable.get(3).goalsDifference;
        ar[88] = root.data.leagueTable.get(4).goalsDifference;
        ar[89] = root.data.leagueTable.get(5).goalsDifference;
        ar[90] = root.data.leagueTable.get(6).goalsDifference;
        ar[91] = root.data.leagueTable.get(7).goalsDifference;
        ar[92] = root.data.leagueTable.get(8).goalsDifference;
        ar[93] = root.data.leagueTable.get(9).goalsDifference;
        ar[94] = root.data.leagueTable.get(10).goalsDifference;
        ar[95] = root.data.leagueTable.get(11).goalsDifference;

        // adding points data to array
        ar[96] = root.data.leagueTable.get(0).points;
        ar[97] = root.data.leagueTable.get(1).points;
        ar[98] = root.data.leagueTable.get(2).points;
        ar[99] = root.data.leagueTable.get(3).points;
        ar[100] = root.data.leagueTable.get(4).points;
        ar[101] = root.data.leagueTable.get(5).points;
        ar[102] = root.data.leagueTable.get(6).points;
        ar[103] = root.data.leagueTable.get(7).points;
        ar[104] = root.data.leagueTable.get(8).points;
        ar[105] = root.data.leagueTable.get(9).points;
        ar[106] = root.data.leagueTable.get(10).points;
        ar[107] = root.data.leagueTable.get(11).points;



        // return array of Data objects, mixture of strings and ints converted from json
        return ar;
    }

    FetchDiv1(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    // this pushed the array of converted json data to the other activity
    @Override
    protected void onPostExecute(String[] ar) {
        delegate.doInBackground(ar);
    }
}
