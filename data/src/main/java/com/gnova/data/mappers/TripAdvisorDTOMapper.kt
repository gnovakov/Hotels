package com.gnova.data.mappers

import com.gnova.data.models.TripAdvisorDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.TripAdvisor
import javax.inject.Inject

class TripAdvisorDTOMapper @Inject constructor() : DomainMapper<TripAdvisorDTO, TripAdvisor> {

    override fun mapToDomain(dto: TripAdvisorDTO): TripAdvisor {
        return TripAdvisor(
            linkUrl = dto.linkUrl,
            ratingImageUrl = dto.ratingImageUrl

        )
    }

    override fun mapToEntity(entity: TripAdvisor): TripAdvisorDTO {
        return TripAdvisorDTO(
            linkUrl = entity.linkUrl,
            ratingImageUrl = entity.ratingImageUrl

        )
    }

    fun mapToDomainList(tripAdvisorDTO: List<TripAdvisorDTO>): List<TripAdvisor> {
        return tripAdvisorDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(tripAdvisor: List<TripAdvisor>): List<TripAdvisorDTO> {
        return tripAdvisor.map {
            mapToEntity(it) }
    }


}