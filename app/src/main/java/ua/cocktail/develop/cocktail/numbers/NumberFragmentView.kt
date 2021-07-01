package ua.cocktail.develop.cocktail.numbers

import ua.cocktail.develop.cocktail.mvp.BasicView
import ua.cocktail.develop.cocktail.network.model.NumbersModel

interface NumberFragmentView : BasicView {

    fun setUpUI(data : List<NumbersModel>)
}