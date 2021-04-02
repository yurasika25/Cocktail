package ua.cocktail.develop.cocktail.bonus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.rules.RulesFragment

class BonusFragment : Fragment(), BonusFragmentView {


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: BonusFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_bonus, container, false)

        presenter = BonusFragmentPresenter()

        val btnRules = view.findViewById<Button>(R.id.btn_rules_id)
        btnRules.setOnClickListener { presenter!!.onNavigateClickRules() }

        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarBonus)

        tBar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        return view
    }

    override fun navigateToRules() {
        val fragment: Fragment = RulesFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.commit()
    }
}


