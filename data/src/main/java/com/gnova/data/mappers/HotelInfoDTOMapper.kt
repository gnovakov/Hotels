package com.gnova.data.mappers

import com.gnova.data.models.HotelInfoDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.HotelInfo
import javax.inject.Inject

class HotelInfoDTOMapper @Inject constructor(
    private val addressDTOMapper: AddressDTOMapper,
    private val imageDTOMapper: ImageDTOMapper,
    private val mapDTOMapper: MapDTOMapper,
    private val tripAdvisorDTOMapper: TripAdvisorDTOMapper
) : DomainMapper<HotelInfoDTO, HotelInfo> {

    override fun mapToDomain(dto: HotelInfoDTO): HotelInfo {
        return HotelInfo(
            address = addressDTOMapper.mapToDomain(dto.address),
            headline = dto.headline,
            images = imageDTOMapper.mapToDomainList(dto.images),
            map = mapDTOMapper.mapToDomain(dto.map),
            name = dto.name,
            tripAdvisor = tripAdvisorDTOMapper.mapToDomain(dto.tripAdvisor)

        )
    }

    override fun mapToEntity(entity: HotelInfo): HotelInfoDTO {
        return HotelInfoDTO(
            address = addressDTOMapper.mapToEntity(entity.address),
            headline = entity.headline,
            images = imageDTOMapper.mapToEntityList(entity.images),
            map = mapDTOMapper.mapToEntity(entity.map),
            name = entity.name,
            tripAdvisor = tripAdvisorDTOMapper.mapToEntity(entity.tripAdvisor)

        )
    }

    fun mapToDomainList(hotelInfoDTO: List<HotelInfoDTO>): List<HotelInfo> {
        return hotelInfoDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(address: List<HotelInfo>): List<HotelInfoDTO> {
        return address.map {
            mapToEntity(it) }
    }



}