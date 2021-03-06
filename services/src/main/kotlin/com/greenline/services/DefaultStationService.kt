package com.greenline.services

import com.greenline.domain.stations.Station
import com.greenline.domain.stations.StationRepository
import com.greenline.domain.stations.StationService

class DefaultStationService(val stationRepository: StationRepository) : StationService {
    override fun getStations(): List<Station> {
        return stationRepository.getStations()
    }
}
