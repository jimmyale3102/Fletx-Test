package dev.alejo.fletxtest.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class VehicleAdapter(private val vehicles: List<JSONObject>): RecyclerView.Adapter<VehicleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VehicleViewHolder(layoutInflater.inflate(R.layout.item_vehicle, parent, false))
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val item = vehicles[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = vehicles.size

}