package com.gnova.data.models

import com.squareup.moshi.Json

data class MapDTO(
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double
)