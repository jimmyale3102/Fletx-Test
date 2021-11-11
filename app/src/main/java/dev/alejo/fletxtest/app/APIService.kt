package dev.alejo.fletxtest.app

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Url

interface APIService {

    @GET
    fun getVehicles(
        @Header("Authorization") token: String,
        @Url url: String
    ): Response<VehicleResponse>

}