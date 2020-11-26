package ru.startandroid.develop.cocktail.filters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_filters.*
import ru.startandroid.develop.cocktail.R
import ru.startandroid.develop.cocktail.adapter.CheckboxFilterCallback
import ru.startandroid.develop.cocktail.adapter.FilterAdapter

const val FILTER_MAP = "filter_map"

class FiltersFragment : Fragment(), FiltersFragmentView, CheckboxFilterCallback {

    private var presenter: FiltersFragmentPresenter? = null
    private lateinit var callBack: FilterMapCallback

    companion object {
        fun newInstance(filters: HashMap<String, Boolean>): FiltersFragment {
            val args = Bundle()
            args.putSerializable(FILTER_MAP, filters)
            val fragment = FiltersFragment()
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        require(parentFragment is FilterMapCallback) { "$context should implements FilterMapCallback" }
        callBack = parentFragment as FilterMapCallback
    }

    override fun setUpUI() {
        filterRV.setHasFixedSize(true)
        val adapter = FilterAdapter(this)
        filterRV.adapter = adapter
        val filtersMap = requireArguments().getSerializable(FILTER_MAP) as HashMap<String, Boolean>
        (filterRV.adapter as FilterAdapter).addData(filtersMap)
        applyFilterB.setOnClickListener { presenter!!.onApplyFiltersClicked() }
    }

    override fun onCheckboxFilterClicked(filter: String, isChecked: Boolean) {
        presenter!!.onFiltersReceived(filter, isChecked)
    }

    override fun goBackToCocktails(data: HashMap<String, Boolean>) {
        callBack.onApplyClicked(data)
        requireActivity().onBackPressed()
    }

    override fun getFilterMap(): HashMap<String, Boolean> {
        return requireArguments().getSerializable(FILTER_MAP) as HashMap<String, Boolean>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_filters, container, false)
        presenter = FiltersFragmentPresenter()
        val toolBarFilter = view.findViewById<Toolbar>(R.id.filterToolbar)
        toolBarFilter.setNavigationOnClickListener { requireActivity().onBackPressed() }
        return view
    }

}

interface FilterMapCallback {
    fun onApplyClicked(filterMap: HashMap<String, Boolean>)
}
