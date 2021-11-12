package dev.alejo.fletxtest.app

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.internal.LinkedTreeMap
import com.xwray.groupie.ViewHolder
import dev.alejo.fletxtest.app.iu.LocationActivity
import kotlinx.android.synthetic.main.item_vehicle.view.*
import org.json.JSONObject

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
            .load( (item["front_vehicle"] as LinkedTreeMap<*, *>)["url"].toString())
            .into(holder.itemView.vehicle_picture)
        holder.itemView.plate.text = item["placa"].toString()
        holder.itemView.driver_name.text = if(item.containsKey("driver")) {
            if(item["driver"] != null) {
                (item["driver"] as LinkedTreeMap<*, *>)["full_name"].toString()
            } else {
                context.getString(R.string.no_driver)
            }
        } else {
            context.getString(R.string.no_driver)
        }
        holder.itemView.trailer.text = if(item.containsKey("trailer")) {
            if(item["trailer"] != null) {
                "${context.getString(R.string.trailer)} " +
                    (item["trailer"] as LinkedTreeMap<*, *>)["placa"].toString()
            } else {
                context.getString(R.string.no_trailer)
            }
        } else {
            context.getString(R.string.no_trailer)
        }
        holder.itemView.vehicle_content.setOnClickListener {
            context.startActivity(Intent(context, LocationActivity::class.java).apply {
                putExtra("lat", 4.7434159)
                putExtra("lng", -74.2690526)
            })
        }
    }

    override fun getItemCount(): Int = vehicles.size

}