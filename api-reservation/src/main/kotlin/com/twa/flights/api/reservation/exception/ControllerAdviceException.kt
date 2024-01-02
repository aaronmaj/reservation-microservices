package com.twa.flights.api.reservation.exception

import com.twa.flights.api.reservation.dto.ErrorDTO
import com.twa.flights.api.reservation.dto.enums.APIError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class ControllerAdviceException {

    @ExceptionHandler(ApiException::class)
    fun apiError(e: ApiException, request: WebRequest?): ResponseEntity<ErrorDTO?>? {
        return ResponseEntity.status(e.status).body(e.error)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationExceptions(
        e: MethodArgumentNotValidException,
        request: WebRequest?
    ): ResponseEntity<ErrorDTO?>? {
        val reasons: List<String?> = e.bindingResult.allErrors.map { it.defaultMessage }
        return getErrorDefinition(APIError.VALIDATION_ERROR, reasons)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(e: HttpMessageNotReadableException, request: WebRequest?): ResponseEntity<ErrorDTO?>? {
        return getErrorDefinition(APIError.BAD_FORMAT, emptyList())
    }

    private fun getErrorDefinition(error: APIError, reasons: List<String?>): ResponseEntity<ErrorDTO?>? {
        return ResponseEntity
            .status(error.httpStatus)
            .body(ErrorDTO(error.code, error.message, reasons))
    }
}