package com.twa.flights.api.reservation.connector

import com.twa.flights.api.reservation.connector.configuration.HttpConnectorConfiguration
import com.twa.flights.api.reservation.dto.ClusterDto
import com.twa.flights.api.reservation.dto.ErrorDto
import com.twa.flights.api.reservation.enums.APIError
import com.twa.flights.api.reservation.exception.ApiException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.codec.DecodingException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ClustersHttpConnector @Autowired constructor(
    httpConnectorConfiguration: HttpConnectorConfiguration,
) : TWAHttpConnector("api-clusters", httpConnectorConfiguration) {

    private val logger: Logger = LoggerFactory.getLogger(ClustersHttpConnector::class.java)

    fun getCluster(id: String, itineraryId: String): ClusterDto? {
        logger.info("Calling clusters...")
        try {
            return webClients["clusters-by-id"]?.let {
                it.get()
                    .uri { uriBuilder ->
                        uriBuilder.build(id, itineraryId)
                    }
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError) { _ ->
                        Mono.error(ApiException(APIError.CLUSTER_NOT_FOUND.httpStatus, ErrorDto(APIError.CLUSTER_NOT_FOUND.code, APIError.CLUSTER_NOT_FOUND.message, emptyList())))
                    }
                    .bodyToMono(ClusterDto::class.java)
                    .share()
                    .block()
            }
        } catch (ex: DecodingException) {
            logger.error("Error mapping. ${ex.message}")
            throw ApiException(APIError.BAD_FORMAT. httpStatus, ErrorDto(APIError.BAD_FORMAT.code, APIError.BAD_FORMAT.message, emptyList()))
        }
    }
}