package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.support.v4.app.Fragment;

public class ForumListActivity extends SingleFragmentActivity{

    // should be showing list of matches
    @Override
    protected Fragment createFragment(){
        return new ForumListFragment();
    }
}
