package com.gnova.data.api

import com.gnova.data.api.response.HotelResponse
import io.reactivex.Single
import retrofit2.http.GET

interface HotelsApi {

    @GET("/raw")
    fun getHotels(): Single<List<HotelResponse>>

}