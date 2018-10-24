package ung.csci.a3300.anxietymanagement

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.view.View
import android.widget.ImageButton
import ung.csci.a3300.anxietymanagement.controller.User_buttons
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.os.Looper
import com.google.android.gms.location.*
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.SettingsClient
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices.getFusedLocationProviderClient
import android.widget.Toast
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener






class MainActivity : AppCompatActivity() {

    //JDN: this is required for location services
    private lateinit var mLocationRequest: LocationRequest
    private val UPDATE_INTERVAL = (10 * 1000).toLong()  /* 10 secs */
    private val FASTEST_INTERVAL: Long = 2000 /* 2 sec */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //JDN: this is to turn on continuous location updates
        startLocationUpdates()

        val meetup_button = findViewById<ImageButton>(R.id.user_meetup)
        val chat_button = findViewById<ImageButton>(R.id.user_chat)
        val anxiety_button = findViewById<ImageButton>(R.id.user_anxiety)
        val food_button = findViewById<ImageButton>(R.id.user_food)
        val games_button = findViewById<ImageButton>(R.id.user_games)
        val settings_button = findViewById<ImageButton>(R.id.user_setting)
        val back_button = findViewById<ImageButton>(R.id.user_backButton)
        val location_button = findViewById<ImageButton>(R.id.user_location)
//        val login_button = findViewById<ImageButton>(R.id.login_button)
//        val register_button = findViewById<ImageButton>(R.id.register_button)

        var clickListener = View.OnClickListener {view ->

            when (view.getId()) {
                R.id.user_anxiety -> setContentView(R.layout.view_anxiety_main)
                R.id.user_setting -> setContentView(R.layout.view_settings)
                R.id.user_meetup -> setContentView(R.layout.view_meetup)
                R.id.user_games -> setContentView(R.layout.view_games)
                R.id.user_chat -> setContentView(R.layout.view_chat)
                R.id.user_food -> setContentView(R.layout.view_food)
                R.id.user_backButton -> setContentView(R.layout.activity_main)
                R.id.register_button -> setContentView(R.layout.register)
            }
        }
        meetup_button.setOnClickListener(clickListener)
        chat_button.setOnClickListener(clickListener)
        anxiety_button.setOnClickListener(clickListener)
        food_button.setOnClickListener(clickListener)
        games_button.setOnClickListener(clickListener)
        location_button.setOnClickListener(clickListener)
        settings_button.setOnClickListener(clickListener)
        back_button.setOnClickListener(clickListener)
//        login_button.setOnClickListener(clickListener)
//        register_button.setOnClickListener(clickListener)
    }
    override fun onStart(){
        super.onStart()
//        val buttons = User_buttons()
//        buttons.runButtons()

    }

    // JDN: Trigger new location updates at interval
    protected fun startLocationUpdates() {

        // Create the location request to start receiving updates
        mLocationRequest = LocationRequest()
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        mLocationRequest.setInterval(UPDATE_INTERVAL)
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL)

        // Create LocationSettingsRequest object using location request
        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(mLocationRequest)
        val locationSettingsRequest = builder.build()

        // Check whether location settings are satisfied
        // https://developers.google.com/android/reference/com/google/android/gms/location/SettingsClient
        val settingsClient = LocationServices.getSettingsClient(this)
        settingsClient.checkLocationSettings(locationSettingsRequest)

        // JDN: The error's asking for a permission check. I've added one into AndroidManifest.xml, but I haven't been
        //      able to find out where to go from there.
        // new Google API SDK v11 uses getFusedLocationProviderClient(this)
        getFusedLocationProviderClient(this).requestLocationUpdates(
            mLocationRequest, object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult?) {
                    // do work here
                    onLocationChanged(locationResult!!.lastLocation)
                }
            },
            Looper.myLooper()
        )
    }

    //JDN: this event fires when location updates are received.
    fun onLocationChanged(location: Location) {
        // New location has now been determined
        val msg = "Updated Location: " +
                java.lang.Double.toString(location.getLatitude()) + "," +
                java.lang.Double.toString(location.getLongitude())
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        // You can now create a LatLng Object for use with maps
        val latLng = LatLng(location.getLatitude(), location.getLongitude())
    }

    //JDN: this function can be called (from a button click, for example) to get the current location.
    // Results will be handled in the above event.
    @SuppressLint("MissingPermission")
    fun getLastLocation() {
        // Get last known recent location using new Google Play Services SDK (v11+)
        val locationClient = getFusedLocationProviderClient(this)

    //  JDN: I'm not sure how to fix the error below.
        locationClient.lastLocation
            .addOnSuccessListener(OnSuccessListener<Location> { location ->
                // GPS location can be null if GPS is switched off
                if (location != null) {
                    onLocationChanged(location)
                }
            })
            .addOnFailureListener { e ->
                Log.d("MapDemoActivity", "Error trying to get last GPS location")
                e.printStackTrace()
            }
    }

}
