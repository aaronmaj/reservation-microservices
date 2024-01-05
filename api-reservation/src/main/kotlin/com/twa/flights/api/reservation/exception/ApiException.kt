package com.twa.flights.api.reservation.exception

import com.twa.flights.api.reservation.dto.ErrorDto
import org.springframework.http.HttpStatus

class ApiException(val status: HttpStatus, val error: ErrorDto) :
    RuntimeException("our best engineers are working to do a better place for you!") {
}