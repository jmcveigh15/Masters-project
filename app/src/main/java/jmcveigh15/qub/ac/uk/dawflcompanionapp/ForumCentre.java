package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ForumCentre {
    private static ForumCentre sForumCentre;

    private List<ForumComment> mForumComments;

    public static ForumCentre get(Context context){
        if(sForumCentre==null){
            sForumCentre = new ForumCentre(context);
        }
        return sForumCentre;
    }

    private ForumCentre(Context context){
        mForumComments = new ArrayList<>();
    }

    public void addForum(ForumComment f){
        mForumComments.add(f);
    }

    public List<ForumComment> getForumComments(){
        return mForumComments;
    }


    public ForumComment getForumComment(UUID id){
        for(ForumComment forumComment : mForumComments){
            if(forumComment.getID().equals(id)){
                return forumComment;
            }
        }

        return null;

    }
}
