package ua.cocktail.develop.cocktail.bali

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R

class BaliFragment : Fragment(), BaliFragmentView {

    private lateinit var cameraManager: CameraManager

    private var imageFlashlight: ImageView? = null
    private var flashLightStatus = false


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: BaliFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_bali, container, false)

        presenter = BaliFragmentPresenter()

        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarBali)
        tBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        imageFlashlight = view.findViewById<View>(R.id.imageFlashlight) as ImageView

        val hasCameraFlash =
            requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
        val isEnabled =
            (context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) }
                    == PackageManager.PERMISSION_GRANTED)
        imageFlashlight!!.isEnabled = isEnabled
        imageFlashlight!!.setOnClickListener {
            if (hasCameraFlash) {
                if (flashLightStatus) flashLightOff() else flashLightOn()
            } else {
                flashLightOff()
            }
        }
        return view
    }



    private fun flashLightOn() {
        cameraManager = context?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            val cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId, true)
            flashLightStatus = true
            imageFlashlight!!.setImageResource(R.drawable.ic_flas_two)
        } catch (ignored: CameraAccessException) {
        }
    }

    private fun flashLightOff() {
        cameraManager = context?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            val cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId, false)
            flashLightStatus = false
            imageFlashlight!!.setImageResource(R.drawable.ic_flas_one)
        } catch (ignored: CameraAccessException) {
        }
    }
}


