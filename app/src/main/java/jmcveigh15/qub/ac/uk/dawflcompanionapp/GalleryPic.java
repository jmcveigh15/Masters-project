package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.net.Uri;

// this class works with the GalleryMain
// it gets and sets pics that users upload as a String value for the Firebase database
public class GalleryPic {
    private String pic;

    public GalleryPic(String pic) {
        this.pic=pic;

    }

    // constructor without args
    public GalleryPic() {

    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
