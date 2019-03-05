package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

// toolbar at the bottom with links to the fixtures, results, tables and cups
// side toolbar for other links
// middle of page should be pulled from database


// Need to connect qub database to android studio for logins, gallery, forum etc
// Need to figure out how to parse to a table from json