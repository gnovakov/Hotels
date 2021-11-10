package com.gnova.data.models

import com.squareup.moshi.Json

data class ImageDTO(
    @Json(name = "fileReference")
    val fileReference: String? = ""
)