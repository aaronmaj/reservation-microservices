package com.twa.flights.api.reservation.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class ReservationDto(
    val id: Long? = null,
    @field:NotBlank(message = "The itinerary id must be defined")
    val itineraryId: String? = null,
    @field:NotBlank(message = "The search id must be defined")
    val searchId: String? = null,
    @field:Valid
    @field:NotEmpty(message = "Passengers list must not be empty")
    val passengers: List<PassengerDto>?,
    @field:Valid
    @field:NotNull(message = "Contact must not be null")
    val contact: ContactDto?
)
