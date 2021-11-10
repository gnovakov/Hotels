package com.gnova.data.models

import com.squareup.moshi.Json

data class HotelInfoDTO(
    @Json(name = "address")
    val address: AddressDTO,
    @Json(name = "headline")
    val headline: String? = "",
    @Json(name = "images")
    val images: List<ImageDTO>,
    @Json(name = "map")
    val map: MapDTO,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "tripAdvisor")
    val tripAdvisor: TripAdvisorDTO
)