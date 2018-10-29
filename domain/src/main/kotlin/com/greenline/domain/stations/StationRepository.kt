package com.greenline.domain.stations

interface StationRepository {
    fun getStations(): List<Station>
}
