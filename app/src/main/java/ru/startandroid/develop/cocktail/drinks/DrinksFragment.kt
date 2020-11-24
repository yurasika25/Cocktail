package ru.startandroid.develop.cocktail.drinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import ru.startandroid.develop.cocktail.R
import ru.startandroid.develop.cocktail.filters.FiltersFragment

class DrinksFragment : Fragment (), DrinksFragmentView {
    private var presenter: DrinksFragmentPresenter? = null

    companion object {
        fun newInstance(): DrinksFragment {
            val args = Bundle()
            val fragment = DrinksFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onResume() {
        super.onResume()
        presenter?.enterWithView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.container_drinks, container, false)
        presenter = DrinksFragmentPresenter()

        val toolBar = view.findViewById<Toolbar>(R.id.toolbar)
        toolBar.setOnMenuItemClickListener {
            presenter!!.onVectorButtonClicked()
            true
        }
        return view
    }

    override fun navigateToFilters() {
        val fragment: Fragment = FiltersFragment.newInstance()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}