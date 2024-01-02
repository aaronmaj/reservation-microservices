package com.twa.flights.api.reservation.controller

import com.twa.flights.api.reservation.dto.ReservationDto
import com.twa.flights.api.reservation.service.ReservationService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class ReservationController(@Autowired val reservationService: ReservationService) {
    private val logger: Logger = LoggerFactory.getLogger(ReservationController::class.java)
    @PostMapping
    fun saveReservation(@Valid @RequestBody reservation: ReservationDto): ResponseEntity<ReservationDto> {
        logger.info("Saving the reservation information")
        return ResponseEntity<ReservationDto>(reservationService.saveReservation(reservation), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getReservationById(@PathVariable("id") id: String): ResponseEntity<ReservationDto> {
        logger.info("Obtain the reservation information")
        return ResponseEntity<ReservationDto>(reservationService.getReservationById(id), HttpStatus.OK)
    }
}