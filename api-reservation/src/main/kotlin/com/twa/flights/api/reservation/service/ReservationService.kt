package com.twa.flights.api.reservation.service

import com.twa.flights.api.reservation.connector.CatalogHttpConnector
import com.twa.flights.api.reservation.connector.ClustersHttpConnector
import com.twa.flights.api.reservation.dto.ReservationDto
import com.twa.flights.api.reservation.mapper.toDto
import com.twa.flights.api.reservation.mapper.toModel
import com.twa.flights.api.reservation.repository.ReservationRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ReservationService(
    private val reservationRepository: ReservationRepository,
    private val catalogHttpConnector: CatalogHttpConnector,
    private val clustersHttpConnector: ClustersHttpConnector
) {
    private val logger: Logger = LoggerFactory.getLogger(ReservationService::class.java)
    fun saveReservation(reservation: ReservationDto): ReservationDto {
        logger.info("Obtain the reservation information")
        validateWithExternalServices(reservation)
        return reservationRepository.save(reservation.toModel()).toDto()
    }

    fun getReservationById(id: Long): ReservationDto {
        logger.info("Saving the reservation information to the database")
        return reservationRepository.findById(id).get().toDto()
    }

    private fun validateWithExternalServices(reservation: ReservationDto) {
        reservation.itineraryId?.let { itineraryId ->
            reservation.searchId?.let { searchId ->
                clustersHttpConnector.getCluster(searchId, itineraryId)
            }
        }
        reservation.passengers?.forEach {
            it.nationality?.let { nationality -> catalogHttpConnector.getCountry(nationality) }
        }
    }
}