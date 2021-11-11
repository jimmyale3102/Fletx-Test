package dev.alejo.fletxtest.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: VehicleAdapter
    private val vehicleList = mutableListOf<JSONObject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = VehicleAdapter(this, vehicleList)
        trucks_recycler.layoutManager = LinearLayoutManager(this)
        trucks_recycler.adapter = adapter
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://st.fletx.co:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getVehicles() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit()
                .create(APIService::class.java)
                .getVehicles(
                    "Bearer ab11cb7605a030ee350d08f805057413",
                    "people/holder_vehicles/2282.json"
                )
            val data = call.body()
            if(call.isSuccessful) {
                // Show recyclerview
            } else {
                // Show error
            }
        }
    }

}