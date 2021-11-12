package dev.alejo.fletxtest.app.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import dev.alejo.fletxtest.app.R
import dev.alejo.fletxtest.app.model.VehicleProvider
import kotlinx.android.synthetic.main.item_vehicle.view.*

class CustomMapInfoWindow(activityContext: Context): GoogleMap.InfoWindowAdapter {

    @SuppressLint("InflateParams")
    private val window = (activityContext as Activity).layoutInflater.inflate(R.layout.item_vehicle, null)
    private val context = activityContext
    private val vehicleSelected by lazy { VehicleProvider.vehicleSelected }

    private fun setWindowData() {
        Glide.with(context)
            .load(vehicleSelected.picture)
            .into(window.vehicle_picture)
        window.plate.text = vehicleSelected.plate
        window.driver_name.text = vehicleSelected.driverName
        window.trailer.text = vehicleSelected.trailerPlate
        window.availability.text = vehicleSelected.availability
    }

    override fun getInfoContents(p0: Marker): View? {
        setWindowData()
        return window
    }

    override fun getInfoWindow(p0: Marker): View? {
        setWindowData()
        return window
    }

}