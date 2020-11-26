package ru.startandroid.develop.cocktail.drinks

import ru.startandroid.develop.cocktail.mvp.BasicView
import ru.startandroid.develop.cocktail.network.model.DrinksModel

interface DrinksFragmentView : BasicView{
    fun navigateToFilters(filters :  HashMap<String, Boolean>)
    fun setUpUI(data : List<DrinksModel>)
}