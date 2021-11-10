package com.gnova.data.repositories

import com.gnova.data.api.HotelsApi
import com.gnova.data.mappers.HotelAvailabilityDTOMapper
import com.gnova.domain.models.HotelAvailability
import com.gnova.domain.repositories.HotelsRepo
import io.reactivex.Single
import javax.inject.Inject

class HotelsRepoImpl @Inject constructor(
    private val hotelsApi: HotelsApi,
    private val hotelMapper: HotelAvailabilityDTOMapper
) : HotelsRepo {

    override fun getHotels(): Single<List<HotelAvailability>> {

        return hotelsApi.getHotels()
            .map {
                    hotelMapper.mapToDomainList(it.hotelAvailabilities)
            }
    }


}