package dev.alejo.fletxtest.app.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dev.alejo.fletxtest.app.R
import dev.alejo.fletxtest.app.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val latitude = intent.getDoubleExtra("lat", -34.0)
        val longitude = intent.getDoubleExtra("lng", 151.0)
        val zoomLevel = 15f
        val vehicleLocation = LatLng(latitude, longitude)
        map.addMarker(MarkerOptions().position(vehicleLocation).title("Marker in Sydney"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(vehicleLocation, zoomLevel))
    }
}