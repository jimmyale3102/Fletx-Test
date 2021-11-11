package dev.alejo.fletxtest.app

import com.google.gson.annotations.SerializedName
import java.util.*

data class VehicleResponse(
    @SerializedName("data") var data: List<HashMap<String, Any>>,
    @SerializedName("message") val message: String,
    @SerializedName("success") var success: Boolean
)