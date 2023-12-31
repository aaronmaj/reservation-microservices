package com.twa.flights.api.reservation.service

import com.twa.flights.api.reservation.dto.ContactDto
import com.twa.flights.api.reservation.dto.ReservationDto
import org.springframework.stereotype.Service

@Service
class ReservationService {

    fun saveReservation(reservation: ReservationDto): ReservationDto{
        return reservation
    }

    fun getReservationById(id:String): ReservationDto{
        return ReservationDto(1L, id, emptyList(), ContactDto("", ""))
    }
}