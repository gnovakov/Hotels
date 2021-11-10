package com.gnova.data.models

import com.squareup.moshi.Json

data class TotalCostXDTO(
    @Json(name = "amount")
    val amount: String? = "",
    @Json(name = "currency")
    val currency: String? = ""
)