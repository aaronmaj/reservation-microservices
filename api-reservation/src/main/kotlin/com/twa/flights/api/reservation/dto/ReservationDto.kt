package com.twa.flights.api.reservation.dto

import jakarta.validation.constraints.NotEmpty

data class ReservationDto(
    val id: Long,
    @field:NotEmpty
    val itineraryId: String,
    val passengers: List<PassengerDto>,
    val contact: ContactDto
)
