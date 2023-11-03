package com.yerayyas.horoscopoapp.ui.palmistry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import com.yerayyas.horoscopoapp.databinding.FragmentPalmistryBinding


@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    companion object {
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            //StartCamera
            startCamera()
        } else {
            Toast.makeText(
                requireContext(),
                "Acepta los permisos o vete de mi app",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // Dar permisos
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkCameraPermission()) {
            // Tiene permisos aceptados
            startCamera()

        } else {
            // No los tiene
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(this, cameraSelector, preview)
            }catch (e:Exception){
                Log.e("TRAS", "Algo petó ${e.message}")
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun checkCameraPermission(): Boolean {
        return PermissionChecker
            .checkSelfPermission(
                requireContext(),
                CAMERA_PERMISSION
            ) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}