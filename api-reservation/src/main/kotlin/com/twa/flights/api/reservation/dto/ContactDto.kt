package com.twa.flights.api.reservation.dto

import jakarta.validation.constraints.NotEmpty

data class ContactDto(
    @get:NotEmpty(message = "Contact telephone must mot be empty")
    val telephone: String,
    @get:NotEmpty(message = "Contact email must mot be empty")
    val email: String
)
