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
        mMap.addMarker(new MarkerOptions().position(val).title("Valentine Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(val));

        // This adds the marker for Hydebank playing fields
        LatLng hydebank = new LatLng(54.5471161, -5.9301067);
        mMap.addMarker(new MarkerOptions().position(hydebank).title("Hydebank Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hydebank));


        // This adds the marker for CherryVale Playing Fields
        LatLng cherryvale = new LatLng(54.5748953, -5.9133407);
        mMap.addMarker(new MarkerOptions().position(cherryvale).title("Cherryvale Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cherryvale));


        // This adds the marker for Henry Jones Playing Pitches
        LatLng henryJones = new LatLng(54.5676751, -5.8727188);
        mMap.addMarker(new MarkerOptions().position(henryJones).title("Henry Jones Playing Pitches"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(henryJones));

        // This adds the marker for Sally Gardens
        LatLng Sally = new LatLng(54.562694, -6.0324681);
        mMap.addMarker(new MarkerOptions().position(Sally).title("Sally Gardens"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Sally));

        // This adds the marker for Sally Gardens
        LatLng DUB = new LatLng(54.5566168, -5.9595567);
        mMap.addMarker(new MarkerOptions().position(DUB).title("DUB Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DUB));

        // This adds the marker for LondonDerry Park
        LatLng derryPark = new LatLng(54.5870373, -5.6876245);
        mMap.addMarker(new MarkerOptions().position(derryPark).title("Londonderry Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(derryPark));

        // This adds the marker for Millisle
        LatLng Mill = new LatLng(54.6049291, -5.540381);
        mMap.addMarker(new MarkerOptions().position(Mill).title("Millisle Council Pitches"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mill));

        // This adds the marker for Billy Neil
        LatLng Bill = new LatLng(54.577522, -5.7889977);
        mMap.addMarker(new MarkerOptions().position(Bill).title("Billy Neil Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bill));

        // This adds the marker for St Columbanus
        LatLng St = new LatLng(54.6614883, -5.6354864);
        mMap.addMarker(new MarkerOptions().position(St).title("St Columbanus' College"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(St));

        // This adds the marker for Moat Parl
        LatLng MP = new LatLng(54.5935183, -5.8096183);
        mMap.addMarker(new MarkerOptions().position(MP).title("Moat Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MP));

        // This adds the marker for Ballywolley
        LatLng BW = new LatLng(54.6608239, -5.7168328);
        mMap.addMarker(new MarkerOptions().position(BW).title("Ballywolley"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BW));

        // This adds the marker for Mallusk
        LatLng M = new LatLng(54.684234, -6.00224);
        mMap.addMarker(new MarkerOptions().position(M).title("Mallusk Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(M));

        // This adds the marker for Bloomfield
        LatLng B = new LatLng(54.6173956, -5.8407546);
        mMap.addMarker(new MarkerOptions().position(B).title("Bloomfield Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(B));

        // This adds the marker for Parkway
        LatLng P = new LatLng(54.548625, -5.7445281);
        mMap.addMarker(new MarkerOptions().position(P).title("Parkway Playing Fields"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(P));

        // This adds the marker for Meadows
        LatLng mead = new LatLng(54.6747825, -5.6257473);
        mMap.addMarker(new MarkerOptions().position(mead).title("The Meadow, Groomsport"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mead));
    }


}