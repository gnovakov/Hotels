package com.gnova.data.mappers

import com.gnova.data.models.ImageDTO
import com.gnova.data.models.RoomDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.Image
import com.gnova.domain.models.Room
import javax.inject.Inject

class ImageDTOMapper @Inject constructor() : DomainMapper<ImageDTO, Image> {

    override fun mapToDomain(dto: ImageDTO): Image {
        return Image(
            fileReference = dto.fileReference

        )
    }

    override fun mapToEntity(entity: Image): ImageDTO {
        return ImageDTO(
            fileReference = entity.fileReference

        )
    }

    fun mapToDomainList(imageDTO: List<ImageDTO>): List<Image> {
        return imageDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(image: List<Image>): List<ImageDTO> {
        return image.map {
            mapToEntity(it) }
    }



}