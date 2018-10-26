package com.greenline.controllers

import com.greenline.domain.stations.Station
import com.greenline.domain.stations.StationService
import org.junit.Before
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class StationControllerTest {

    lateinit var stubStationService: StubStationService
    lateinit var client: MockMvc

    @Before
    fun setUp() {
        stubStationService = StubStationService()
        client = MockMvcBuilders.standaloneSetup(StationController(stubStationService)).build()
    }

    @Test
    fun `should return list of stations`() {
        stubStationService.stubbedGetStations = listOf(
                Station(
                        name = "some name",
                        id = "some id"
                )
        )

        client.perform(get("/api/v1/stations"))
                .andExpect(status().is2xxSuccessful)
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("some name"))
                .andExpect(jsonPath("$[0].id").value("some id"))
    }
}

class StubStationService: StationService {
    lateinit var stubbedGetStations: List<Station>

    override fun getStations(): List<Station> {
        return stubbedGetStations
    }
}
