package com.twa.flights.api.reservation.dto

import com.twa.flights.api.reservation.dto.enums.DocumentType
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class DocumentDto(
    var id: Long? = null,
    @get:NotBlank(message = "The number must be defined")
    val number: String?,
    @field:NotNull(message = "Document type must not be null")
    val type: DocumentType?,
    @field:Future(message = "Expiration must be a future date")
    @field:NotNull(message = "Expiration date must be defined")
    val expiration: LocalDate?
)
