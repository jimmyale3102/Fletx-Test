package dev.alejo.fletxtest.app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.internal.LinkedTreeMap
import dev.alejo.fletxtest.app.R
import dev.alejo.fletxtest.app.adapter.VehicleAdapter
import dev.alejo.fletxtest.app.viewModel.VehicleViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: VehicleAdapter
    private val vehicleViewModel: VehicleViewModel by viewModels()
    private val vehicleList = mutableListOf<LinkedTreeMap<String, Any>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        vehicleViewModel.onCreate()
        vehicleViewModel.responseModel.observe(this, Observer { allVehiclesData ->
            loading.visibility = View.GONE
            val vehiclesData = allVehiclesData?.data ?: emptyList()
            vehicleList.clear()
            vehicleList.addAll(vehiclesData)
            adapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        adapter = VehicleAdapter(this, vehicleList)
        trucks_recycler.layoutManager = LinearLayoutManager(this)
        trucks_recycler.adapter = adapter
    }

}