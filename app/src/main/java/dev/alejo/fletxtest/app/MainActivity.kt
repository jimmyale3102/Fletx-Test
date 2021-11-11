package dev.alejo.fletxtest.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {

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