package ua.cocktail.develop.cocktail.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.rules.RulesFragment

class MenuFragment : Fragment(), MenuFragmentView {


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: MenuFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragmet_menu, container, false)

        presenter = MenuFragmentPresenter()

        return view
    }
}

//    override fun navigateToRules() {
//        val fragment: Fragment = RulesFragment()
//        val fm = requireActivity().supportFragmentManager
//        val ft = fm.beginTransaction()
//        ft.replace(R.id.mainContainer, fragment)
//        ft.commit()
//    }
//}


