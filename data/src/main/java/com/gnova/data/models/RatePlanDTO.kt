package com.gnova.data.models

import com.squareup.moshi.Json

data class RatePlanDTO(
    @Json(name = "name")
    val name: String,
    @Json(name = "rooms")
    val rooms: List<RoomDTO>,
    @Json(name = "totalCost")
    val totalCost: TotalCostXDTO
)