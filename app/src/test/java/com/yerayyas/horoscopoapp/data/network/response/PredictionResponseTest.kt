package com.yerayyas.horoscopoapp.data.network.response

import com.yerayyas.horoscopoapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test


class PredictionResponseTest {

    @Test
    fun `toDomain should return a correct PredictionModel`() {
        // Given
        val predictionResponse = anyResponse

        // When
        val predictionModel = predictionResponse.toDomain()

        // Then
        predictionModel.sign shouldBe  predictionResponse.sign
        predictionModel.horoscope shouldBe predictionResponse.horoscope


    }
}
