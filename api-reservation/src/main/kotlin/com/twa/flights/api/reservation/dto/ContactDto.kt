package com.twa.flights.api.reservation.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class ContactDto(
    var id: Long? = null,
    @get:NotEmpty(message = "Contact telephone must mot be empty")
    val telephone: String? = null,
    @get:NotEmpty(message = "Contact email must mot be empty")
    @field:Email(message = "Please provide a valid email address")
    val email: String? = null
)
