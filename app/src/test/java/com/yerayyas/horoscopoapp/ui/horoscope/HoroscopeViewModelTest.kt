package com.yerayyas.horoscopoapp.ui.horoscope

import com.yerayyas.horoscopoapp.data.providers.HoroscopeProvider
import com.yerayyas.horoscopoapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest {

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes are loaded`() {
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value

        assertTrue(horoscopes.isNotEmpty())
        verify(atLeast = 1) { horoscopeProvider.getHoroscopes() }
        confirmVerified(horoscopeProvider)
    }
}