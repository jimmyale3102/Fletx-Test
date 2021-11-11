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
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://st.fletx.co:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}