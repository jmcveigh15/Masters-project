package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

// this class works with the ForumMain and FreeWeek class
// it turns Firebase data into textViews which are put in a list
// it is called in the displayComments() method in the ForumMain class
public class GalleryPicAdapter extends ArrayAdapter<GalleryPic> {
    private Activity context;
    private List<GalleryPic> mGalleryPicList;

    // constructor with args
    public GalleryPicAdapter(Activity context, List<GalleryPic> mGalleryPicList) {
        super(context, R.layout.list_item_gallery, mGalleryPicList);
        this.context = context;
        this.mGalleryPicList = mGalleryPicList;
    }

    // this gets the listview full of the altered imageviews
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list_item_gallery, null, true);

        // assigns the imageview in list_item_gallery.xml a imageview variable
        ImageView galleryPicImageView = (ImageView) listView.findViewById(R.id.gallery_pic_item);

        // assigns the uploaded image to the imageview for the arraylist
        GalleryPic galleryPic = mGalleryPicList.get(position);

        String url = galleryPic.getPic();
        try {
            Glide.with(getContext())
                    .load(url)
                    .into(galleryPicImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listView;
    }
}
