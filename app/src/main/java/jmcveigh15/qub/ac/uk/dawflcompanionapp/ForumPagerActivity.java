package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class ForumPagerActivity extends AppCompatActivity {
    private static final String EXTRA_FORUM_ID =
            "jmcveigh15.qub.ac.uk.dawflcompanionapp.forum_id";

    private ViewPager mViewPager;
    private List<ForumComment> mForumComments;

    public static Intent newIntent(Context packageContext, UUID forumCommentId) {
        Intent intent = new Intent(packageContext, ForumPagerActivity.class);
        intent.putExtra(EXTRA_FORUM_ID, forumCommentId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_pager);

        UUID forumCommentId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_FORUM_ID);

        mViewPager = (ViewPager) findViewById(R.id.forum_view_pager);

        mForumComments = ForumCentre.get(this).getForumComments();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                ForumComment forumComment = mForumComments.get(position);
                return ForumFragment.newInstance(forumComment.getID());
            }

            @Override
            public int getCount() {
                return mForumComments.size();
            }
        });

        for (int i = 0; i < mForumComments.size(); i++) {
            if (mForumComments.get(i).getID().equals(forumCommentId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
