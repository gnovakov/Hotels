package com.gnova.data.models

import com.squareup.moshi.Json

data class HotelAvailabilityDTO(
    @Json(name = "hotelInfo")
    val hotelInfo: HotelInfoDTO,
    @Json(name = "ratePlans")
    val ratePlans: List<RatePlanDTO>,
)