package com.gnova.data.mappers

import com.gnova.data.models.RoomDTO
import com.gnova.data.models.TotalCostXDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.Room
import com.gnova.domain.models.TotalCostX
import javax.inject.Inject

class TotalCostXDTOMapper @Inject constructor() : DomainMapper<TotalCostXDTO, TotalCostX> {

    override fun mapToDomain(dto: TotalCostXDTO): TotalCostX {
        return TotalCostX(
            amount = dto.amount,
            currency = dto.currency

        )
    }

    override fun mapToEntity(entity: TotalCostX): TotalCostXDTO {
        return TotalCostXDTO(
            amount = entity.amount,
            currency = entity.currency

        )
    }

    fun mapToDomainList(totalCostXDTO: List<TotalCostXDTO>): List<TotalCostX> {
        return totalCostXDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(totalCostX: List<TotalCostX>): List<TotalCostXDTO> {
        return totalCostX.map {
            mapToEntity(it) }
    }



}