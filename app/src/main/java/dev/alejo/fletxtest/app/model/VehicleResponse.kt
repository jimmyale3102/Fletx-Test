package dev.alejo.fletxtest.app.model

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.LinkedTreeMap

data class VehicleResponse(
    @SerializedName("data") var data: List<LinkedTreeMap<String, Any>>,
    @SerializedName("message") val message: String,
    @SerializedName("success") var success: Boolean
)