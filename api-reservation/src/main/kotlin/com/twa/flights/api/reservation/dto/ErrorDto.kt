package com.twa.flights.api.reservation.dto

data class ErrorDto(val code: Int, val shortDescription: String, val reasons: List<String?>) {
}