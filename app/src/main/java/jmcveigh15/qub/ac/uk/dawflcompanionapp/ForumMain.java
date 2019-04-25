package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.text.format.DateFormat;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForumMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout activity_forum_main;
    FloatingActionButton fab;
    ArrayList<ChatMessage> arrayList = new ArrayList<>();
    DatabaseReference mDatabaseReference;
    ListView listOfMessage;
    EditText input;
    DrawerLayout mDrawerLayout;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Forum");
        arrayList = new ArrayList<>();
        activity_forum_main = (RelativeLayout) findViewById(R.id.activity_forum_main);
        listOfMessage = (ListView) findViewById(R.id.listView);
        input = (EditText) findViewById(R.id.input);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        displayComments();

        //Check if not sign-in then navigate Signin page
        if (FirebaseAuth.getInstance().getCurrentUser() == null||!FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
            Toast.makeText(this, "Please sign in and  verify your email to comment", Toast.LENGTH_SHORT).show();
        } else {
            FirebaseAuth.getInstance().getCurrentUser().reload();
            fab.setVisibility(View.VISIBLE);
            input.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "Welcome "+FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+ " to the forum", Toast.LENGTH_SHORT).show();
        }

        // this is the send button
        // it sends the user's name, pic and comment to the Firebase realtime database
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                if (FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
                    FirebaseDatabase.getInstance().getReference("Forum").push()
                            .setValue(new ChatMessage(input.getText().toString(),
                                    FirebaseAuth.getInstance().getCurrentUser().getDisplayName(),
                                    FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString()));
                    input.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "You need to sign in and verify your email to comment", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // this method displays comments to the user
    private void displayComments() {
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // arraylist must be cleared
                // or else new comment will cause old messages to repeat
                arrayList.clear();

                //loop through Firebase data and add to the arraylist which populates listview
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ChatMessage chatMessage = snapshot.getValue(ChatMessage.class);
                    arrayList.add(chatMessage);
                }

                // displays the arraylist of messages into a listview
                ChatMessageAdapter chatMessageAdapter = new ChatMessageAdapter(ForumMain.this, arrayList);
                listOfMessage.setAdapter(chatMessageAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
