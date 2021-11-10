package com.gnova.data.mappers

import com.gnova.data.models.HotelAvailabilityDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.HotelAvailability
import javax.inject.Inject

class HotelAvailabilityDTOMapper @Inject constructor(
    private val hotelInfoDTOMapper: HotelInfoDTOMapper,
    private val ratePlanDTOMapper: RatePlanDTOMapper
) : DomainMapper<HotelAvailabilityDTO, HotelAvailability> {

    override fun mapToDomain(dto: HotelAvailabilityDTO): HotelAvailability {
        return HotelAvailability(
            hotelInfo = hotelInfoDTOMapper.mapToDomain(dto.hotelInfo),
            ratePlans = ratePlanDTOMapper.mapToDomainList(dto.ratePlans)
        )
    }

    override fun mapToEntity(entity: HotelAvailability): HotelAvailabilityDTO {
        return HotelAvailabilityDTO(
            hotelInfo = hotelInfoDTOMapper.mapToEntity(entity.hotelInfo),
            ratePlans = ratePlanDTOMapper.mapToEntityList(entity.ratePlans)

        )
    }

    fun mapToDomainList(hotelAvailabilityDTO: List<HotelAvailabilityDTO>): List<HotelAvailability> {
        return hotelAvailabilityDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(hotelAvailability: List<HotelAvailability>): List<HotelAvailabilityDTO> {
        return hotelAvailability.map {
            mapToEntity(it) }
    }



}