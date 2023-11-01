package com.yerayyas.horoscopoapp.data.providers

import com.yerayyas.horoscopoapp.domain.model.HoroscopeInfo
import com.yerayyas.horoscopoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Virgo,
            Gemini,
            Aquarius,
            Taurus,
            Capricorn,
            Leo,
            Cancer,
            Scorpio,
            Pisces,
            Sagittarius,
            Libra
        )
    }
}