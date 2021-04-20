package ua.cocktail.develop.cocktail.drinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_drinks.*
import ua.cocktail.develop.cocktail.adapter.DrinksAdapter
import ua.cocktail.develop.cocktail.filters.FilterMapCallback
import ua.cocktail.develop.cocktail.filters.FiltersFragment

import ua.cocktail.develop.cocktail.R

class DrinksFragment : Fragment(), DrinksFragmentView,
    FilterMapCallback {

    private var presenter: DrinksFragmentPresenter? = null
    private var adapter: DrinksAdapter? = null

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

    override fun navigateToFilters(filters: HashMap<String, Boolean>) {
        val fragment: Fragment = FiltersFragment.newInstance(this, filters)
        val fm = parentFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

//    override fun navigateToFiltersTwo() {
//        val fragment: Fragment = FragmentRegister()
//        val fm = requireActivity().supportFragmentManager
//        val ft = fm.beginTransaction()
//        ft.replace(R.id.containerNavigation, fragment)
//        ft.addToBackStack(null)
//        ft.commit()
//    }

    override fun setUpUI() {
        adapter = DrinksAdapter()
        drinksRV.adapter = adapter
        drinksRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as? LinearLayoutManager ?: return
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

                if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                    presenter?.updatePageReceived()
                }
            }
        })
    }

    override fun setData(data: List<Any>) {
        adapter?.setData(data)
    }

    override fun onApplyClicked(filterMap: HashMap<String, Boolean>) {
        presenter!!.onApplyFiltersReceived(filterMap)
    }
}