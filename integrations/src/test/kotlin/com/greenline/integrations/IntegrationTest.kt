package com.greenline.integrations

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.springframework.web.client.RestTemplate

class IntegrationTest {

    lateinit var stationRepository: DefaultStationRepository
    lateinit var restTemplate: RestTemplate

    @Before
    fun setUp() {
        restTemplate = RestTemplate()
        stationRepository = DefaultStationRepository(restTemplate)
    }


    @Test
    fun `should get stations from http request`() {
        assertThat(stationRepository.getStations().size).isGreaterThan(-1)
    }

}