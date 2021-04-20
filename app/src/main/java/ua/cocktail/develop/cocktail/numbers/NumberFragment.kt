package ua.cocktail.develop.cocktail.numbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_numbers.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.adapter.NumberAdapter
import ua.cocktail.develop.cocktail.network.model.NumbersModel
import java.util.ArrayList

class NumberFragment : Fragment(), NumberFragmentView {

    private var presenter: NumberFragmentPresenter? = null

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
        val view: View = inflater.inflate(R.layout.fragment_numbers, container, false)
        presenter = NumberFragmentPresenter()

        val toolBarNumbers = view.findViewById<Toolbar>(R.id.toolbarNumber)
        toolBarNumbers.setNavigationOnClickListener { requireActivity().onBackPressed() }
        return view
    }

    override fun setUpUI(data: List<NumbersModel>) {
        numberRV.setHasFixedSize(true)
        numberRV.layoutManager = LinearLayoutManager(context)
        val adapter = NumberAdapter()
        numberRV.adapter = adapter
        (numberRV.adapter as NumberAdapter).addNewData (ArrayList(data))
    }
}


