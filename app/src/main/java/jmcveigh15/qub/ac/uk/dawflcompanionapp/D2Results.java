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

// this class is the front end of the d2 fixtures
// it shows parsed json data in a table using updated textViews
public class D2Results extends AppCompatActivity implements FetchD2Results.AsyncResponse, NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;

    // homeTeam textViews
    private TextView homeTeam1TextView, homeTeam2TextView, homeTeam3TextView, homeTeam4TextView, homeTeam5TextView,
            homeTeam6TextView, homeTeam7TextView, homeTeam8TextView, homeTeam9TextView, homeTeam10TextView;

    // awayTeam textViews
    private TextView awayTeam1TextView, awayTeam2TextView, awayTeam3TextView, awayTeam4TextView, awayTeam5TextView,
            awayTeam6TextView, awayTeam7TextView, awayTeam8TextView, awayTeam9TextView, awayTeam10TextView;

    // homeTeamScore textViews
    private TextView homeTeam1ScoreTextView, homeTeam2ScoreTextView, homeTeam3ScoreTextView,
            homeTeam4ScoreTextView, homeTeam5ScoreTextView, homeTeam6ScoreTextView, homeTeam7ScoreTextView, homeTeam8ScoreTextView,
            homeTeam9ScoreTextView, homeTeam10ScoreTextView;

    // date textviews
    private TextView fixtureDate1, fixtureDate2, fixtureDate3, fixtureDate4, fixtureDate5, fixtureDate6, fixtureDate7,
            fixtureDate8, fixtureDate9, fixtureDate10;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2_results);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new FetchD2Results(this).execute();

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
    public void doInBackground(ArrayList<String> ar) {
        // try catch block catches a crash if the array is null due to json size being reduced
        // which it is prone to doing as it is constantly updating especially towards the end of the season

        String march_30 = "1553954400";
        String april_3 = "1554311700";
        String april_6 = "1554555600";
        String april_10 = "1554916500";
        String april_13 = "1555160400";
        String april_17 = "1555522200";
        String april_20 = "1555765200";
        String april_24 = "1556127000";
        String april_27 = "1556370000";
        String may_1 = "1556731800";

        // setting first result row in d2 division
        try {
            homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
            homeTeam1TextView.setText((CharSequence) ar.get(36));
            awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
            awayTeam1TextView.setText((CharSequence) ar.get(37));
            homeTeam1ScoreTextView = (TextView) findViewById(R.id.result_1);
            homeTeam1ScoreTextView.setText((CharSequence) ar.get(38));
            fixtureDate1 = (TextView) findViewById(R.id.match_1_date);
            String date1 = ar.get(39);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate1.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        // setting 2nd result row in d2 division
        try {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText((CharSequence) ar.get(32));
            awayTeam2TextView = (TextView) findViewById(R.id.team_2_away);
            awayTeam2TextView.setText((CharSequence) ar.get(33));
            homeTeam2ScoreTextView = (TextView) findViewById(R.id.result_2);
            homeTeam2ScoreTextView.setText((CharSequence) ar.get(34));
            fixtureDate2 = (TextView) findViewById(R.id.match_2_date);
            String date1 = ar.get(35);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate2.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam3TextView.setText((CharSequence) ar.get(28));
            awayTeam3TextView = (TextView) findViewById(R.id.team_3_away);
            awayTeam3TextView.setText((CharSequence) ar.get(29));
            homeTeam3ScoreTextView = (TextView) findViewById(R.id.result_3);
            homeTeam3ScoreTextView.setText((CharSequence) ar.get(30));
            fixtureDate3 = (TextView) findViewById(R.id.match_3_date);
            String date1 = ar.get(31);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate3.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam4TextView = (TextView) findViewById(R.id.team_4_home);
            homeTeam4TextView.setText((CharSequence) ar.get(24));
            awayTeam4TextView = (TextView) findViewById(R.id.team_4_away);
            awayTeam4TextView.setText((CharSequence) ar.get(25));
            homeTeam4ScoreTextView = (TextView) findViewById(R.id.result_4);
            homeTeam4ScoreTextView.setText((CharSequence) ar.get(26));
            fixtureDate4 = (TextView) findViewById(R.id.match_4_date);
            String date1 = ar.get(27);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate4.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam5TextView = (TextView) findViewById(R.id.team_5_home);
            homeTeam5TextView.setText((CharSequence) ar.get(20));
            awayTeam5TextView = (TextView) findViewById(R.id.team_5_away);
            awayTeam5TextView.setText((CharSequence) ar.get(21));
            homeTeam5ScoreTextView = (TextView) findViewById(R.id.result_5);
            homeTeam5ScoreTextView.setText((CharSequence) ar.get(22));
            fixtureDate5 = (TextView) findViewById(R.id.match_5_date);
            String date1 = ar.get(23);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate5.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam6TextView = (TextView) findViewById(R.id.team_6_home);
            homeTeam6TextView.setText((CharSequence) ar.get(16));
            awayTeam6TextView = (TextView) findViewById(R.id.team_6_away);
            awayTeam6TextView.setText((CharSequence) ar.get(17));
            homeTeam6ScoreTextView = (TextView) findViewById(R.id.result_6);
            homeTeam6ScoreTextView.setText((CharSequence) ar.get(18));
            fixtureDate6 = (TextView) findViewById(R.id.match_6_date);
            String date1 = ar.get(19);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate6.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam7TextView = (TextView) findViewById(R.id.team_7_home);
            homeTeam7TextView.setText((CharSequence) ar.get(12));
            awayTeam7TextView = (TextView) findViewById(R.id.team_7_away);
            awayTeam7TextView.setText((CharSequence) ar.get(13));
            homeTeam7ScoreTextView = (TextView) findViewById(R.id.result_7);
            homeTeam7ScoreTextView.setText((CharSequence) ar.get(14));
            fixtureDate7 = (TextView) findViewById(R.id.match_7_date);
            String date1 = ar.get(15);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate7.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam8TextView = (TextView) findViewById(R.id.team_8_home);
            homeTeam8TextView.setText((CharSequence) ar.get(8));
            awayTeam8TextView = (TextView) findViewById(R.id.team_8_away);
            awayTeam8TextView.setText((CharSequence) ar.get(9));
            homeTeam8ScoreTextView = (TextView) findViewById(R.id.result_8);
            homeTeam8ScoreTextView.setText((CharSequence) ar.get(10));
            fixtureDate8 = (TextView) findViewById(R.id.match_8_date);
            String date1 = ar.get(11);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate8.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam9TextView = (TextView) findViewById(R.id.team_9_home);
            homeTeam9TextView.setText((CharSequence) ar.get(4));
            awayTeam9TextView = (TextView) findViewById(R.id.team_9_away);
            awayTeam9TextView.setText((CharSequence) ar.get(5));
            homeTeam9ScoreTextView = (TextView) findViewById(R.id.result_9);
            homeTeam9ScoreTextView.setText((CharSequence) ar.get(6));
            fixtureDate9 = (TextView) findViewById(R.id.match_9_date);
            String date1 = ar.get(7);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate9.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam10TextView = (TextView) findViewById(R.id.team_10_home);
            homeTeam10TextView.setText((CharSequence) ar.get(0));
            awayTeam10TextView = (TextView) findViewById(R.id.team_10_away);
            awayTeam10TextView.setText((CharSequence) ar.get(1));
            homeTeam10ScoreTextView = (TextView) findViewById(R.id.result_10);
            homeTeam10ScoreTextView.setText((CharSequence) ar.get(2));
            fixtureDate10 = (TextView) findViewById(R.id.match_10_date);
            String date1 = ar.get(3);
            if (date1.equals(april_24)) {
                date1 = "24/04";
            } else if (date1.equals(april_27)) {
                date1 = "27/04";
            } else if (date1.equals(may_1)) {
                date1 = "01/05";
            } else if (date1.equals(march_30)) {
                date1 = "30/03";
            } else if (date1.equals(april_3)) {
                date1 = "03/04";
            } else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            } else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            } else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate10.setText(date1);
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










