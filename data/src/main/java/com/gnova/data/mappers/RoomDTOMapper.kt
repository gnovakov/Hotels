package com.gnova.data.mappers

import com.gnova.data.models.RoomDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.Room
import javax.inject.Inject

class RoomDTOMapper @Inject constructor() : DomainMapper<RoomDTO, Room> {

    override fun mapToDomain(dto: RoomDTO): Room {
        return Room(
            type = dto.type
        )
    }

    override fun mapToEntity(entity: Room): RoomDTO {
        return RoomDTO(
            type = entity.type
        )
    }

    fun mapToDomainList(roomDTO: List<RoomDTO>): List<Room> {
        return roomDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(room: List<Room>): List<RoomDTO> {
        return room.map {
            mapToEntity(it) }
    }



}