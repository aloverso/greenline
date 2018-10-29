package com.greenline.config

import com.greenline.domain.stations.StationRepository
import com.greenline.domain.stations.StationService
import com.greenline.services.DefaultStationService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceConfiguration {

    @Bean
    fun getStationService(stationRepository: StationRepository): StationService {
        return DefaultStationService(stationRepository)
    }
}