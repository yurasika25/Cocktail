package ru.startandroid.develop.cocktail.drinks

import android.os.Bundle
import androidx.fragment.app.Fragment

class DrinksFragment : Fragment (), DrinksFragmentView {
    private var presenter: DrinksFragmentPresenter? = null

    companion object{
        fun newInstance(): DrinksFragment{
            val args = Bundle()
            val fragment = DrinksFragment ()
            fragment.arguments = args
            return fragment
        }
    }



}