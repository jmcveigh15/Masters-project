package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Reserve_1 extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private ImageView mFixtures, mTable, mResults;
    private TextView mDivision;
    private String name;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prem);

        // sets the TextView to the current class name
        name = "Reserve 1 Hub";
        mDivision = (TextView) findViewById(R.id.Division);
        mDivision.setText(name);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // declaring buttons and making them clickable
        mFixtures = (ImageView) findViewById(R.id.Fixtures);
        mFixtures.setOnClickListener(this);
        mTable = (ImageView) findViewById(R.id.Table);
        mTable.setOnClickListener(this);
        mResults = (ImageView) findViewById(R.id.Results);
        mResults.setOnClickListener(this);


    }

    // once button is clicked it will open the relevant activity
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Fixtures:
                startActivity(new Intent(this, R1Fixtures.class));
                break;
            case R.id.Table:
                startActivity(new Intent(this, Reserve1Table.class));
                break;
            case R.id.Results:
                startActivity(new Intent(this, R1Results.class));
                break;
            
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
