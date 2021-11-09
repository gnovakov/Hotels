package com.gnova.data.api.response

import com.gnova.data.models.HotelAvailabilityDTO
import com.squareup.moshi.Json

data class HotelResponse(
    @Json(name = "hotelAvailabilities")
    val hotelAvailabilities: List<HotelAvailabilityDTO>,
    val total: Int
)