package com.twa.flights.api.reservation.model

import jakarta.persistence.*

@Entity(name = "reservation")
data class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,
    @Column(name = "itinerary_id", nullable = false, length = 50)
    val itineraryId: String? = null,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val passengers: List<Passenger>? = null,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val contact: Contact? = null,
)
