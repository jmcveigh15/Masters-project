package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private TextView mLoggedInTextView;
    private ImageView mUserPicImageView;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // this method alters the home page of the app
        // depending whether the user is logged in
        loggedInCheck();

        // on click listeners
        findViewById(R.id.tables_button).setOnClickListener(this);
    }


    private void loggedInCheck() {
        // check if user is logged in, has display name and has profile pic
        if (FirebaseAuth.getInstance().getCurrentUser() == null
                || FirebaseAuth.getInstance().getCurrentUser().getDisplayName() == null
                || FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl() == null) {


            if(FirebaseAuth.getInstance().getCurrentUser()==null){
                Toast.makeText(getApplicationContext(), "Welcome to the DAWFL Companion App", Toast.LENGTH_LONG).show();
            } else if (FirebaseAuth.getInstance().getCurrentUser().getDisplayName()==null||FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl()==null){
                Toast.makeText(getApplicationContext(), "Please finish registration by clicking 'Profile'", Toast.LENGTH_SHORT).show();
            }
            // if user is not logged in, has no photo or displayname do not show logged in message
        } else {
            // displays logged in message
            String displayName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            mLoggedInTextView = (TextView) findViewById(R.id.logged_in);
            mLoggedInTextView.setText(displayName);
            mLoggedInTextView.setVisibility(View.VISIBLE);

            // displays pic next to display name
            // if the current user's image is not null set it in the imageview next to the displayname
            if (FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString() != null) {
                mUserPicImageView = (ImageView) findViewById(R.id.user_pic_id);
                Glide.with(MainActivity.this)
                        .load(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString())
                        .into(mUserPicImageView);
                mUserPicImageView.setVisibility(View.VISIBLE);

                // this makes the user's pic a clickable link to the edit profile page
                mUserPicImageView.setOnClickListener(this);
            }
        }
    }

    // this method contains a switch statement that allows different intents
    // to be opened depending on what is chosen by the user
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tables_button:
                startActivity(new Intent(MainActivity.this, Reserve1Table.class));
                break;
            case R.id.user_pic_id:
                startActivity(new Intent(this, Profile.class));
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
                break;
            case R.id.nav_gallery:
                startActivity(new Intent(this, GalleryMain.class));
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