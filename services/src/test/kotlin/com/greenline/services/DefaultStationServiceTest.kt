package com.greenline.services

import com.greenline.domain.stations.Station
import com.greenline.domain.stations.StationRepository
import com.greenline.domain.stations.stubs.StubStationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class DefaultStationServiceTest {

    lateinit var service: DefaultStationService
    lateinit var stubStationRepository: StubStationRepository

    @Before
    fun setUp() {
        stubStationRepository = StubStationRepository()
        service = DefaultStationService(stubStationRepository)
    }

    @Test
    fun `getStations() gets stations from station repository`() {
        stubStationRepository.stubbedStations = listOf(
                Station(
                        name = "Prospect Park",
                        id = "123"
                )
        )

        val stations = service.getStations()
        assertThat(stations.size).isEqualTo(1)
        assertThat(stations[0].name).isEqualTo("Prospect Park")
        assertThat(stations[0].id).isEqualTo("123")
    }

}