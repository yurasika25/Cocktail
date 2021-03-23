package ua.cocktail.develop.cocktail.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R

class ShopFragment : Fragment(), ShopFragmentView {
    private var fragmentPresenter: ShopFragmentPresenter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_delivery, container, false)

//        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarEmpty)
//        tBar.setNavigationOnClickListener { requireActivity().onBackPressed() }

        fragmentPresenter = ShopFragmentPresenter()
        return view
    }

    override fun onPause() {
        super.onPause()
        fragmentPresenter?.exitFromView()

    }

    override fun onResume() {
        super.onResume()
        fragmentPresenter?.enterWithView(this)
    }
}