package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

// this class is the front end of the premier league fixtures
// it shows parsed json data in a table using updated textViews
public class PremFixtures extends AppCompatActivity implements Fetch2.AsyncResponse {
    // at the date of programming, there are 11 fixtures left but this is subject to become fewer as matches are played

    // homeTeam textViews
    private TextView homeTeam1TextView, homeTeam2TextView, homeTeam3TextView, homeTeam4TextView, homeTeam5TextView,
            homeTeam6TextView, homeTeam7TextView, homeTeam8TextView, homeTeam9TextView, homeTeam10TextView,
            homeTeam11TextView;

    // awayTeam textViews
    private TextView awayTeam1TextView, awayTeam2TextView, awayTeam3TextView, awayTeam4TextView, awayTeam5TextView,
    awayTeam6TextView,awayTeam7TextView,awayTeam8TextView,awayTeam9TextView,awayTeam10TextView,
    awayTeam11TextView;

    // venue textViews
    private TextView venue1TextView, venue2TextView, venue3TextView, venue4TextView, venue5TextView,
    venue6TextView,venue7TextView,venue8TextView,venue9TextView,venue10TextView,
    venue11TextView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new Fetch2(this).execute();
    }

    // this override brings the converted json to this activity
    // where they are set to values in the table
    @Override
    public void doInBackground(String[] ar) {
        // try catch block catches a crash if the array is null due to json size being reduced
        // which it is prone to doing as it is constantly updating especially towards the end of the season

        // setting first match row in prem division
        try{
        homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
        homeTeam1TextView.setText((CharSequence) ar[0]);
        awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
        awayTeam1TextView.setText((CharSequence) ar[1]);
        venue1TextView = (TextView) findViewById(R.id.team_1_venue);
        venue1TextView.setText((CharSequence) ar[2]);
        } catch (NullPointerException e) {
            homeTeam1TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam1TextView.setText("Match played");
        }


        // setting second match row in prem division
        try {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText((CharSequence) ar[4]);
            awayTeam2TextView = (TextView) findViewById(R.id.team_2_away);
            awayTeam2TextView.setText((CharSequence) ar[5]);
            venue2TextView = (TextView) findViewById(R.id.team_2_venue);
            venue2TextView.setText((CharSequence) ar[6]);
        } catch (NullPointerException e) {
            homeTeam2TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam2TextView.setText("Match played");
        }


        // setting third match row in prem division
        try{
        homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
        homeTeam3TextView.setText((CharSequence) ar[7]);
        awayTeam3TextView = (TextView) findViewById(R.id.team_3_away);
        awayTeam3TextView.setText((CharSequence) ar[8]);
        venue3TextView = (TextView) findViewById(R.id.team_3_venue);
        venue3TextView.setText((CharSequence) ar[9]);
        } catch (NullPointerException e) {
            homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam3TextView.setText("Match played");
        }

        // setting fourth match row in prem division
        try{
            homeTeam4TextView = (TextView) findViewById(R.id.team_4_home);
            homeTeam4TextView.setText((CharSequence) ar[10]);
            awayTeam4TextView = (TextView) findViewById(R.id.team_4_away);
            awayTeam4TextView.setText((CharSequence) ar[11]);
            venue4TextView = (TextView) findViewById(R.id.team_4_venue);
            venue4TextView.setText((CharSequence) ar[12]);
        } catch (NullPointerException e) {
            homeTeam4TextView = (TextView) findViewById(R.id.team_4_home);
            homeTeam4TextView.setText("Match played");
        }

        // setting fifth match row in prem division
        try{
            homeTeam5TextView = (TextView) findViewById(R.id.team_5_home);
            homeTeam5TextView.setText((CharSequence) ar[13]);
            awayTeam5TextView = (TextView) findViewById(R.id.team_5_away);
            awayTeam5TextView.setText((CharSequence) ar[14]);
            venue5TextView = (TextView) findViewById(R.id.team_5_venue);
            venue5TextView.setText((CharSequence) ar[15]);
        } catch (NullPointerException e) {
            homeTeam5TextView = (TextView) findViewById(R.id.team_5_home);
            homeTeam5TextView.setText("Match played");
        }

        // setting sixth match row in prem division
        try{
            homeTeam6TextView = (TextView) findViewById(R.id.team_6_home);
            homeTeam6TextView.setText((CharSequence) ar[16]);
            awayTeam6TextView = (TextView) findViewById(R.id.team_6_away);
            awayTeam6TextView.setText((CharSequence) ar[17]);
            venue6TextView = (TextView) findViewById(R.id.team_6_venue);
            venue6TextView.setText((CharSequence) ar[18]);
        } catch (NullPointerException e) {
            homeTeam6TextView = (TextView) findViewById(R.id.team_6_home);
            homeTeam6TextView.setText("Match played");
        }

        // setting seventh match row in prem division
        try{
            homeTeam7TextView = (TextView) findViewById(R.id.team_7_home);
            homeTeam7TextView.setText((CharSequence) ar[19]);
            awayTeam7TextView = (TextView) findViewById(R.id.team_7_away);
            awayTeam7TextView.setText((CharSequence) ar[20]);
            venue7TextView = (TextView) findViewById(R.id.team_7_venue);
            venue7TextView.setText((CharSequence) ar[21]);
        } catch (NullPointerException e) {
            homeTeam7TextView = (TextView) findViewById(R.id.team_7_home);
            homeTeam7TextView.setText("Match played");
        }

        // setting 8th match row in prem division
        try{
            homeTeam8TextView = (TextView) findViewById(R.id.team_8_home);
            homeTeam8TextView.setText((CharSequence) ar[22]);
            awayTeam8TextView = (TextView) findViewById(R.id.team_8_away);
            awayTeam8TextView.setText((CharSequence) ar[23]);
            venue8TextView = (TextView) findViewById(R.id.team_8_venue);
            venue8TextView.setText((CharSequence) ar[24]);
        } catch (NullPointerException e) {
            homeTeam8TextView = (TextView) findViewById(R.id.team_8_home);
            homeTeam8TextView.setText("Match played");
        }

        // setting 9th match row in prem division
        try{
            homeTeam9TextView = (TextView) findViewById(R.id.team_9_home);
            homeTeam9TextView.setText((CharSequence) ar[25]);
            awayTeam9TextView = (TextView) findViewById(R.id.team_9_away);
            awayTeam9TextView.setText((CharSequence) ar[26]);
            venue9TextView = (TextView) findViewById(R.id.team_9_venue);
            venue9TextView.setText((CharSequence) ar[27]);
        } catch (NullPointerException e) {
            homeTeam9TextView = (TextView) findViewById(R.id.team_9_home);
            homeTeam9TextView.setText("Match played");
        }

        // setting 10th match row in prem division
        try{
            homeTeam10TextView = (TextView) findViewById(R.id.team_10_home);
            homeTeam10TextView.setText((CharSequence) ar[28]);
            awayTeam10TextView = (TextView) findViewById(R.id.team_10_away);
            awayTeam10TextView.setText((CharSequence) ar[29]);
            venue10TextView = (TextView) findViewById(R.id.team_10_venue);
            venue10TextView.setText((CharSequence) ar[30]);
        } catch (NullPointerException e) {
            homeTeam10TextView = (TextView) findViewById(R.id.team_10_home);
            homeTeam10TextView.setText("Match played");
        }

        // setting 11th match row in prem division
        try{
            homeTeam11TextView = (TextView) findViewById(R.id.team_11_home);
            homeTeam11TextView.setText((CharSequence) ar[31]);
            awayTeam11TextView = (TextView) findViewById(R.id.team_11_away);
            awayTeam11TextView.setText((CharSequence) ar[32]);
            venue11TextView = (TextView) findViewById(R.id.team_11_venue);
            venue11TextView.setText((CharSequence) ar[33]);
        } catch (NullPointerException e) {
            homeTeam11TextView = (TextView) findViewById(R.id.team_11_home);
            homeTeam11TextView.setText("Match played");
        }
    }
}










