package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

// this class is the front end of the division 1 fixtures
// it shows parsed json data in a table using updated textViews
public class D1Fixtures extends AppCompatActivity implements Fetch2.AsyncResponse {
    // at the date of programming, there are 5 fixtures left but this is subject to become fewer as matches are played

    // homeTeam textViews
    private TextView homeTeam1TextView, homeTeam2TextView, homeTeam3TextView, homeTeam4TextView, homeTeam5TextView;

    // awayTeam textViews
    private TextView awayTeam1TextView, awayTeam2TextView, awayTeam3TextView, awayTeam4TextView, awayTeam5TextView;

    // venue textViews
    private TextView venue1TextView, venue2TextView, venue3TextView, venue4TextView, venue5TextView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d1_fixtures);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new Fetch2(this).execute();
    }

    // this override brings the converted json to this activity
    // where they are set to values in the table
    @Override
    public void doInBackground(String[] ar) {
        // try catch block catches a crash if the array is null due to json size being reduced
        // which it is prone to doing as it is constantly updating especially towards the end of the season

        // setting 1st match row in Division 1
        try{
        homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
        homeTeam1TextView.setText((CharSequence) ar[34]);
        awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
        awayTeam1TextView.setText((CharSequence) ar[35]);
        venue1TextView = (TextView) findViewById(R.id.team_1_venue);
        venue1TextView.setText((CharSequence) ar[36]);
        } catch (NullPointerException e) {
            homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
            homeTeam1TextView.setText("Match played");
        }


        // setting 2nd match row in Division 1
        try {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText((CharSequence) ar[37]);
            awayTeam2TextView = (TextView) findViewById(R.id.team_2_away);
            awayTeam2TextView.setText((CharSequence) ar[38]);
            venue2TextView = (TextView) findViewById(R.id.team_2_venue);
            venue2TextView.setText((CharSequence) ar[39]);
        } catch (NullPointerException e) {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText("Match played");
        }


        /// setting 3rd match row in Division 1
        try{
        homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
        homeTeam3TextView.setText((CharSequence) ar[40]);
        awayTeam3TextView = (TextView) findViewById(R.id.team_3_away);
        awayTeam3TextView.setText((CharSequence) ar[41]);
        venue3TextView = (TextView) findViewById(R.id.team_3_venue);
        venue3TextView.setText((CharSequence) ar[42]);
        } catch (NullPointerException e) {
            homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam3TextView.setText("Match played");
        }

        // setting 4th match row in Division 1
        try{
            homeTeam4TextView = (TextView) findViewById(R.id.team_4_home);
            homeTeam4TextView.setText((CharSequence) ar[43]);
            awayTeam4TextView = (TextView) findViewById(R.id.team_4_away);
            awayTeam4TextView.setText((CharSequence) ar[44]);
            venue4TextView = (TextView) findViewById(R.id.team_4_venue);
            venue4TextView.setText((CharSequence) ar[45]);
        } catch (NullPointerException e) {
            homeTeam4TextView = (TextView) findViewById(R.id.team_4_home);
            homeTeam4TextView.setText("Match played");
        }

        // setting 5th match row in Division 1
        try{
            homeTeam5TextView = (TextView) findViewById(R.id.team_5_home);
            homeTeam5TextView.setText((CharSequence) ar[46]);
            awayTeam5TextView = (TextView) findViewById(R.id.team_5_away);
            awayTeam5TextView.setText((CharSequence) ar[47]);
            venue5TextView = (TextView) findViewById(R.id.team_5_venue);
            venue5TextView.setText((CharSequence) ar[48]);
        } catch (NullPointerException e) {
            homeTeam5TextView = (TextView) findViewById(R.id.team_5_home);
            homeTeam5TextView.setText("Match played");
        }
    }
}










