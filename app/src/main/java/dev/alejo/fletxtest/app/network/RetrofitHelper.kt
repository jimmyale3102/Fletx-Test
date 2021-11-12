package dev.alejo.fletxtest.app.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://st.fletx.co:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}