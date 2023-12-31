package com.twa.flights.api.reservation.dto

import com.twa.flights.api.reservation.dto.enums.DocumentType
import java.time.LocalDate

data class DocumentDto(
    val number: String,
    val type: DocumentType,
    val expiration: LocalDate
)
