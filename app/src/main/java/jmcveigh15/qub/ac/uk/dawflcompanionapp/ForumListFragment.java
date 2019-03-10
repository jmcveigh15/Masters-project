package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ForumListFragment extends Fragment {

    private RecyclerView mForumRecyclerView;
    private ForumCommentAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_list, container, false);

        mForumRecyclerView = (RecyclerView) view
                .findViewById(R.id.forum_recycler_view);
        mForumRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_forum_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_forum:
                ForumComment forumComment = new ForumComment();
                ForumCentre.get(getActivity()).addForum(forumComment);
                Intent intent = ForumPagerActivity
                        .newIntent(getActivity(), forumComment.getID());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        ForumCentre forumCentre = ForumCentre.get(getActivity());
        List<ForumComment> forumComments = forumCentre.getForumComments();

        if (mAdapter == null) {
            mAdapter = new ForumCommentAdapter(forumComments);
            mForumRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ForumCommentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mCommentTextView;
        private ForumComment mForumComment;

        public ForumCommentHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_forum, parent, false));
            itemView.setOnClickListener(this);

            mCommentTextView = (TextView) itemView.findViewById(R.id.forum_comment);
        }

        public void bind(ForumComment forumComment) {
            mForumComment = forumComment;
            mCommentTextView.setText(mForumComment.getComment());
        }

        // this makes it switch screens, could be used for main menu to anywhere
        @Override
        public void onClick(View view) {
            Intent intent = ForumPagerActivity.newIntent(getActivity(), mForumComment.getID());
            startActivity(intent);
        }
    }

    private class ForumCommentAdapter extends RecyclerView.Adapter<ForumCommentHolder> {

        private List<ForumComment> mForumComments;

        public ForumCommentAdapter(List<ForumComment> forumComments) {
            mForumComments = forumComments;
        }

        @NonNull
        @Override
        public ForumCommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ForumCommentHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ForumCommentHolder holder, int position) {
            ForumComment forumComment = mForumComments.get(position);
            holder.bind(forumComment);
        }

        @Override
        public int getItemCount() {
            return mForumComments.size();
        }
    }
}
