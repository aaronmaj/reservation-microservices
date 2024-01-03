package com.twa.flights.api.reservation.config

import org.springframework.boot.context.properties.ConfigurationProperties


/**
 *  @ConstructorBinding : As of Spring Boot 3.0 @ConstructorBinding
 * is no longer needed at the type level on @ConfigurationProperties classes and should be removed.
 */
@ConfigurationProperties(prefix = "http-connector")
data class HttpConnectorConfiguration()
