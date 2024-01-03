package com.twa.flights.api.reservation.service

import com.twa.flights.api.reservation.dto.ReservationDto
import com.twa.flights.api.reservation.mapper.toDto
import com.twa.flights.api.reservation.mapper.toModel
import com.twa.flights.api.reservation.repository.ReservationRepository
import org.springframework.stereotype.Service

@Service
class ReservationService(val reservationRepository: ReservationRepository) {

    fun saveReservation(reservation: ReservationDto): ReservationDto {
        return reservationRepository.save(reservation.toModel()).toDto()
    }

    fun getReservationById(id: Long): ReservationDto {
        return reservationRepository.findById(id).get().toDto()
    }
}