package dev.alejo.fletxtest.app.network

import dev.alejo.fletxtest.app.model.VehicleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VehicleService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getVehicles(): VehicleResponse? {
        return withContext(Dispatchers.IO) {
            val response = retrofit
                .create(APIService::class.java)
                .getVehicles(
                    "Bearer ab11cb7605a030ee350d08f805057413",
                    "people/holder_vehicles/1115.json"
                )
            response.body()
        }

    }

}