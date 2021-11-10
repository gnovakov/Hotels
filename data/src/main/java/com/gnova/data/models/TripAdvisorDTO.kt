package com.gnova.data.models

import com.squareup.moshi.Json

data class TripAdvisorDTO(
    @Json(name = "linkUrl")
    val linkUrl: String? = "",
    @Json(name = "ratingImageUrl")
    val ratingImageUrl: String? = ""
)