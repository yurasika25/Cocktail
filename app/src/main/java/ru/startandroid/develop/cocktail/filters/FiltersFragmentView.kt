package ru.startandroid.develop.cocktail.filters

import ru.startandroid.develop.cocktail.mvp.BasicView
import ru.startandroid.develop.cocktail.network.model.FiltersModel

interface FiltersFragmentView : BasicView {
    fun setUpUI()
    fun getFilterMap() :  HashMap<String, Boolean>
    fun goBackToCocktails(data : HashMap<String, Boolean>)
}