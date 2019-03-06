package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ForumListFragment extends Fragment {

    private RecyclerView mForumRecyclerView;
    private ForumCommentAdapter mAdapter;

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

    private void updateUI() {
        ForumCentre forumCentre = ForumCentre.get(getActivity());
        List<ForumComment> forumComments = forumCentre.getForumComments();

        mAdapter = new ForumCommentAdapter(forumComments);
        mForumRecyclerView.setAdapter(mAdapter);
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

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),
                    mForumComment.getComment() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
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
