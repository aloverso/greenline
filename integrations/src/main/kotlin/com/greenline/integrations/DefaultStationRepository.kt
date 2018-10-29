package com.greenline.integrations

import com.greenline.domain.stations.Station
import com.greenline.domain.stations.StationRepository
import org.springframework.web.client.RestOperations

class DefaultStationRepository(val restTemplate: RestOperations): StationRepository {
    override fun getStations(): List<Station> {

        val stationResponse = restTemplate.getForEntity(
                "http://mtaapi.herokuapp.com/stations",
                MTAStationResponse::class.java
        )

        if(stationResponse.hasBody()) {
            return stationResponse.body!!.result.map {
                Station(
                        name = it.name,
                        id = it.id
                )
            }
        }

        return emptyList()
    }
}

data class MTAStationResponse(
        val result: List<MTAStation>
)

data class MTAStation(
        val id: String,
        val name: String
)