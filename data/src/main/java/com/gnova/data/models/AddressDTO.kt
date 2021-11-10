package com.gnova.data.models

import com.squareup.moshi.Json

data class AddressDTO(
    @Json(name = "addressline1")
    val addressline1: String? = "",
    @Json(name = "addressline2")
    val addressline2: String? = "",
    @Json(name = "addressline3")
    val addressline3: String? = "",
    @Json(name = "country")
    val country: String? = "",
    @Json(name = "postcode")
    val postcode: String? = ""
)