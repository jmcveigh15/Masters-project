package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ForumFragment extends Fragment {
    private ForumComment mForumComment;
    private EditText mCommentField;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mForumComment = new ForumComment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forum, container, false);

        mCommentField = (EditText) v.findViewById(R.id.forum_comment);
        mCommentField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // blank for now
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mForumComment.setComment(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // blank for now
            }
        });

        return v;
    }
}
