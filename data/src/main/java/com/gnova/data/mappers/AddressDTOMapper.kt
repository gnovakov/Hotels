package com.gnova.data.mappers

import com.gnova.data.models.AddressDTO
import com.gnova.data.models.RoomDTO
import com.gnova.domain.mappers.DomainMapper
import com.gnova.domain.models.Address
import com.gnova.domain.models.Room
import javax.inject.Inject

class AddressDTOMapper @Inject constructor() : DomainMapper<AddressDTO, Address> {

    override fun mapToDomain(dto: AddressDTO): Address {
        return Address(
            addressline1 = dto.addressline1,
            addressline2 = dto.addressline2,
            addressline3 = dto.addressline3,
            country = dto.country,
            postcode = dto.postcode,

        )
    }

    override fun mapToEntity(entity: Address): AddressDTO {
        return AddressDTO(
            addressline1 = entity.addressline1,
            addressline2 = entity.addressline2,
            addressline3 = entity.addressline3,
            country = entity.country,
            postcode = entity.postcode,

        )
    }

    fun mapToDomainList(addressDTO: List<AddressDTO>): List<Address> {
        return addressDTO.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(address: List<Address>): List<AddressDTO> {
        return address.map {
            mapToEntity(it) }
    }



}