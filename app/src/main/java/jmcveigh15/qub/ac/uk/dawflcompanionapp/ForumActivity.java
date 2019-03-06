package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ForumActivity extends SingleFragmentActivity {

    // people pick what match they want to discuss
    // then an editText at the bottom of the page
    // comments will fill page

    @Override
    protected Fragment createFragment(){
        return new ForumFragment();
    }
}


