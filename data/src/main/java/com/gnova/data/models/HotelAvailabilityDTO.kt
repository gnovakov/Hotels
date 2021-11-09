package com.gnova.data.models

import com.squareup.moshi.Json

data class HotelAvailabilityDTO(
    val arrivalDateToday: Boolean,
    val available: Boolean,
    val distance: Double,
    val hotelBrand: String,
    val hotelCode: String,
    @Json(name = "hotelInfo")
    val hotelInfo: HotelInfoDTO,
    @Json(name = "ratePlans")
    val ratePlans: List<RatePlanDTO>,
    val unit: String
)