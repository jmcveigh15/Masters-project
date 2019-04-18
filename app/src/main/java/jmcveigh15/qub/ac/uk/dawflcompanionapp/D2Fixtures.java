package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

// this class is the front end of the division 1 fixtures
// it shows parsed json data in a table using updated textViews
public class D2Fixtures extends AppCompatActivity implements Fetch2.AsyncResponse {
    // at the date of programming, there are 3 fixtures left but this is subject to become fewer as matches are played

    // homeTeam textViews
    private TextView homeTeam1TextView, homeTeam2TextView, homeTeam3TextView;

    // awayTeam textViews
    private TextView awayTeam1TextView, awayTeam2TextView, awayTeam3TextView;

    // venue textViews
    private TextView venue1TextView, venue2TextView, venue3TextView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2_fixtures);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new Fetch2(this).execute();
    }

    // this override brings the converted json to this activity
    // where they are set to values in the table
    @Override
    public void doInBackground(String[] ar) {
        // try catch block catches a crash if the array is null due to json size being reduced
        // which it is prone to doing as it is constantly updating especially towards the end of the season

        // setting 1st match row in Division 2
        try{
        homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
        homeTeam1TextView.setText((CharSequence) ar[49]);
        awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
        awayTeam1TextView.setText((CharSequence) ar[50]);
        venue1TextView = (TextView) findViewById(R.id.team_1_venue);
        venue1TextView.setText((CharSequence) ar[51]);
        } catch (NullPointerException e) {
            homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
            homeTeam1TextView.setText("Match played");
        }


        // setting 2nd match row in Division 2
        try {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText((CharSequence) ar[52]);
            awayTeam2TextView = (TextView) findViewById(R.id.team_2_away);
            awayTeam2TextView.setText((CharSequence) ar[53]);
            venue2TextView = (TextView) findViewById(R.id.team_2_venue);
            venue2TextView.setText((CharSequence) ar[54]);
        } catch (NullPointerException e) {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText("Match played");
        }


        /// setting 3rd match row in Division 2
        try{
        homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
        homeTeam3TextView.setText((CharSequence) ar[55]);
        awayTeam3TextView = (TextView) findViewById(R.id.team_3_away);
        awayTeam3TextView.setText((CharSequence) ar[56]);
        venue3TextView = (TextView) findViewById(R.id.team_3_venue);
        venue3TextView.setText((CharSequence) ar[57]);
        } catch (NullPointerException e) {
            homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam3TextView.setText("Match played");
        }
    }
}










