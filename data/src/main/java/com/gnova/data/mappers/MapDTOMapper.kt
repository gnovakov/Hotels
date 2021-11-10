package com.gnova.data.mappers

import com.gnova.data.models.MapDTO
import com.gnova.data.models.RoomDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.Map
import com.gnova.domain.models.Room
import javax.inject.Inject

class MapDTOMapper @Inject constructor() : DomainMapper<MapDTO, Map> {

    override fun mapToDomain(dto: MapDTO): Map {
        return Map(
            latitude = dto.latitude,
            longitude = dto.longitude

        )
    }

    override fun mapToEntity(entity: Map): MapDTO {
        return MapDTO(
            latitude = entity.latitude,
            longitude = entity.longitude

        )
    }

    fun mapToDomainList(mapDTO: List<MapDTO>): List<Map> {
        return mapDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(map: List<Map>): List<MapDTO> {
        return map.map {
            mapToEntity(it) }
    }



}