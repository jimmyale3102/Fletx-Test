package dev.alejo.fletxtest.app.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.internal.LinkedTreeMap
import com.xwray.groupie.ViewHolder
import dev.alejo.fletxtest.app.R
import dev.alejo.fletxtest.app.model.VehicleModel
import dev.alejo.fletxtest.app.model.VehicleProvider
import dev.alejo.fletxtest.app.view.LocationActivity
import kotlinx.android.synthetic.main.item_vehicle.view.*

class VehicleAdapter(
    private val context: Context,
    private val vehicles: List<LinkedTreeMap<String, Any>>
    ): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_vehicle, parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = vehicles[position]
        Glide.with(context)
            .load((item["front_vehicle"] as LinkedTreeMap<*, *>)["url"].toString())
            .into(holder.itemView.vehicle_picture)
        holder.itemView.plate.text = item["placa"].toString()
        val driverName = if(item.containsKey("driver")) {
            if(item["driver"] != null) {
                (item["driver"] as LinkedTreeMap<*, *>)["full_name"].toString()
            } else {
                context.getString(R.string.no_driver)
            }
        } else {
            context.getString(R.string.no_driver)
        }
        holder.itemView.driver_name.text = driverName
        val trailerPlate = if(item.containsKey("trailer")) {
            if(item["trailer"] != null) {
                "${context.getString(R.string.trailer)} " +
                    (item["trailer"] as LinkedTreeMap<*, *>)["placa"].toString()
            } else {
                context.getString(R.string.no_trailer)
            }
        } else {
            context.getString(R.string.no_trailer)
        }
        holder.itemView.trailer.text = trailerPlate
        holder.itemView.vehicle_content.setOnClickListener {
            val latLngPoint = item["lonlat"].toString().split("(")[1].split(")")[0]
            VehicleProvider.vehicleSelected = VehicleModel(
                (item["front_vehicle"] as LinkedTreeMap<*, *>)["url"].toString(),
                item["placa"].toString(),
                driverName,
                trailerPlate,
                "Disponible"
            )
            context.startActivity(Intent(context, LocationActivity::class.java).apply {
                putExtra("plate", holder.itemView.plate.text.toString())
                putExtra("lat", latLngPoint.split(" ")[1].toDouble())
                putExtra("lng", latLngPoint.split(" ")[0].toDouble())
            })
        }
    }

    override fun getItemCount(): Int = vehicles.size

}