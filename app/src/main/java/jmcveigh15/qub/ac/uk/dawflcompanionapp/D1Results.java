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

// this class is the front end of the premier league results
// it shows parsed json data in a table using updated textViews
public class D1Results extends AppCompatActivity implements FetchD1Results.AsyncResponse, NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;

    // homeTeam textViews
    private TextView
            homeTeam11TextView, homeTeam12TextView, homeTeam13TextView, homeTeam14TextView, homeTeam15TextView, homeTeam16TextView,
            homeTeam17TextView, homeTeam18TextView, homeTeam19TextView, homeTeam20TextView;

    // awayTeam textViews
    private TextView
            awayTeam11TextView, awayTeam12TextView, awayTeam13TextView, awayTeam14TextView, awayTeam15TextView, awayTeam16TextView,
            awayTeam17TextView, awayTeam18TextView, awayTeam19TextView, awayTeam20TextView;

    // homeTeamScore textViews
    private TextView homeTeam11ScoreTextView, homeTeam12ScoreTextView, homeTeam13ScoreTextView,
            homeTeam14ScoreTextView, homeTeam15ScoreTextView, homeTeam16ScoreTextView, homeTeam17ScoreTextView, homeTeam18ScoreTextView,
            homeTeam19ScoreTextView, homeTeam20ScoreTextView;

    // date textviews
    private TextView fixtureDate11, fixtureDate12, fixtureDate13, fixtureDate14, fixtureDate15,
            fixtureDate16, fixtureDate17, fixtureDate18, fixtureDate19, fixtureDate20;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d1_results);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new FetchD1Results(this).execute();

        // assign nav bar
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

        // assign long dates to strings
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

        // rows 1-10 removed as not used by decreasing json file size


        // try catch block catches a crash if the array is null due to json size being reduced
        // which it is prone to doing as it is constantly updating especially towards the end of the season
        // assign values in json data array to textviews
        try {
            homeTeam11TextView = (TextView) findViewById(R.id.team_11_home);
            homeTeam11TextView.setText((CharSequence) ar.get(60));
            awayTeam11TextView = (TextView) findViewById(R.id.team_11_away);
            awayTeam11TextView.setText((CharSequence) ar.get(61));
            homeTeam11ScoreTextView = (TextView) findViewById(R.id.result_11);
            homeTeam11ScoreTextView.setText((CharSequence) ar.get(62));
            fixtureDate11 = (TextView) findViewById(R.id.match_11_date);
            String date1 = ar.get(63);
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
            fixtureDate11.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam12TextView = (TextView) findViewById(R.id.team_12_home);
            homeTeam12TextView.setText((CharSequence) ar.get(56));
            awayTeam12TextView = (TextView) findViewById(R.id.team_12_away);
            awayTeam12TextView.setText((CharSequence) ar.get(57));
            homeTeam12ScoreTextView = (TextView) findViewById(R.id.result_12);
            homeTeam12ScoreTextView.setText((CharSequence) ar.get(58));
            fixtureDate12 = (TextView) findViewById(R.id.match_12_date);
            String date1 = ar.get(59);
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
            fixtureDate12.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam13TextView = (TextView) findViewById(R.id.team_13_home);
            homeTeam13TextView.setText((CharSequence) ar.get(52));
            awayTeam13TextView = (TextView) findViewById(R.id.team_13_away);
            awayTeam13TextView.setText((CharSequence) ar.get(53));
            homeTeam13ScoreTextView = (TextView) findViewById(R.id.result_13);
            homeTeam13ScoreTextView.setText((CharSequence) ar.get(54));
            fixtureDate13 = (TextView) findViewById(R.id.match_13_date);
            String date1 = ar.get(55);
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
            fixtureDate13.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam14TextView = (TextView) findViewById(R.id.team_14_home);
            homeTeam14TextView.setText((CharSequence) ar.get(48));
            awayTeam14TextView = (TextView) findViewById(R.id.team_14_away);
            awayTeam14TextView.setText((CharSequence) ar.get(49));
            homeTeam14ScoreTextView = (TextView) findViewById(R.id.result_14);
            homeTeam14ScoreTextView.setText((CharSequence) ar.get(50));
            fixtureDate14 = (TextView) findViewById(R.id.match_14_date);
            String date1 = ar.get(51);
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
            fixtureDate14.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam15TextView = (TextView) findViewById(R.id.team_15_home);
            homeTeam15TextView.setText((CharSequence) ar.get(44));
            awayTeam15TextView = (TextView) findViewById(R.id.team_15_away);
            awayTeam15TextView.setText((CharSequence) ar.get(45));
            homeTeam15ScoreTextView = (TextView) findViewById(R.id.result_15);
            homeTeam15ScoreTextView.setText((CharSequence) ar.get(46));
            fixtureDate15 = (TextView) findViewById(R.id.match_15_date);
            String date1 = ar.get(47);
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
            fixtureDate15.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }


        try {
            homeTeam16TextView = (TextView) findViewById(R.id.team_16_home);
            homeTeam16TextView.setText((CharSequence) ar.get(40));
            awayTeam16TextView = (TextView) findViewById(R.id.team_16_away);
            awayTeam16TextView.setText((CharSequence) ar.get(41));
            homeTeam16ScoreTextView = (TextView) findViewById(R.id.result_16);
            homeTeam16ScoreTextView.setText((CharSequence) ar.get(42));
            fixtureDate16 = (TextView) findViewById(R.id.match_16_date);
            String date1 = ar.get(43);
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
            fixtureDate16.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam17TextView = (TextView) findViewById(R.id.team_17_home);
            homeTeam17TextView.setText((CharSequence) ar.get(36));
            awayTeam17TextView = (TextView) findViewById(R.id.team_17_away);
            awayTeam17TextView.setText((CharSequence) ar.get(37));
            homeTeam17ScoreTextView = (TextView) findViewById(R.id.result_17);
            homeTeam17ScoreTextView.setText((CharSequence) ar.get(38));
            fixtureDate17 = (TextView) findViewById(R.id.match_17_date);
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
            fixtureDate17.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam18TextView = (TextView) findViewById(R.id.team_18_home);
            homeTeam18TextView.setText((CharSequence) ar.get(32));
            awayTeam18TextView = (TextView) findViewById(R.id.team_18_away);
            awayTeam18TextView.setText((CharSequence) ar.get(33));
            homeTeam18ScoreTextView = (TextView) findViewById(R.id.result_18);
            homeTeam18ScoreTextView.setText((CharSequence) ar.get(34));
            fixtureDate18 = (TextView) findViewById(R.id.match_18_date);
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
            fixtureDate18.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam19TextView = (TextView) findViewById(R.id.team_19_home);
            homeTeam19TextView.setText((CharSequence) ar.get(28));
            awayTeam19TextView = (TextView) findViewById(R.id.team_19_away);
            awayTeam19TextView.setText((CharSequence) ar.get(29));
            homeTeam19ScoreTextView = (TextView) findViewById(R.id.result_19);
            homeTeam19ScoreTextView.setText((CharSequence) ar.get(30));
            fixtureDate19 = (TextView) findViewById(R.id.match_19_date);
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
            fixtureDate19.setText(date1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            homeTeam20TextView = (TextView) findViewById(R.id.team_20_home);
            homeTeam20TextView.setText((CharSequence) ar.get(24));
            awayTeam20TextView = (TextView) findViewById(R.id.team_20_away);
            awayTeam20TextView.setText((CharSequence) ar.get(25));
            homeTeam20ScoreTextView = (TextView) findViewById(R.id.result_20);
            homeTeam20ScoreTextView.setText((CharSequence) ar.get(26));
            fixtureDate20 = (TextView) findViewById(R.id.match_20_date);
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
            fixtureDate20.setText(date1);
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










