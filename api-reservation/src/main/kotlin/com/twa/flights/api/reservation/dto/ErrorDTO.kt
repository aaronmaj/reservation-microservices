package com.twa.flights.api.reservation.dto

data class ErrorDTO(val code: Int, val shortDescription: String, val reasons: List<String?>) {
}