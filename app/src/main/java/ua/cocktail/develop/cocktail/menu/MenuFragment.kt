package ua.cocktail.develop.cocktail.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.bali.BaliFragment
import ua.cocktail.develop.cocktail.cashflow.CashFragment
import ua.cocktail.develop.cocktail.help.HelpFragment
import ua.cocktail.develop.cocktail.charity.CharityFragment
import ua.cocktail.develop.cocktail.numbers.NumberFragment
import ua.cocktail.develop.cocktail.personinfo.PersonFragment
import ua.cocktail.develop.cocktail.support.SupportFragment
import ua.cocktail.develop.cocktail.rules.RulesFragment
import ua.cocktail.develop.cocktail.shop.ShopFragment

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MenuFragmentPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragmet_menu, container, false)

        presenter = MenuFragmentPresenter()

        val btnBill = view.findViewById<View>(R.id.card_id_button_bill)
        btnBill.setOnClickListener {
            presenter!!.onBillButtonClicked()
        }
        val btnSupport = view.findViewById<View>(R.id.card_id_btn_support)
        btnSupport.setOnClickListener {
            presenter!!.onSupportBtnClicked()
        }
        val btnCharity = view.findViewById<View>(R.id.card_id_btn_charity)
        btnCharity.setOnClickListener {
            presenter!!.onSharityBtnClicked()
        }
        val btnPayCard = view.findViewById<View>(R.id.card_id_btn_pay_cards)
        btnPayCard.setOnClickListener {
            presenter!!.onPayCardsInfoBtnClicked()
        }
        val btnOrdersInfo = view.findViewById<View>(R.id.card_id_btn_orders_info)
        btnOrdersInfo.setOnClickListener {
            presenter!!.onOrdersInfoBtnClicked()
        }
        val btnBonus = view.findViewById<View>(R.id.card_id_btn_bonus)
        btnBonus.setOnClickListener {
            presenter!!.onCashButtonClicked()
        }
        val btnBali = view.findViewById<View>(R.id.card_id_btn_bali)
        btnBali.setOnClickListener {
            presenter!!.onBaliButtonClicked()
        }
        val btnPersonInfo = view.findViewById<View>(R.id.card_id_btn_person_info)
        btnPersonInfo.setOnClickListener {
            presenter!!.onPersonButtonClicked()
        }
        return view
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
        val fragment: Fragment = CharityFragment()
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

}


