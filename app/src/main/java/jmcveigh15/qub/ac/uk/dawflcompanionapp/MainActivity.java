package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mSendResultsButton;
    private Button mTablesButton;
    private Button mResultsButton;
    private Button mFixturesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this starts the pitch locations activity, need to attach a button to it
        startActivity(new Intent(this, MapsActivity.class));


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

        mTablesButton = (Button) findViewById(R.id.tables_button);


    }

    @Override
    public void onClick(View v) {

    }
}

// toolbar at the bottom with links to the fixtures, results, tables and cups
// side toolbar for other links
// middle of page should be pulled from database


// Need to connect qub database to android studio for logins, gallery, forum etc
// Need to figure out how to parse to a table from json