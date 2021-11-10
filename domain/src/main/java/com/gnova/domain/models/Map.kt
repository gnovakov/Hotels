package com.gnova.domain.models

import java.io.Serializable

data class Map(
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0
) : Serializable