package com.twa.flights.api.reservation.connector.configuration

import com.twa.flights.api.reservation.connector.HttpConnectorConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(HttpConnectorConfiguration::class)
class TWAHttpConnectorConfiguration {
}