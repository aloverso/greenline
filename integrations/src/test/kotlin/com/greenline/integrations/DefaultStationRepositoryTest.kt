package com.greenline.integrations

import com.greenline.domain.stations.Station
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class DefaultStationRepositoryTest {

    lateinit var stationRepository: DefaultStationRepository
    lateinit var spyRestTemplate: SpyRestTemplate

    @Before
    fun setUp() {
        spyRestTemplate = SpyRestTemplate()
        stationRepository = DefaultStationRepository(spyRestTemplate)
    }

    @Test
    fun `getStations() returns a list of fetched stations`() {
        spyRestTemplate.stubbedGet = """
            {
              "result": [
                {
                  "id": "901N",
                  "name": "Grand Central - 42 St"
                }
              ]
            }
        """.trimIndent()
        val stations = stationRepository.getStations()

        assertThat(stations).isEqualTo(listOf(
                Station(
                        name = "Grand Central - 42 St",
                        id = "901N"
                )
        ))

        assertThat(spyRestTemplate.get_urlCalledWith).isEqualTo("http://mtaapi.herokuapp.com/stations")
    }

    @Test
    fun `getStations() returns a different list of fetched stations`() {
        spyRestTemplate.stubbedGet = """
            {
              "result": [
                {
                  "id": "some cool id",
                  "name": "Canal St"
                }
              ]
            }
        """.trimIndent()
        val stations = stationRepository.getStations()

        assertThat(stations).isEqualTo(listOf(
                Station(
                        name = "Canal St",
                        id = "some cool id"
                )
        ))

        assertThat(spyRestTemplate.get_urlCalledWith).isEqualTo("http://mtaapi.herokuapp.com/stations")
    }

}