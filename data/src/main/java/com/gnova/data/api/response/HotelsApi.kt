package com.gnova.data.api.response

import io.reactivex.Single
import retrofit2.http.GET

interface HotelsApi {

    @GET("/raw")
    fun getHotels(): Single<List<HotelResponse>>

}