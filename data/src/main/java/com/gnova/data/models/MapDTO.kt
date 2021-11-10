package com.gnova.data.models

import com.squareup.moshi.Json

data class MapDTO(
    @Json(name = "latitude")
    val latitude: Double? = 0.0,
    @Json(name = "longitude")
    val longitude: Double? = 0.0
)