package com.gnova.data.models

import com.squareup.moshi.Json

data class RoomDTO(
    val adults: Int,
    val children: Int,
    val nonWindow: Any,
    val roomNumber: Int,
    val totalCost: TotalCost,
    @Json(name = "type")
    val type: String
)