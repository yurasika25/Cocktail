package ua.cocktail.develop.cocktail.delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_delivery.*
import ua.cocktail.develop.cocktail.R

class DeliveryFragment : Fragment(), RegisterFragmentView {

    private var fragmentPresenter: DeliveryFragmentPresenter? = null

    override fun onResume() {
        super.onResume()
        fragmentPresenter?.enterWithView(this)
    }

    override fun onPause() {
        super.onPause()
        fragmentPresenter?.exitFromView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_delivery, container, false)
        fragmentPresenter = DeliveryFragmentPresenter()
        return view
    }

    override fun setUpUI() {
        button_confirm.setOnClickListener {
            button_confirm.isEnabled = false
        }
    }
}