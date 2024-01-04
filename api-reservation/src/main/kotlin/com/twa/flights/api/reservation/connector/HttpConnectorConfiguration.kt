package com.twa.flights.api.reservation.connector

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 *  @ConstructorBinding : As of Spring Boot 3.0 @ConstructorBinding
 * is no longer needed at the type level on @ConfigurationProperties classes and should be removed.
 */
@ConfigurationProperties(prefix = "http-connector")
@EnableConfigurationProperties
data class HttpConnectorConfiguration(
    @NestedConfigurationProperty
    val defaultConfig: DefaultConnectionConfiguration?,
    val hosts: Map<String, HostConfiguration>?,
)

data class HostConfiguration(
    val host: String,
    val port: String,
    @NestedConfigurationProperty
    val defaultConfig: DefaultConnectionConfiguration?,
    val endpoints: Map<String, EndpointConnectionConfiguration>,
)

data class DefaultConnectionConfiguration(
    override val connectionTimeout: Long,
    override val readTimeout: Long,
    override val responseTimeout: Long,
) : ConnectionConfiguration

data class EndpointConnectionConfiguration(
    val path: String,
    override val connectionTimeout: Long,
    override val readTimeout: Long,
    override val responseTimeout: Long,
) : ConnectionConfiguration
