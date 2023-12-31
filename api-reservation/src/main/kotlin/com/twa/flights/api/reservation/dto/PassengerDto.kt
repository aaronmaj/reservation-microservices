package com.twa.flights.api.reservation.dto

import com.twa.flights.api.reservation.dto.enums.Gender
import com.twa.flights.api.reservation.dto.enums.PassengerType
import java.time.LocalDate

data class PassengerDto(
    val type: PassengerType,
    val gender: Gender,
    val birth: LocalDate,
    val nationality: String,
    val firstName: String,
    val lastName: String,
    val document: DocumentDto
)
