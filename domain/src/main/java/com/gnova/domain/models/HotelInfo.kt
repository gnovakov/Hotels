package com.gnova.domain.models

import java.io.Serializable

data class HotelInfo(
    val address: Address,
    val headline: String,
    val images: List<Image>,
    val map: Map,
    val name: String,
    val tripAdvisor: TripAdvisor
) : Serializable