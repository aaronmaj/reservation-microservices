package com.twa.flights.api.reservation.connector

interface ConnectionConfiguration {
    val connectionTimeout: Long
    val readTimeout: Long
    val responseTimeout: Long
}