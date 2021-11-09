package com.gnova.domain.mappers

interface DomainMapper <E, D> {

    fun mapToDomain(dto: E) : D

    fun mapToEntity(entity: D) : E

}