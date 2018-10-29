package com.greenline.config

import com.greenline.domain.stations.StationRepository
import com.greenline.integrations.DefaultStationRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.boot.web.client.RestTemplateBuilder

@Configuration
class IntegrationConfiguration {

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder.build()
    }

    @Bean
    fun getStationRepository(restTemplate: RestTemplate): StationRepository {
        return DefaultStationRepository(restTemplate)
    }
}