package ung.csci.a3300.anxietymanagement;

import android.support.annotation.NonNull;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.concurrent.Executor;

public class Location {
    public boolean getUserLocation()
    {
        FusedLocationProviderClient mFusedLocationClient =  LocationServices.getFusedLocationProviderClient() (this);

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.

                    }
                })
                .addOnFailureListener((Executor) this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

        return true;

    }


}
