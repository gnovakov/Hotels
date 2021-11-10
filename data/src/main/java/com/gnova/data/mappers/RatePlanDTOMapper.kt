package com.gnova.data.mappers

import com.gnova.data.models.RatePlanDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.RatePlan
import javax.inject.Inject

class RatePlanDTOMapper @Inject constructor(
    private val roomDTOMapper: RoomDTOMapper,
    private val totalCostXDTOMapper: TotalCostXDTOMapper
) : DomainMapper<RatePlanDTO, RatePlan> {

    override fun mapToDomain(dto: RatePlanDTO): RatePlan {
        return RatePlan(
            name = dto.name,
            rooms = roomDTOMapper.mapToDomainList(dto.rooms),
            totalCost = totalCostXDTOMapper.mapToDomain(dto.totalCost)
        )
    }

    override fun mapToEntity(entity: RatePlan): RatePlanDTO {
        return RatePlanDTO(
            name = entity.name,
            rooms = roomDTOMapper.mapToEntityList(entity.rooms),
            totalCost = totalCostXDTOMapper.mapToEntity(entity.totalCost)
        )
    }

    fun mapToDomainList(ratePlanDTO: List<RatePlanDTO>): List<RatePlan> {
        return ratePlanDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(ratePlan: List<RatePlan>): List<RatePlanDTO> {
        return ratePlan.map {
            mapToEntity(it) }
    }



}