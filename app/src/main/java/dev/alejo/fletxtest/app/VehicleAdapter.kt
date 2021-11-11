package dev.alejo.fletxtest.app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.ViewHolder

class VehicleAdapter(
    private val context: Context,
    private val vehicles: List<HashMap<String, Any>>
    ): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_vehicle, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = vehicles[position]
    }

    override fun getItemCount(): Int = vehicles.size

}