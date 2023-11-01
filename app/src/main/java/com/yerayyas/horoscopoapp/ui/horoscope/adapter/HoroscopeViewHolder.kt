package com.yerayyas.horoscopoapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.yerayyas.horoscopoapp.databinding.ItemHoroscopeBinding
import com.yerayyas.horoscopoapp.domain.model.HoroscopeInfo

const val HALF_SECOND = 500L
const val COMPLETE_SPIN = 360f

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun bind(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvHoroscopeName.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscopeName.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            //onItemSelected(horoscopeInfo)
            startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
        }

    }

    private fun startRotationAnimation(view:View, newLambda:()->Unit ){
        view.animate().apply {
            duration = HALF_SECOND
            interpolator = LinearInterpolator()
            rotationBy(COMPLETE_SPIN)
            withEndAction { newLambda() }
            start()
        }
    }
}