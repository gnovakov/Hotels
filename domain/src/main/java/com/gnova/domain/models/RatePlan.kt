package com.gnova.domain.models

import java.io.Serializable

data class RatePlan(
    val description: String? = "",
    val name: String? = "",
    val rooms: List<Room>,
    val totalCost: TotalCostX
) : Serializable