package com.yerayyas.horoscopoapp.motherobject

import com.yerayyas.horoscopoapp.data.network.response.PredictionResponse
import com.yerayyas.horoscopoapp.domain.model.HoroscopeInfo

object HoroscopeMotherObject {

    val anyResponse = PredictionResponse("test", "prediction", "taurusTest")

    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Pisces,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Libra
    )
}