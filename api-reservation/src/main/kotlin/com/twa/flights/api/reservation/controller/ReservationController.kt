package com.twa.flights.api.reservation.controller

import com.twa.flights.api.reservation.dto.ReservationDto
import com.twa.flights.api.reservation.service.ReservationService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ReservationController(@Autowired val reservationService: ReservationService) {

    @PostMapping
    fun saveReservation(@Valid @RequestBody reservation: ReservationDto): ResponseEntity<ReservationDto> {
        if (reservation.itineraryId.isNotEmpty())
        return ResponseEntity<ReservationDto>(reservationService.saveReservation(reservation), HttpStatus.OK)
        return ResponseEntity<ReservationDto>(reservationService.saveReservation(reservation), HttpStatus.BAD_REQUEST)

    }

    @GetMapping("/{id}")
    fun getReservationById(@PathVariable("id") id: String): ResponseEntity<ReservationDto> {

        return ResponseEntity<ReservationDto>(reservationService.getReservationById(id), HttpStatus.OK)
    }
}