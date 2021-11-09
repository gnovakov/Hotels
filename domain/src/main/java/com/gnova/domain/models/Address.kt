package com.gnova.domain.models

import java.io.Serializable

data class Address(
    val addressline1: String,
    val addressline2: String,
    val addressline3: String,
    val country: String,
    val postcode: String
) : Serializable