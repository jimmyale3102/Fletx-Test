package dev.alejo.fletxtest.app.view

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
import java.util.*

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityLocationBinding
    private lateinit var plate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        plate = intent.getStringExtra("plate").toString()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val latitude = intent.getDoubleExtra("lat", -34.0)
        val longitude = intent.getDoubleExtra("lng", 151.0)
        val zoomLevel = 15f
        val vehicleLocation = LatLng(latitude, longitude)
        map.addMarker(MarkerOptions().position(vehicleLocation).title("Vehículo: $plate"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(vehicleLocation, zoomLevel))
    }

}