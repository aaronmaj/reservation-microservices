package com.twa.flights.api.reservation.config

import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.boot.actuate.info.InfoEndpoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.yaml.snakeyaml.Yaml

@Configuration
class InfoEndpointConfiguration {
    private val APP_INFO_FILE = "app-info.yml"

    @Bean
    @SuppressWarnings("unchecked")
    @Suppress("unchecked_cast")
    fun infoEndpoint(): InfoEndpoint {
        val info: Map<String, Any> = getInfoFromFile() as Map<String, Any>
        val infoContributor = InfoContributor { it.withDetails(info) }
        return InfoEndpoint(listOf(infoContributor))
    }

    private fun getInfoFromFile() =
        Yaml().loadAs(this.javaClass.classLoader.getResourceAsStream(APP_INFO_FILE), Map::class.java)

}