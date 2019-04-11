package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mSendResultsButton;
    private TextView mLoggedInTextView;
    private Button mRegisterButton;
    private ImageView mUserPicImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this method alters the home page of the app
        // depending whether the user is logged in
        loggedInCheck();

        // this sets the send result button
        // only users logged in as team admin can see this button
        mSendResultsButton = (Button) findViewById(R.id.send_result);
        mSendResultsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, getString(R.string.result_instructions));
                i = Intent.createChooser(i, getString(R.string.send_result));
                startActivity(i);
            }
        });

        // on click listeners
        findViewById(R.id.tables_button).setOnClickListener(this);
        findViewById(R.id.maps_id).setOnClickListener(this);
        findViewById(R.id.register_id).setOnClickListener(this);
    }


    private void loggedInCheck() {
        // if user is logged in show displayName
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            // nothing here
            // cannot be !=null with empty else statement
            //  or app crashes with NPE
        } else {
            // displays logged in message
            String displayName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            mLoggedInTextView = (TextView) findViewById(R.id.logged_in);
            mLoggedInTextView.setText("Welcome " + displayName);
            mLoggedInTextView.setVisibility(View.VISIBLE);
            // displays pic nex to display name
            if (FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString() != null) {
                mUserPicImageView = (ImageView) findViewById(R.id.user_pic_id);
                Glide.with(MainActivity.this)
                        .load(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString())
                        .into(mUserPicImageView);
                mUserPicImageView.setVisibility(View.VISIBLE);
                // this makes the user's pic a clickable link to the edit profile page
                mUserPicImageView.setOnClickListener(this);
            }

            // hide log in button when logged in
            mRegisterButton = (Button) findViewById(R.id.register_id);
            mRegisterButton.setVisibility(View.GONE);
        }
    }

    // this method contains a switch statement that allows different intents
    // to be opened depending on what is chosen by the user
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.maps_id:
                startActivity(new Intent(this, MapsActivity.class));
                break;
            case R.id.tables_button:
                startActivity(new Intent(MainActivity.this, Reserve1Table.class));
                break;
            case R.id.register_id:
                startActivity(new Intent(this, Register.class));
                break;
            case R.id.user_pic_id:
                startActivity(new Intent(this, Profile.class));
                break;
        }
    }
}