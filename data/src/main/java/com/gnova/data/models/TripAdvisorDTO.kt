package com.gnova.data.models

import com.squareup.moshi.Json

data class TripAdvisorDTO(
    val hotelId: String,
    @Json(name = "linkUrl")
    val linkUrl: String,
    val rateLowerRange: Int,
    val rateUpperRange: Int,
    val rating: Double,
    @Json(name = "ratingImageUrl")
    val ratingImageUrl: String,
    val sampleSize: Int,
    val stepSize: Double,
    val tripAdvisorId: String
)