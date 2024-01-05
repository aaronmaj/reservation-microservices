package com.twa.flights.api.reservation.connector

import com.twa.flights.api.reservation.connector.configuration.HttpConnectorConfiguration
import com.twa.flights.api.reservation.dto.CountryDto
import com.twa.flights.api.reservation.dto.ErrorDto
import com.twa.flights.api.reservation.enums.APIError
import com.twa.flights.api.reservation.exception.ApiException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.codec.DecodingException
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CatalogHttpConnector @Autowired constructor(
    httpConnectorConfiguration: HttpConnectorConfiguration
) : TWAHttpConnector("api-catalog", httpConnectorConfiguration) {

    private val logger: Logger = LoggerFactory.getLogger(CatalogHttpConnector::class.java)

    fun getCountry(nationality: String): CountryDto? {
        logger.info("Calling catalog...")
        try {
            return webClients["country-by-id"]?.let {
                it.get()
                    .uri { uriBuilder ->
                        uriBuilder.build(nationality)
                    }
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError) { _ ->
                        Mono.error(
                            ApiException(
                                APIError.COUNTRY_NOT_FOUND.httpStatus,
                                ErrorDto(
                                    APIError.COUNTRY_NOT_FOUND.code,
                                    APIError.COUNTRY_NOT_FOUND.message,
                                    emptyList()
                                )
                            )
                        )
                    }
                    .bodyToMono(CountryDto::class.java)
                    .share()
                    .block()
            }
        } catch (ex: DecodingException) {
            logger.error("Error mapping. ${ex.message}")
            throw ApiException(
                APIError.BAD_FORMAT.httpStatus,
                ErrorDto(APIError.BAD_FORMAT.code, APIError.BAD_FORMAT.message, emptyList())
            )
        }
    }
}