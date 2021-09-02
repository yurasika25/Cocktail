package ua.cocktail.develop.cocktail.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R

class RulesFragment : Fragment(), RulesFragmentView {


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: RulesFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_rules, container, false)

        presenter = RulesFragmentPresenter()

        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarRules)

        tBar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        return view
    }
}


