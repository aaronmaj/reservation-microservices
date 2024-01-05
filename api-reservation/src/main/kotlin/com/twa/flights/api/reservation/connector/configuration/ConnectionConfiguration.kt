package com.twa.flights.api.reservation.connector.configuration

interface ConnectionConfiguration {
    val connectionTimeout: Long
    val readTimeout: Long
    val responseTimeout: Long
}