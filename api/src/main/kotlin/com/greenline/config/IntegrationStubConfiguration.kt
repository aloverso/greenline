package com.greenline.config

import com.greenline.domain.stations.Station
import com.greenline.domain.stations.StationRepository
import com.greenline.domain.stations.stubs.StubStationRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("stub-integrations")
@Configuration
class IntegrationStubConfiguration {

    @Bean
    fun getStationRepository(): StationRepository {
        val stubStationRepository = StubStationRepository()
        stubStationRepository.stubbedStations = listOf(
                Station(
                        name = "Grand Central - 42 St",
                        id = "901N"
                ),
                Station(
                        name = "Times Sq - 42 St",
                        id = "902N"
                )
        )

        return stubStationRepository
    }
}
