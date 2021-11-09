package com.gnova.domain.models

import java.io.Serializable

data class HotelAvailability(
    val hotelInfo: HotelInfo,
    val ratePlans: List<RatePlan>,
) : Serializable