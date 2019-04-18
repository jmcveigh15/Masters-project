package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

// this class is the front end of the reserve2 fixtures
// it shows parsed json data in a table using updated textViews
public class R2Fixtures extends AppCompatActivity implements Fetch2.AsyncResponse {
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
        setContentView(R.layout.activity_r2_fixtures);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new Fetch2(this).execute();
    }

    // this override brings the converted json to this activity
    // where they are set to values in the table
    @Override
    public void doInBackground(String[] ar) {
        // try catch block catches a crash if the array is null due to json size being reduced
        // which it is prone to doing as it is constantly updating especially towards the end of the season

        // setting 1st match row in Reserve 2
        try{
        homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
        homeTeam1TextView.setText((CharSequence) ar[67]);
        awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
        awayTeam1TextView.setText((CharSequence) ar[68]);
        venue1TextView = (TextView) findViewById(R.id.team_1_venue);
        venue1TextView.setText((CharSequence) ar[69]);
        } catch (NullPointerException e) {
            homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
            homeTeam1TextView.setText("Match played");
        }


        // setting 2nd match row in Reserve 2
        try {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText((CharSequence) ar[70]);
            awayTeam2TextView = (TextView) findViewById(R.id.team_2_away);
            awayTeam2TextView.setText((CharSequence) ar[71]);
            venue2TextView = (TextView) findViewById(R.id.team_2_venue);
            venue2TextView.setText((CharSequence) ar[72]);
        } catch (NullPointerException e) {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText("Match played");
        }


        /// setting 3rd match row in Reserve 2
        try{
        homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
        homeTeam3TextView.setText((CharSequence) ar[73]);
        awayTeam3TextView = (TextView) findViewById(R.id.team_3_away);
        awayTeam3TextView.setText((CharSequence) ar[74]);
        venue3TextView = (TextView) findViewById(R.id.team_3_venue);
        venue3TextView.setText((CharSequence) ar[75]);
        } catch (NullPointerException e) {
            homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam3TextView.setText("Match played");
        }
    }
}










