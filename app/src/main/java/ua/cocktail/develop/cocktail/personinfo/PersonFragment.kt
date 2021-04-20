package ua.cocktail.develop.cocktail.personinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R

class PersonFragment : Fragment(), PersonFragmentView {


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: PersonFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_person, container, false)

        presenter = PersonFragmentPresenter()

        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarCash)
        tBar.setNavigationOnClickListener { requireActivity().onBackPressed()

        }
        return view
    }
}


