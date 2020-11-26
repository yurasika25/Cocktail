package ru.startandroid.develop.cocktail.drinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_drinks.*
import ru.startandroid.develop.cocktail.R
import ru.startandroid.develop.cocktail.adapter.DrinksAdapter
import ru.startandroid.develop.cocktail.filters.FilterMapCallback
import ru.startandroid.develop.cocktail.filters.FiltersFragment
import ru.startandroid.develop.cocktail.network.model.DrinksModel

class DrinksFragment : Fragment (), DrinksFragmentView, FilterMapCallback {

    private var presenter: DrinksFragmentPresenter? = null

    companion object {
        fun newInstance(): DrinksFragment {
            val args = Bundle()
            val fragment = DrinksFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.exitFromView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter?.enterWithView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_drinks, container, false)
        presenter = DrinksFragmentPresenter()
        val toolBar = view.findViewById<Toolbar>(R.id.toolbar)
        toolBar.setOnMenuItemClickListener {
            presenter!!.onFilterButtonClicked()
            true
        }
        return view
    }

    override fun navigateToFilters(filters :  HashMap<String, Boolean>) {
        val fragment: Fragment = FiltersFragment.newInstance(filters)
        val fm = childFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.drinksContainer, fragment)
        ft.commit()
    }

    override fun setUpUI(data: List<DrinksModel>) {
        drinksRV.setHasFixedSize(true)
        val adapter = DrinksAdapter()
        drinksRV.adapter = adapter
        (drinksRV.adapter as DrinksAdapter).addData(data)
    }

    override fun onApplyClicked(filterMap: HashMap<String, Boolean>) {
        presenter!!.onApplyFiltersReceived(filterMap)
    }
}