package ua.cocktail.develop.cocktail.menu

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragmet_menu.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.bali.BaliFragment
import ua.cocktail.develop.cocktail.cashflow.CashFragment
import ua.cocktail.develop.cocktail.charity.CharityFragment
import ua.cocktail.develop.cocktail.numbers.NumberFragment
import ua.cocktail.develop.cocktail.personinfo.PersonFragment
import ua.cocktail.develop.cocktail.rules.RulesFragment
import ua.cocktail.develop.cocktail.search.SearchFragment
import ua.cocktail.develop.cocktail.shop.ShopFragment
import ua.cocktail.develop.cocktail.support.SupportFragment
import ua.cocktail.develop.cocktail.utils.Constants

class MenuFragment : Fragment(), MenuFragmentView {

    private var presenter: MenuFragmentPresenter? = null

    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragmet_menu, container, false)

        presenter = MenuFragmentPresenter()

        val photoButton = view.findViewById<View>(R.id.card_id_button_camera)
        photoButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    arrayOf(android.Manifest.permission.CAMERA),
                    Constants.MY_CAMERA_PERMISSION_CODE
                )
            } else {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, Constants.CAMERA_REQUEST)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_id_btn_bill.setOnClickListener {
            presenter!!.onBillButtonClicked()
        }
        card_id_btn_support.setOnClickListener {
            presenter!!.onSupportBtnClicked()
        }
        card_id_btn_charity.setOnClickListener {
            presenter!!.onSharityBtnClicked()
        }
        card_id_btn_pay_cards.setOnClickListener {
            presenter!!.onPayCardsInfoBtnClicked()
        }
        card_id_btn_orders_info.setOnClickListener {
            presenter!!.onOrdersInfoBtnClicked()
        }
        card_id_btn_bonus.setOnClickListener {
            presenter!!.onCashButtonClicked()
        }
        card_id_btn_bali.setOnClickListener {
            presenter!!.onBaliButtonClicked()
        }
        card_id_btn_person_info.setOnClickListener {
            presenter!!.onPersonButtonClicked()
        }
        card_id_button_search.setOnClickListener {
            presenter!!.onSearchButtonClicked()
        }
    }

    override fun navigateToRules() {
        val fragment: Fragment = RulesFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun navigateToSupport() {
        val fragment: Fragment = SupportFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun navigateToCharity() {
        val fragment: Fragment = CharityFragment("Як допомогти?")
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun navigateToNumber() {
        val fragment: Fragment = NumberFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun navigateToShop() {
        val fragment: Fragment = ShopFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.containerNavigation, fragment)
        ft.addToBackStack(null)
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

    override fun navigateToPerson() {
        val fragment: Fragment = PersonFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun navigateToSearch() {
        val fragment: Fragment = SearchFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == Constants.MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, Constants.CAMERA_REQUEST)
            } else {
                Toast.makeText(requireActivity(), "camera permission denied", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}


