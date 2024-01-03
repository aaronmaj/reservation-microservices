package com.twa.flights.api.reservation.model

import jakarta.persistence.*

@Entity(name = "contact")
data class Contact(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,
    @Column(name = "telephone", nullable = false, length = 50)
    val telephone: String? = null,
    @Column(name = "email", nullable = false, length = 50)
    val email: String? = null
)