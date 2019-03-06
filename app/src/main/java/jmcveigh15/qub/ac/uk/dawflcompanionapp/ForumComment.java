package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import java.util.UUID;

public class ForumComment {

    private UUID mID;
    private String mComment;

    public ForumComment(){
        mID = UUID.randomUUID();
    }

    public UUID getID() {
        return mID;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }
}
