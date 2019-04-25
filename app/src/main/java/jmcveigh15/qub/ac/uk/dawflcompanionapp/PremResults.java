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

// this class is the front end of the premier league fixtures
// it shows parsed json data in a table using updated textViews
public class PremResults extends AppCompatActivity implements Fetch3.AsyncResponse, NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;

    // homeTeam textViews
    private TextView homeTeam1TextView, homeTeam2TextView, homeTeam3TextView, homeTeam4TextView, homeTeam5TextView,
            homeTeam6TextView, homeTeam7TextView, homeTeam8TextView, homeTeam9TextView, homeTeam10TextView,
            homeTeam11TextView, homeTeam12TextView, homeTeam13TextView, homeTeam14TextView, homeTeam15TextView, homeTeam16TextView,
            homeTeam17TextView, homeTeam18TextView, homeTeam19TextView, homeTeam20TextView, homeTeam21TextView,
            homeTeam22TextView, homeTeam23TextView, homeTeam24TextView, homeTeam25TextView;

    // awayTeam textViews
    private TextView awayTeam1TextView, awayTeam2TextView, awayTeam3TextView, awayTeam4TextView, awayTeam5TextView,
            awayTeam6TextView, awayTeam7TextView, awayTeam8TextView, awayTeam9TextView, awayTeam10TextView,
            awayTeam11TextView, awayTeam12TextView, awayTeam13TextView, awayTeam14TextView, awayTeam15TextView, awayTeam16TextView,
            awayTeam17TextView, awayTeam18TextView, awayTeam19TextView, awayTeam20TextView, awayTeam21TextView,
            awayTeam22TextView, awayTeam23TextView, awayTeam24TextView, awayTeam25TextView;

    // homeTeamScore textViews
    private TextView homeTeam1ScoreTextView, homeTeam2ScoreTextView, homeTeam3ScoreTextView,
            homeTeam4ScoreTextView, homeTeam5ScoreTextView, homeTeam6ScoreTextView, homeTeam7ScoreTextView, homeTeam8ScoreTextView,
            homeTeam9ScoreTextView, homeTeam10ScoreTextView, homeTeam11ScoreTextView, homeTeam12ScoreTextView, homeTeam13ScoreTextView,
            homeTeam14ScoreTextView, homeTeam15ScoreTextView, homeTeam16ScoreTextView, homeTeam17ScoreTextView, homeTeam18ScoreTextView,
            homeTeam19ScoreTextView, homeTeam20ScoreTextView, homeTeam21ScoreTextView, homeTeam22ScoreTextView, homeTeam23ScoreTextView,
            homeTeam24ScoreTextView, homeTeam25ScoreTextView;

    private TextView fixtureDate1, fixtureDate2, fixtureDate3, fixtureDate4, fixtureDate5, fixtureDate6, fixtureDate7,
            fixtureDate8, fixtureDate9,fixtureDate10, fixtureDate11, fixtureDate12, fixtureDate13, fixtureDate14, fixtureDate15,
            fixtureDate16,fixtureDate17, fixtureDate18,fixtureDate19, fixtureDate20;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prem_results);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new Fetch3(this).execute();

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

        // setting first result row in prem division
        try {
            homeTeam1TextView = (TextView) findViewById(R.id.team_1_home);
            homeTeam1TextView.setText((CharSequence) ar.get(100));
            awayTeam1TextView = (TextView) findViewById(R.id.team_1_away);
            awayTeam1TextView.setText((CharSequence) ar.get(101));
            homeTeam1ScoreTextView = (TextView) findViewById(R.id.result_1);
            homeTeam1ScoreTextView.setText((CharSequence) ar.get(102));
            fixtureDate1 = (TextView) findViewById(R.id.match_1_date);
            String date1 = ar.get(103);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate1.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        // setting 2nd result row in prem division
        try {
            homeTeam2TextView = (TextView) findViewById(R.id.team_2_home);
            homeTeam2TextView.setText((CharSequence) ar.get(96));
            awayTeam2TextView = (TextView) findViewById(R.id.team_2_away);
            awayTeam2TextView.setText((CharSequence) ar.get(97));
            homeTeam2ScoreTextView = (TextView) findViewById(R.id.result_2);
            homeTeam2ScoreTextView.setText((CharSequence) ar.get(98));
            fixtureDate2 = (TextView) findViewById(R.id.match_2_date);
            String date1 = ar.get(99);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate2.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam3TextView = (TextView) findViewById(R.id.team_3_home);
            homeTeam3TextView.setText((CharSequence) ar.get(92));
            awayTeam3TextView = (TextView) findViewById(R.id.team_3_away);
            awayTeam3TextView.setText((CharSequence) ar.get(93));
            homeTeam3ScoreTextView = (TextView) findViewById(R.id.result_3);
            homeTeam3ScoreTextView.setText((CharSequence) ar.get(94));
            fixtureDate3 = (TextView) findViewById(R.id.match_3_date);
            String date1 = ar.get(95);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate3.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam4TextView = (TextView) findViewById(R.id.team_4_home);
            homeTeam4TextView.setText((CharSequence) ar.get(88));
            awayTeam4TextView = (TextView) findViewById(R.id.team_4_away);
            awayTeam4TextView.setText((CharSequence) ar.get(89));
            homeTeam4ScoreTextView = (TextView) findViewById(R.id.result_4);
            homeTeam4ScoreTextView.setText((CharSequence) ar.get(90));
            fixtureDate4 = (TextView) findViewById(R.id.match_4_date);
            String date1 = ar.get(91);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate4.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam5TextView = (TextView) findViewById(R.id.team_5_home);
            homeTeam5TextView.setText((CharSequence) ar.get(84));
            awayTeam5TextView = (TextView) findViewById(R.id.team_5_away);
            awayTeam5TextView.setText((CharSequence) ar.get(85));
            homeTeam5ScoreTextView = (TextView) findViewById(R.id.result_5);
            homeTeam5ScoreTextView.setText((CharSequence) ar.get(86));
            fixtureDate5 = (TextView) findViewById(R.id.match_5_date);
            String date1 = ar.get(87);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate5.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam6TextView = (TextView) findViewById(R.id.team_6_home);
            homeTeam6TextView.setText((CharSequence) ar.get(80));
            awayTeam6TextView = (TextView) findViewById(R.id.team_6_away);
            awayTeam6TextView.setText((CharSequence) ar.get(81));
            homeTeam6ScoreTextView = (TextView) findViewById(R.id.result_6);
            homeTeam6ScoreTextView.setText((CharSequence) ar.get(82));
            fixtureDate6 = (TextView) findViewById(R.id.match_6_date);
            String date1 = ar.get(83);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate6.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam7TextView = (TextView) findViewById(R.id.team_7_home);
            homeTeam7TextView.setText((CharSequence) ar.get(76));
            awayTeam7TextView = (TextView) findViewById(R.id.team_7_away);
            awayTeam7TextView.setText((CharSequence) ar.get(77));
            homeTeam7ScoreTextView = (TextView) findViewById(R.id.result_7);
            homeTeam7ScoreTextView.setText((CharSequence) ar.get(78));
            fixtureDate7 = (TextView) findViewById(R.id.match_7_date);
            String date1 = ar.get(79);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate7.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam8TextView = (TextView) findViewById(R.id.team_8_home);
            homeTeam8TextView.setText((CharSequence) ar.get(72));
            awayTeam8TextView = (TextView) findViewById(R.id.team_8_away);
            awayTeam8TextView.setText((CharSequence) ar.get(73));
            homeTeam8ScoreTextView = (TextView) findViewById(R.id.result_8);
            homeTeam8ScoreTextView.setText((CharSequence) ar.get(74));
            fixtureDate8 = (TextView) findViewById(R.id.match_8_date);
            String date1 = ar.get(75);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate8.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam9TextView = (TextView) findViewById(R.id.team_9_home);
            homeTeam9TextView.setText((CharSequence) ar.get(68));
            awayTeam9TextView = (TextView) findViewById(R.id.team_9_away);
            awayTeam9TextView.setText((CharSequence) ar.get(69));
            homeTeam9ScoreTextView = (TextView) findViewById(R.id.result_9);
            homeTeam9ScoreTextView.setText((CharSequence) ar.get(70));
            fixtureDate9 = (TextView) findViewById(R.id.match_9_date);
            String date1 = ar.get(71);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate9.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

        try {
            homeTeam10TextView = (TextView) findViewById(R.id.team_10_home);
            homeTeam10TextView.setText((CharSequence) ar.get(64));
            awayTeam10TextView = (TextView) findViewById(R.id.team_10_away);
            awayTeam10TextView.setText((CharSequence) ar.get(65));
            homeTeam10ScoreTextView = (TextView) findViewById(R.id.result_10);
            homeTeam10ScoreTextView.setText((CharSequence) ar.get(66));
            fixtureDate10 = (TextView) findViewById(R.id.match_10_date);
            String date1 = ar.get(67);
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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate10.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate11.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate12.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate13.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate14.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate15.setText(date1);
        } catch (IndexOutOfBoundsException e) {}


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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate16.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate17.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate18.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate19.setText(date1);
        } catch (IndexOutOfBoundsException e) {}

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
            }else if (date1.equals(april_6)) {
                date1 = "06/04";
            } else if (date1.equals(april_10)) {
                date1 = "10/04";
            }else if (date1.equals(april_13)) {
                date1 = "13/04";
            } else if (date1.equals(april_17)) {
                date1 = "17/04";
            }else if (date1.equals(april_20)) {
                date1 = "20/04";
            } else {
                date1 = "Unavailable";
            }
            fixtureDate20.setText(date1);
        } catch (IndexOutOfBoundsException e) {}
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










