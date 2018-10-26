package com.greenline.controllers

import com.greenline.domain.stations.Station
import com.greenline.domain.stations.StationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StationController(val stationService: StationService) {

    @GetMapping("/api/v1/stations")
    fun getStations(): List<Station> {
        return stationService.getStations()
    }
}



