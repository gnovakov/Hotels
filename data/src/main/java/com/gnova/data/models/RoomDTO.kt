package com.gnova.data.models

import com.squareup.moshi.Json

data class RoomDTO(
    @Json(name = "type")
    val type: String
)