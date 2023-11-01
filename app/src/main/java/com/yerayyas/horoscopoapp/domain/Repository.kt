package com.yerayyas.horoscopoapp.domain

import com.yerayyas.horoscopoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}