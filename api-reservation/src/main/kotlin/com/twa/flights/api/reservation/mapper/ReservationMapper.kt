package com.twa.flights.api.reservation.mapper

import com.twa.flights.api.reservation.dto.ContactDto
import com.twa.flights.api.reservation.dto.DocumentDto
import com.twa.flights.api.reservation.dto.PassengerDto
import com.twa.flights.api.reservation.dto.ReservationDto
import com.twa.flights.api.reservation.model.Contact
import com.twa.flights.api.reservation.model.Document
import com.twa.flights.api.reservation.model.Passenger
import com.twa.flights.api.reservation.model.Reservation

fun Document.toDto() = DocumentDto(id, number, type, expiration)
fun Contact.toDto() = ContactDto(id, telephone, email)
fun Passenger.toDto() = PassengerDto(
    id = id,
    type = type,
    document = document?.toDto(),
    birth = birth,
    gender = gender,
    nationality = nationality,
    firstName = firstName,
    lastName = lastName
)

fun Reservation.toDto() = ReservationDto(id, itineraryId, passengers?.map { it.toDto() }, contact?.toDto())

fun DocumentDto.toModel() = Document(id, number, type, expiration)
fun ContactDto.toModel() = Contact(id, telephone, email)
fun PassengerDto.toModel() = Passenger(id, gender, type, birth, nationality, firstName, lastName, document?.toModel())
fun ReservationDto.toModel() = Reservation(id, itineraryId, passengers?.map { it.toModel() }, contact?.toModel())