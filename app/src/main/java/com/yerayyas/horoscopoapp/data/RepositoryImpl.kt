package com.yerayyas.horoscopoapp.data

import android.util.Log
import com.yerayyas.horoscopoapp.data.network.HoroscopeApiService
import com.yerayyas.horoscopoapp.domain.Repository
import com.yerayyas.horoscopoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("TRAM", "Ha ocurrido un error ${it.message}") }
        return null
    }
}