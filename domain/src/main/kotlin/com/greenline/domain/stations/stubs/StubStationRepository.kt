package com.greenline.domain.stations.stubs

import com.greenline.domain.stations.Station
import com.greenline.domain.stations.StationRepository

class StubStationRepository : StationRepository {
    override fun getStations(): List<Station> {
        return stubbedStations
    }

    lateinit var stubbedStations: List<Station>
}