//package ung.csci.a3300.anxietymanagement
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
////import ung.csci.a3300.anxietymanagement.controller.User_buttons
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//import android.os.Looper
//import com.google.android.gms.location.*
//import com.google.android.gms.location.LocationResult
//import com.google.android.gms.location.LocationCallback
//import com.google.android.gms.location.SettingsClient
//import com.google.android.gms.location.LocationSettingsRequest
//import com.google.android.gms.location.LocationRequest
//import com.google.android.gms.location.LocationServices.getFusedLocationProviderClient
//import android.support.annotation.NonNull
//import android.support.v4.content.ContextCompat.startActivity
//import android.widget.*
//import com.google.android.gms.tasks.OnFailureListener
//import com.google.android.gms.tasks.OnSuccessListener
//
//
//
//class Meetup {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.user_meetup)
//
//        val intent = Intent(this, Meetup::class.java)
//// To pass any data to next activity
//        intent.putExtra("keyIdentifier", value)
//// start your next activity
//        startActivity(intent)
//
//        val spinner: Spinner = findViewById(R.id.spinner)
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.interests_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
//
//        val spinner2: Spinner = findViewById(R.id.spinner2)
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.interests_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner2.adapter = adapter
//        }
//
//        val spinner3: Spinner = findViewById(R.id.spinner3)
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.interests_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner3.adapter = adapter
//        }
//        class SpinnerActivity : Meetup(), AdapterView.OnItemSelectedListener {
//
//            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
//                // An item was selected. You can retrieve the selected item using
//                // parent.getItemAtPosition(pos)
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // Another interface callback
//            }
//        }
//
//        val spinner: Spinner = findViewById(R.id.spinner)
//        spinner.onItemSelectedListener = this
//    }
//}