package com.gnova.domain.repositories

import com.gnova.domain.models.HotelAvailability
import io.reactivex.Single

interface HotelRepo {

    fun getHotels(): Single<List<HotelAvailability>>

}