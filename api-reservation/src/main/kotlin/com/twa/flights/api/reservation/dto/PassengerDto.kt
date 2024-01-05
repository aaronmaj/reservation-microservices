package com.twa.flights.api.reservation.dto

import com.twa.flights.api.reservation.enums.Gender
import com.twa.flights.api.reservation.enums.PassengerType
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class PassengerDto(
    var id: Long? = null,
    @field:NotNull(message = "The passenger type must be defined")
    val type: PassengerType?,
    @field:NotNull(message = "The gender must be defined")
    val gender: Gender?,
    @field:Past(message = "The birth date need to be in the past")
    @field:NotNull(message = "The birth date must be defined")
    val birth: LocalDate?,
    @field:NotBlank(message = "Nationality must be defined")
    @field:Size(min = 2, max = 3, message = "The nationality field does not have the correct size")
    val nationality: String? = null,
    @field:NotBlank(message = "The firstname must be defined")
    @field:Size(min = 2, max = 20, message = "The firstname does not have the correct size")
    val firstName: String? = null,
    @field:NotBlank(message = "The lastname must be defined")
    @field:Size(min = 2, max = 20, message = "The lastName not have the correct size")
    val lastName: String? = null,
    @field:Valid
    @field:NotNull(message = "Passenger document must not be null")
    val document: DocumentDto?
)
