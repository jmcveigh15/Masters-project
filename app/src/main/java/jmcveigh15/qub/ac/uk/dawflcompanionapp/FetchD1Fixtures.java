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
public class FetchD1Fixtures extends AsyncTask<Void, Void, ArrayList<String>> {
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
                if (root.data.get(i).competitionName.equals("DAWFL Division 1")) {
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
        }catch(IndexOutOfBoundsException n){
        }






        // try catch block in case json data updates to size too small to call
        // these use the gson object to get values from the json data

        // this gets data for row 1 of premier division fixtures
        /**
        try {
            ar[0] = root.data.get(0).homeTeam;
            ar[1] = root.data.get(0).awayTeam;
            ar[2] = root.data.get(0).venue;
            ar[3] = root.data.get(0).competitionName;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 2 of premier division fixtures
        try {
            ar[4] = root.data.get(1).homeTeam;
            ar[5] = root.data.get(1).awayTeam;
            ar[6] = root.data.get(1).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 3 of premier division fixtures
        try {
            ar[7] = root.data.get(2).homeTeam;
            ar[8] = root.data.get(2).awayTeam;
            ar[9] = root.data.get(2).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 4 of premier division fixtures
        try {
            ar[10] = root.data.get(3).homeTeam;
            ar[11] = root.data.get(3).awayTeam;
            ar[12] = root.data.get(3).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 5 of premier division fixtures
        try {
            ar[13] = root.data.get(4).homeTeam;
            ar[14] = root.data.get(4).awayTeam;
            ar[15] = root.data.get(4).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 6 of premier division fixtures
        try {
            ar[16] = root.data.get(5).homeTeam;
            ar[17] = root.data.get(5).awayTeam;
            ar[18] = root.data.get(5).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 7 of premier division fixtures
        try {
            ar[19] = root.data.get(6).homeTeam;
            ar[20] = root.data.get(6).awayTeam;
            ar[21] = root.data.get(6).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 8 of premier division fixtures
        try {
            ar[22] = root.data.get(7).homeTeam;
            ar[23] = root.data.get(7).awayTeam;
            ar[24] = root.data.get(7).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 9 of premier division fixtures
        try {
            ar[25] = root.data.get(8).homeTeam;
            ar[26] = root.data.get(8).awayTeam;
            ar[27] = root.data.get(8).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 10 of premier division fixtures
        try {
            ar[28] = root.data.get(9).homeTeam;
            ar[29] = root.data.get(9).awayTeam;
            ar[30] = root.data.get(9).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 11 of premier division fixtures
        try {
            ar[31] = root.data.get(10).homeTeam;
            ar[32] = root.data.get(10).awayTeam;
            ar[33] = root.data.get(10).venue;
        } catch (IndexOutOfBoundsException n) {
        }


        // this gets data for row 1 of division 1 fixtures
        try {
            ar[34] = root.data.get(11).homeTeam;
            ar[35] = root.data.get(11).awayTeam;
            ar[36] = root.data.get(11).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 2 of division 1 fixtures
        try {
            ar[37] = root.data.get(12).homeTeam;
            ar[38] = root.data.get(12).awayTeam;
            ar[39] = root.data.get(12).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 3 of division 1 fixtures
        try {
            ar[40] = root.data.get(13).homeTeam;
            ar[41] = root.data.get(13).awayTeam;
            ar[42] = root.data.get(13).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 4 of division 1 fixtures
        try {
            ar[43] = root.data.get(14).homeTeam;
            ar[44] = root.data.get(14).awayTeam;
            ar[45] = root.data.get(14).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 5 of division 1 fixtures
        try {
            ar[46] = root.data.get(15).homeTeam;
            ar[47] = root.data.get(15).awayTeam;
            ar[48] = root.data.get(15).venue;
        } catch (IndexOutOfBoundsException n) {
        }


        // this gets data for row 1 of division 2 fixtures
        try {
            ar[49] = root.data.get(16).homeTeam;
            ar[50] = root.data.get(16).awayTeam;
            ar[51] = root.data.get(16).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 2 of division 2 fixtures
        try {
            ar[52] = root.data.get(17).homeTeam;
            ar[53] = root.data.get(17).awayTeam;
            ar[54] = root.data.get(17).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 3 of division 2 fixtures
        try {
            ar[55] = root.data.get(18).homeTeam;
            ar[56] = root.data.get(18).awayTeam;
            ar[57] = root.data.get(18).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 1 of reserve 1 fixtures
        try {
            ar[58] = root.data.get(19).homeTeam;
            ar[59] = root.data.get(19).awayTeam;
            ar[60] = root.data.get(19).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 2 of reserve 1 fixtures
        try {
            ar[61] = root.data.get(20).homeTeam;
            ar[62] = root.data.get(20).awayTeam;
            ar[63] = root.data.get(20).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 3 of reserve 1 fixtures
        try {
            ar[64] = root.data.get(21).homeTeam;
            ar[65] = root.data.get(21).awayTeam;
            ar[66] = root.data.get(21).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 1 of reserve 2 fixtures
        try {
            ar[67] = root.data.get(22).homeTeam;
            ar[68] = root.data.get(22).awayTeam;
            ar[69] = root.data.get(22).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 2 of reserve 2 fixtures
        try {
            ar[70] = root.data.get(23).homeTeam;
            ar[71] = root.data.get(23).awayTeam;
            ar[72] = root.data.get(23).venue;
        } catch (IndexOutOfBoundsException n) {
        }

        // this gets data for row 3 of reserve 2 fixtures
        try {
            ar[73] = root.data.get(24).homeTeam;
            ar[74] = root.data.get(24).awayTeam;
            ar[75] = root.data.get(24).venue;
         //   if(ar[75].length()>16){

           // }
        } catch (IndexOutOfBoundsException n) {
        }

         **/

        // return array of Data objects, mixture of strings and ints converted from json
        return strings;
    }

    FetchD1Fixtures(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    // this pushed the array of converted json data to the other activity
    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        delegate.doInBackground(strings);
    }
}
