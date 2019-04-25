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

// this class is the front end of the league table
// it shows parsed json data in a table using updated textViews
public class Reserve2Table extends AppCompatActivity implements FetchR2.AsyncResponse, NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;

    // team name textViews
    private TextView team1nameTextView, team2nameTextView, team3nameTextView, team4nameTextView, team5nameTextView, team6nameTextView, team7nameTextView, team8nameTextView, team9nameTextView;

    // games played textViews
    private TextView team1playedTextView, team2playedTextView, team3playedTextView, team4playedTextView, team5playedTextView, team6playedTextView, team7playedTextView, team8playedTextView, team9playedTextView;

    // games won textViews
    private TextView team1wonTextView, team2wonTextView, team3wonTextView, team4wonTextView, team5wonTextView, team6wonTextView, team7wonTextView, team8wonTextView, team9wonTextView;

    // games drawn textViews;
    private TextView team1drawnTextView, team2drawnTextView, team3drawnTextView, team4drawnTextView, team5drawnTextView, team6drawnTextView, team7drawnTextView, team8drawnTextView, team9drawnTextView;

    // games lost textViews
    private TextView team1lostTextView, team2lostTextView, team3lostTextView, team4lostTextView, team5lostTextView, team6lostTextView, team7lostTextView, team8lostTextView, team9lostTextView;

    // goals for textViews
    private TextView team1goalsForTextView, team2goalsForTextView, team3goalsForTextView, team4goalsForTextView, team5goalsForTextView, team6goalsForTextView, team7goalsForTextView, team8goalsForTextView, team9goalsForTextView;

    // goals against textViews
    private TextView team1goalsAgainstTextView, team2goalsAgainstTextView, team3goalsAgainstTextView, team4goalsAgainstTextView, team5goalsAgainstTextView, team6goalsAgainstTextView, team7goalsAgainstTextView, team8goalsAgainstTextView, team9goalsAgainstTextView;

    // goal difference textViews
    private TextView team1goalDifferenceTextView, team2goalDifferenceTextView, team3goalDifferenceTextView, team4goalDifferenceTextView, team5goalDifferenceTextView, team6goalDifferenceTextView, team7goalDifferenceTextView, team8goalDifferenceTextView, team9goalDifferenceTextView;

    // points textViews
    private TextView team1PointsTextView, team2PointsTextView, team3PointsTextView, team4PointsTextView, team5PointsTextView, team6PointsTextView, team7PointsTextView, team8PointsTextView, team9PointsTextView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //execute the async task
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r2_table);
        // this executes the doInBackGround async activity to retrieve json data and parse it
        new FetchR2(this).execute();

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
    public void doInBackground(String[] ar) {
        // updating team name textViews with parsed json data from an array
        // team order is already sorted in the json data
        team1nameTextView = (TextView) findViewById(R.id.team_1_name_id);
        team1nameTextView.setText((CharSequence) ar[0]);
        team2nameTextView = (TextView) findViewById(R.id.team_2_name_id);
        team2nameTextView.setText((CharSequence) ar[1]);
        team3nameTextView = (TextView) findViewById(R.id.team_3_name_id);
        team3nameTextView.setText((CharSequence) ar[2]);
        team4nameTextView = (TextView) findViewById(R.id.team_4_name_id);
        team4nameTextView.setText((CharSequence) ar[3]);
        team5nameTextView = (TextView) findViewById(R.id.team_5_name_id);
        team5nameTextView.setText((CharSequence) ar[4]);
        team6nameTextView = (TextView) findViewById(R.id.team_6_name_id);
        team6nameTextView.setText((CharSequence) ar[5]);
        team7nameTextView = (TextView) findViewById(R.id.team_7_name_id);
        team7nameTextView.setText((CharSequence) ar[6]);
        team8nameTextView = (TextView) findViewById(R.id.team_8_name_id);
        team8nameTextView.setText((CharSequence) ar[7]);
        team9nameTextView = (TextView) findViewById(R.id.team_9_name_id);
        team9nameTextView.setText((CharSequence) ar[8]);

        // updating games played textViews with parsed json data from an array
        team1playedTextView = (TextView) findViewById(R.id.team_1_played_id);
        team1playedTextView.setText(ar[9]);
        team2playedTextView = (TextView) findViewById(R.id.team_2_played_id);
        team2playedTextView.setText(ar[10]);
        team3playedTextView = (TextView) findViewById(R.id.team_3_played_id);
        team3playedTextView.setText(ar[11]);
        team4playedTextView = (TextView) findViewById(R.id.team_4_played_id);
        team4playedTextView.setText(ar[12]);
        team5playedTextView = (TextView) findViewById(R.id.team_5_played_id);
        team5playedTextView.setText(ar[13]);
        team6playedTextView = (TextView) findViewById(R.id.team_6_played_id);
        team6playedTextView.setText(ar[14]);
        team7playedTextView = (TextView) findViewById(R.id.team_7_played_id);
        team7playedTextView.setText(ar[15]);
        team8playedTextView = (TextView) findViewById(R.id.team_8_played_id);
        team8playedTextView.setText(ar[16]);
        team9playedTextView = (TextView) findViewById(R.id.team_9_played_id);
        team9playedTextView.setText(ar[17]);

        // updating games won textViews with parsed json data from an array
        team1wonTextView = (TextView) findViewById(R.id.team_1_won_id);
        team1wonTextView.setText(ar[18]);
        team2wonTextView = (TextView) findViewById(R.id.team_2_won_id);
        team2wonTextView.setText(ar[19]);
        team3wonTextView = (TextView) findViewById(R.id.team_3_won_id);
        team3wonTextView.setText(ar[20]);
        team4wonTextView = (TextView) findViewById(R.id.team_4_won_id);
        team4wonTextView.setText(ar[21]);
        team5wonTextView = (TextView) findViewById(R.id.team_5_won_id);
        team5wonTextView.setText(ar[22]);
        team6wonTextView = (TextView) findViewById(R.id.team_6_won_id);
        team6wonTextView.setText(ar[23]);
        team7wonTextView = (TextView) findViewById(R.id.team_7_won_id);
        team7wonTextView.setText(ar[24]);
        team8wonTextView = (TextView) findViewById(R.id.team_8_won_id);
        team8wonTextView.setText(ar[25]);
        team9wonTextView = (TextView) findViewById(R.id.team_9_won_id);
        team9wonTextView.setText(ar[26]);

        // updating games drawn textViews with parsed json data from an array
        team1drawnTextView = (TextView) findViewById(R.id.team_1_drawn_id);
        team1drawnTextView.setText(ar[27]);
        team2drawnTextView = (TextView) findViewById(R.id.team_2_drawn_id);
        team2drawnTextView.setText(ar[28]);
        team3drawnTextView = (TextView) findViewById(R.id.team_3_drawn_id);
        team3drawnTextView.setText(ar[29]);
        team4drawnTextView = (TextView) findViewById(R.id.team_4_drawn_id);
        team4drawnTextView.setText(ar[30]);
        team5drawnTextView = (TextView) findViewById(R.id.team_5_drawn_id);
        team5drawnTextView.setText(ar[31]);
        team6drawnTextView = (TextView) findViewById(R.id.team_6_drawn_id);
        team6drawnTextView.setText(ar[32]);
        team7drawnTextView = (TextView) findViewById(R.id.team_7_drawn_id);
        team7drawnTextView.setText(ar[33]);
        team8drawnTextView = (TextView) findViewById(R.id.team_8_drawn_id);
        team8drawnTextView.setText(ar[34]);
        team9drawnTextView = (TextView) findViewById(R.id.team_9_drawn_id);
        team9drawnTextView.setText(ar[35]);

        // updating games lost textViews with parsed json data from an array
        team1lostTextView = (TextView) findViewById(R.id.team_1_lost_id);
        team1lostTextView.setText(ar[36]);
        team2lostTextView = (TextView) findViewById(R.id.team_2_lost_id);
        team2lostTextView.setText(ar[37]);
        team3lostTextView = (TextView) findViewById(R.id.team_3_lost_id);
        team3lostTextView.setText(ar[38]);
        team4lostTextView = (TextView) findViewById(R.id.team_4_lost_id);
        team4lostTextView.setText(ar[39]);
        team5lostTextView = (TextView) findViewById(R.id.team_5_lost_id);
        team5lostTextView.setText(ar[40]);
        team6lostTextView = (TextView) findViewById(R.id.team_6_lost_id);
        team6lostTextView.setText(ar[41]);
        team7lostTextView = (TextView) findViewById(R.id.team_7_lost_id);
        team7lostTextView.setText(ar[42]);
        team8lostTextView = (TextView) findViewById(R.id.team_8_lost_id);
        team8lostTextView.setText(ar[43]);
        team9lostTextView = (TextView) findViewById(R.id.team_9_lost_id);
        team9lostTextView.setText(ar[44]);

        // updating goals for textViews with parsed json data from an array
        team1goalsForTextView = (TextView) findViewById(R.id.team_1_goalsF_id);
        team1goalsForTextView.setText(ar[45]);
        team2goalsForTextView = (TextView) findViewById(R.id.team_2_goalsF_id);
        team2goalsForTextView.setText(ar[46]);
        team3goalsForTextView = (TextView) findViewById(R.id.team_3_goalsF_id);
        team3goalsForTextView.setText(ar[47]);
        team4goalsForTextView = (TextView) findViewById(R.id.team_4_goalsF_id);
        team4goalsForTextView.setText(ar[48]);
        team5goalsForTextView = (TextView) findViewById(R.id.team_5_goalsF_id);
        team5goalsForTextView.setText(ar[49]);
        team6goalsForTextView = (TextView) findViewById(R.id.team_6_goalsF_id);
        team6goalsForTextView.setText(ar[50]);
        team7goalsForTextView = (TextView) findViewById(R.id.team_7_goalsF_id);
        team7goalsForTextView.setText(ar[51]);
        team8goalsForTextView = (TextView) findViewById(R.id.team_8_goalsF_id);
        team8goalsForTextView.setText(ar[52]);
        team9goalsForTextView = (TextView) findViewById(R.id.team_9_goalsF_id);
        team9goalsForTextView.setText(ar[53]);

        // updating goals against textViews with parsed json data from an array
        team1goalsAgainstTextView = (TextView) findViewById(R.id.team_1_goalsA_id);
        team1goalsAgainstTextView.setText(ar[54]);
        team2goalsAgainstTextView = (TextView) findViewById(R.id.team_2_goalsA_id);
        team2goalsAgainstTextView.setText(ar[55]);
        team3goalsAgainstTextView = (TextView) findViewById(R.id.team_3_goalsA_id);
        team3goalsAgainstTextView.setText(ar[56]);
        team4goalsAgainstTextView = (TextView) findViewById(R.id.team_4_goalsA_id);
        team4goalsAgainstTextView.setText(ar[57]);
        team5goalsAgainstTextView = (TextView) findViewById(R.id.team_5_goalsA_id);
        team5goalsAgainstTextView.setText(ar[58]);
        team6goalsAgainstTextView = (TextView) findViewById(R.id.team_6_goalsA_id);
        team6goalsAgainstTextView.setText(ar[59]);
        team7goalsAgainstTextView = (TextView) findViewById(R.id.team_7_goalsA_id);
        team7goalsAgainstTextView.setText(ar[60]);
        team8goalsAgainstTextView = (TextView) findViewById(R.id.team_8_goalsA_id);
        team8goalsAgainstTextView.setText(ar[61]);
        team9goalsAgainstTextView = (TextView) findViewById(R.id.team_9_goalsA_id);
        team9goalsAgainstTextView.setText(ar[62]);

        // updating goal difference textViews with parsed json data from an array
        team1goalDifferenceTextView = (TextView) findViewById(R.id.team_1_goalD_id);
        team1goalDifferenceTextView.setText(ar[63]);
        team2goalDifferenceTextView = (TextView) findViewById(R.id.team_2_goalD_id);
        team2goalDifferenceTextView.setText(ar[64]);
        team3goalDifferenceTextView = (TextView) findViewById(R.id.team_3_goalD_id);
        team3goalDifferenceTextView.setText(ar[65]);
        team4goalDifferenceTextView = (TextView) findViewById(R.id.team_4_goalD_id);
        team4goalDifferenceTextView.setText(ar[66]);
        team5goalDifferenceTextView = (TextView) findViewById(R.id.team_5_goalD_id);
        team5goalDifferenceTextView.setText(ar[67]);
        team6goalDifferenceTextView = (TextView) findViewById(R.id.team_6_goalD_id);
        team6goalDifferenceTextView.setText(ar[68]);
        team7goalDifferenceTextView = (TextView) findViewById(R.id.team_7_goalD_id);
        team7goalDifferenceTextView.setText(ar[69]);
        team8goalDifferenceTextView = (TextView) findViewById(R.id.team_8_goalD_id);
        team8goalDifferenceTextView.setText(ar[70]);
        team9goalDifferenceTextView = (TextView) findViewById(R.id.team_9_goalD_id);
        team9goalDifferenceTextView.setText(ar[71]);

        // updating points textViews with parsed json data from an array
        team1PointsTextView = (TextView) findViewById(R.id.team_1_points_id);
        team1PointsTextView.setText(ar[72]);
        team2PointsTextView = (TextView) findViewById(R.id.team_2_points_id);
        team2PointsTextView.setText(ar[73]);
        team3PointsTextView = (TextView) findViewById(R.id.team_3_points_id);
        team3PointsTextView.setText(ar[74]);
        team4PointsTextView = (TextView) findViewById(R.id.team_4_points_id);
        team4PointsTextView.setText(ar[75]);
        team5PointsTextView = (TextView) findViewById(R.id.team_5_points_id);
        team5PointsTextView.setText(ar[76]);
        team6PointsTextView = (TextView) findViewById(R.id.team_6_points_id);
        team6PointsTextView.setText(ar[77]);
        team7PointsTextView = (TextView) findViewById(R.id.team_7_points_id);
        team7PointsTextView.setText(ar[78]);
        team8PointsTextView = (TextView) findViewById(R.id.team_8_points_id);
        team8PointsTextView.setText(ar[79]);
        team9PointsTextView = (TextView) findViewById(R.id.team_9_points_id);
        team9PointsTextView.setText(ar[80]);

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










