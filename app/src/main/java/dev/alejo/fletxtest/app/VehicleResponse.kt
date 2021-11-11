package dev.alejo.fletxtest.app

import org.json.JSONObject

class VehicleResponse(
    val success: Boolean,
    val message: String,
    val data: List<JSONObject>,
)