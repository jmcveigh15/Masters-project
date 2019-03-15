package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mSendResultsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    }
}

// toolbar at the bottom with links to the fixtures, results, tables and cups
// side toolbar for other links
// middle of page should be pulled from database


// Need to connect qub database to android studio for logins, gallery, forum etc
// Need to figure out how to parse to a table from json