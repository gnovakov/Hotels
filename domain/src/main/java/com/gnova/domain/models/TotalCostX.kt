package com.gnova.domain.models

import java.io.Serializable

data class TotalCostX(
    val amount: String? = "",
    val currency: String? = ""
) : Serializable