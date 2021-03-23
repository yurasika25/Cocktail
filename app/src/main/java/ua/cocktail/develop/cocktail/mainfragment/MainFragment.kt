package ua.cocktail.develop.cocktail.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_navigation_main.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.drinks.DrinksFragment
import ua.cocktail.develop.cocktail.delivery.DeliveryFragment
import ua.cocktail.develop.cocktail.home.HomeFragment


class MainFragment : Fragment(), MainFragmentView {

    private var presenter: MainFragmentPresenter? = null

    companion object {
        fun newInstance(): MainFragment {
            val args = Bundle()
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onPause() {
        super.onPause()
        presenter?.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter?.enterWithView(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_navigation_main, container, false)
        presenter = MainFragmentPresenter()
                val btnFloat  = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        btnFloat.setOnClickListener {
            presenter!!.onNavigateToDrinksFragment()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBottomNav.setOnNavigationItemSelectedListener { item ->
            presenter!!.onNavigationClicked(item)
            true
        }
    }

    override fun navigateToDelivery() {
        val fragment: Fragment = DeliveryFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.containerNavigation, fragment)
        ft.commit()
    }

    override fun navigateToHome() {
        val fragment: Fragment = HomeFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.containerNavigation, fragment)
        ft.commit()

    }
    override fun onNavigateToDrinksFragment() {
        val fragment: Fragment = DrinksFragment.newInstance()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}