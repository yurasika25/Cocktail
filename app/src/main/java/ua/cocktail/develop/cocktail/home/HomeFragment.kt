package ua.cocktail.develop.cocktail.home

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_home.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.bali.BaliFragment
import ua.cocktail.develop.cocktail.bonus.BonusFragment
import ua.cocktail.develop.cocktail.cashflow.CashFragment
import ua.cocktail.develop.cocktail.utils.Constants.Companion.CAMERA_REQUEST
import ua.cocktail.develop.cocktail.utils.Constants.Companion.MY_CAMERA_PERMISSION_CODE


class HomeFragment : Fragment(), HomeFragmentView {

    private var presenter: HomeFragmentPresenter? = null

    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }


    override fun navigateToBonus() {
        val fragment: Fragment = BonusFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun navigateToHome() {
        val fragment: Fragment = HomeFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.containerNavigation, fragment)
        ft.commit()
    }

    override fun navigateToCash() {
        val fragment: Fragment = CashFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun navigateToBali() {
        val fragment: Fragment = BaliFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        presenter = HomeFragmentPresenter()

        val swipeS = view.findViewById<SwipeRefreshLayout>(R.id.swipe_id)
        swipeS.setOnRefreshListener {
            Handler ().postDelayed({
                swipeS.isRefreshing = true},1000)
            presenter!!.pullToRefreshReceived()
        }


        val btnBonus = view.findViewById<ImageView>(R.id.bonus_btn_id)
        btnBonus.setOnClickListener {
            presenter!!.onBonusButtonClicked()
        }

        val photoButton = view.findViewById<View>(R.id.vector_scan_ID)
        photoButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ){
                requestPermissions(
                    arrayOf(android.Manifest.permission.CAMERA),
                    MY_CAMERA_PERMISSION_CODE
                )
                }else {
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMERA_REQUEST)
                }
        }

        return view
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMERA_REQUEST)
            } else {
                Toast.makeText(requireActivity(),"camera permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }
    companion object {
        private const val CAMERA_REQUEST = 1888
        private const val MY_CAMERA_PERMISSION_CODE = 100
    }
}


