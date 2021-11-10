package com.gnova.hotels.ui.hotels

import com.gnova.domain.models.HotelAvailability

sealed class HotelsViewState {

    data class Presenting( val hotels: List<HotelAvailability>) : HotelsViewState()

    object Error : HotelsViewState()

    object Loading : HotelsViewState()
}
