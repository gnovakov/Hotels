package com.gnova.data.models

import com.squareup.moshi.Json

data class RatePlanDTO(
    val classification: String,
    val code: String,
    val description: String,
    @Json(name = "name")
    val name: String,
    val order: Int,
    @Json(name = "rooms")
    val rooms: List<RoomDTO>,
    @Json(name = "totalCost")
    val totalCost: TotalCostXDTO
)