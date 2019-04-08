package jmcveigh15.qub.ac.uk.dawflcompanionapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// this class creates a google map and adds the pitch markers to it
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // This adds the marker for Valentine playing fields
        LatLng val = new LatLng(54.6509973, -5.6729978);
        mMap.addMarker(new MarkerOptions().position(val).title("3rd Bangor II"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(val));

        // This adds the marker for Hydebank playing fields
        LatLng hydebank = new LatLng(54.5471161, -5.9301067);
        mMap.addMarker(new MarkerOptions().position(hydebank).title("Newton Forest II/Clonduff II"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hydebank));


        // This adds the marker for CherryVale Playing Fields
        LatLng cherryvale = new LatLng(54.5748953, -5.9133407);
        mMap.addMarker(new MarkerOptions().position(cherryvale).title("Corrymeela II"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cherryvale));


        // This adds the marker for Henry Jones Playing Pitches
        LatLng henryJones = new LatLng(54.5676751, -5.8727188);
        mMap.addMarker(new MarkerOptions().position(henryJones).title("Vision Athletic II"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(henryJones));

        // This adds the marker for DUB Playing Fields
        LatLng DUB = new LatLng(54.5566168, -5.9595567);
        mMap.addMarker(new MarkerOptions().position(DUB).title("Queens Grads 4ths"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DUB));

        // This adds the marker for LondonDerry Park
        LatLng derryPark = new LatLng(54.5870373, -5.6876245);
        mMap.addMarker(new MarkerOptions().position(derryPark).title("Comber YM II/Greenwell Star II/Newtownards RBL II"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(derryPark));
    }


}