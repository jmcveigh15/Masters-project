package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;

public class GalleryMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int CHOOSE_IMAGE = 0;

    RelativeLayout activity_gallery_main;
    FloatingActionButton fab;
    ArrayList<GalleryPic> arrayList = new ArrayList<>();
    DatabaseReference mDatabaseReference;
    ListView listOfPics;
    DrawerLayout mDrawerLayout;
    ProgressBar mProgressBar;
    Uri mUriImage;
    ImageView mImageView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_main);

        // this is for the bitmap and is not visible
        mImageView = findViewById(R.id.gallery_image);
        mImageView.setVisibility(View.GONE);


        mProgressBar = findViewById(R.id.gallery_progress_bar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Gallery");
        arrayList = new ArrayList<>();
        activity_gallery_main = (RelativeLayout) findViewById(R.id.activity_gallery_main);
        listOfPics = (ListView) findViewById(R.id.listViewGallery);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        displayPics();

        //Check user status
        if (FirebaseAuth.getInstance().getCurrentUser() == null || !FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
            Toast.makeText(this, "Please sign in and verify email to upload media", Toast.LENGTH_LONG).show();
            displayPics();
        } else {
            FirebaseAuth.getInstance().getCurrentUser().reload();
            fab.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "Welcome " + FirebaseAuth.getInstance().getCurrentUser().getDisplayName() + " to the gallery", Toast.LENGTH_SHORT).show();
        }

        // clicking this button lets the user choose a pic to upload to the gallery
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageChooser();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayPics();
    }

    private void showImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image to upload"), CHOOSE_IMAGE);
    }

    // this method displays gallery pics to the user
    private void displayPics() {
        listOfPics = (ListView) findViewById(R.id.listViewGallery);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // arraylist must be cleared
                // or else new comment will cause old messages to repeat
                arrayList.clear();

                //loop through Firebase data and add to the arraylist which populates listview
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    GalleryPic galleryPic = snapshot.getValue(GalleryPic.class);
                    arrayList.add(galleryPic);
                }

                // displays the arraylist of messages into a listview
                GalleryPicAdapter galleryPicAdapter = new GalleryPicAdapter(GalleryMain.this, arrayList);
                listOfPics.setAdapter(galleryPicAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_log_out:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_free_week:
                startActivity(new Intent(this, FreeWeek.class));
                finish();
                break;
            case R.id.nav_login_register:
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    startActivity(new Intent(this, Login.class));
                } else {
                    Toast.makeText(this, "Already logged in", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_pitch_location:
                startActivity(new Intent(this, MapsActivity.class));
                break;
            case R.id.nav_send_result:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, getString(R.string.result_instructions));
                i = Intent.createChooser(i, getString(R.string.send_result));
                startActivity(i);
                break;
            case R.id.nav_home:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_profile:
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    Toast.makeText(this, "Log in or register to view your profile", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, Profile.class));
                }
                break;
            case R.id.nav_forums:
                startActivity(new Intent(this, ForumMain.class));
                finish();
                break;
            case R.id.nav_gallery:
                startActivity(new Intent(this, GalleryMain.class));
                finish();
                break;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // this method is called by an image being chosen in showImageChooser method
    // ensures the image is ok to upload to Firebase server and maps it
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mUriImage = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), mUriImage);
                mImageView.setImageBitmap(bitmap);
                mImageView.setVisibility(View.GONE);

                uploadImageToFirebaseStorage();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // called by onActivityResult if image is selected
    private void uploadImageToFirebaseStorage() {
        String string = mUriImage.toString();
        if (string != null) {
            FirebaseDatabase.getInstance().getReference("Gallery").push().setValue(new GalleryPic(string)).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(), "Image Upload Successful", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    mProgressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
