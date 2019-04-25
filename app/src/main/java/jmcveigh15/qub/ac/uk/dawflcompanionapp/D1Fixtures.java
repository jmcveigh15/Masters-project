package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

// this class is the front end of the division 1 fixtures
// it shows parsed json data in a table using updated textViews
public class D1Fixtures extends AppCompatActivity implements FetchD1Fixtures.AsyncResponse, NavigationView.OnNavigationItemSelectedListener {
    // at the date of programming, there are 5 fixtures left but this is subject to become fewer as matches are played

    DrawerLayout mDrawerLayout;

    // homeTeam textViews
    private TextView homeTeam1TextView, homeTeam2TextView, homeTeam3TextView, homeTeam4TextView, homeTeam5TextView;

    // awayTeam textViews
    private TextView awayTeam1TextView, awayTeam2TextView, awayTeam3TextView, awayTeam4TextView, awayTeam5TextView;

    // venue textViews
    private TextView venue1TextView, venue2TextView, venue3TextView, venue4TextView, venue5TextView;

    // date textviews
    private TextView fixtureDate1, fixtureDate2, fixtureDate3, fixtureDate4, fixtureDate5;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d1_fixtures);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new FetchD1Fixtures(this).execute();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // this override brings the converted json to this activity

    // where they are set to values in the table

    @Override
    public void doInBackground(ArrayList<String> strings) {
        // try catch block catches a crash if the array is null due to json size being reduced
        // which it is prone to doing as it is constantly updating especially towards the end of the season

        String april24 = "1556127000";
        String april27 = "1556370000";
        String may1 = "1556731800";

        // setting first fixture row in prem division
        try {
            homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
            homeTeam1TextView.setText((CharSequence) strings.get(0));
            awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
            awayTeam1TextView.setText((CharSequence) strings.get(1));
            venue1TextView = (TextView) findViewById(R.id.team_1_venue);
            venue1TextView.setText((CharSequence) strings.get(2));
            fixtureDate1 = (TextView) findViewById(R.id.match_date_1);
            String date1 = strings.get(3);
            if (date1.equals(april24)) {
                date1 = "24/04";
            } else if (date1.equals(april27)) {
                date1 = "27/04";
            } else if (date1.equals(may1)) {
                date1 = "01/05";
            }
            fixtureDate1.setText(date1);
        } catch (IndexOutOfBoundsException e) {
            awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
            awayTeam1TextView.setText("All Matches played");
        }

        // setting second fixture row in prem division
        try {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText((CharSequence) strings.get(4));
            awayTeam2TextView = (TextView) findViewById(R.id.team_2_away);
            awayTeam2TextView.setText((CharSequence) strings.get(5));
            venue2TextView = (TextView) findViewById(R.id.team_2_venue);
            venue2TextView.setText((CharSequence) strings.get(6));
            fixtureDate2 = (TextView) findViewById(R.id.match_date_2);
            String date = strings.get(7);
            if (date.equals(april24)) {
                date = "24/04";
            } else if (date.equals(april27)) {
                date = "27/04";
            } else if (date.equals(may1)) {
                date = "01/05";
            }
            fixtureDate2.setText(date);
        } catch (IndexOutOfBoundsException e) {
        }

        // setting third fixture row in prem division
        try {
            homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam3TextView.setText((CharSequence) strings.get(8));
            awayTeam3TextView = (TextView) findViewById(R.id.team_3_away);
            awayTeam3TextView.setText((CharSequence) strings.get(9));
            venue3TextView = (TextView) findViewById(R.id.team_3_venue);
            venue3TextView.setText((CharSequence) strings.get(10));
            fixtureDate3 = (TextView) findViewById(R.id.match_date_3);
            String date = strings.get(11);
            if (date.equals(april24)) {
                date = "24/04";
            } else if (date.equals(april27)) {
                date = "27/04";
            } else if (date.equals(may1)) {
                date = "01/05";
            }
            fixtureDate3.setText(date);
        } catch (IndexOutOfBoundsException e) {
        }

        // setting 4th fixture row in prem division
        try {
            homeTeam4TextView = (TextView) findViewById(R.id.team_4_home);
            homeTeam4TextView.setText((CharSequence) strings.get(12));
            awayTeam4TextView = (TextView) findViewById(R.id.team_4_away);
            awayTeam4TextView.setText((CharSequence) strings.get(13));
            venue4TextView = (TextView) findViewById(R.id.team_4_venue);
            venue4TextView.setText((CharSequence) strings.get(14));
            fixtureDate4 = (TextView) findViewById(R.id.match_date_4);
            String date = strings.get(15);
            if (date.equals(april24)) {
                date = "24/04";
            } else if (date.equals(april27)) {
                date = "27/04";
            } else if (date.equals(may1)) {
                date = "01/05";
            }
            fixtureDate4.setText(date);
        } catch (IndexOutOfBoundsException e) {
        }

        // setting 5th fixture row in prem division
        try {
            homeTeam5TextView = (TextView) findViewById(R.id.team_5_home);
            homeTeam5TextView.setText((CharSequence) strings.get(16));
            awayTeam5TextView = (TextView) findViewById(R.id.team_5_away);
            awayTeam5TextView.setText((CharSequence) strings.get(17));
            venue5TextView = (TextView) findViewById(R.id.team_5_venue);
            venue5TextView.setText((CharSequence) strings.get(18));
            fixtureDate5 = (TextView) findViewById(R.id.match_date_5);
            String date = strings.get(19);
            if (date.equals(april24)) {
                date = "24/04";
            } else if (date.equals(april27)) {
                date = "27/04";
            } else if (date.equals(may1)) {
                date = "01/05";
            }
            fixtureDate5.setText(date);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_log_out:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_free_week:
                startActivity(new Intent(this, FreeWeek.class));
                finish();
                break;
            case R.id.nav_login_register:
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    startActivity(new Intent(this, Login.class));
                } else {
                    Toast.makeText(this, "Already logged in", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_pitch_location:
                startActivity(new Intent(this, MapsActivity.class));
                break;
            case R.id.nav_send_result:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, getString(R.string.result_instructions));
                i = Intent.createChooser(i, getString(R.string.send_result));
                startActivity(i);
                break;
            case R.id.nav_home:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_profile:
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    Toast.makeText(this, "Log in or register to view your profile", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, Profile.class));
                }
                break;
            case R.id.nav_forums:
                startActivity(new Intent(this, ForumMain.class));
                finish();
                break;
            case R.id.nav_gallery:
                startActivity(new Intent(this, GalleryMain.class));
                finish();
                break;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}










