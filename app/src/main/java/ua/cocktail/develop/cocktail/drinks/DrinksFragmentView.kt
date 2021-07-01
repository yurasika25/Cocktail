package ua.cocktail.develop.cocktail.drinks

import ua.cocktail.develop.cocktail.mvp.BasicView

interface DrinksFragmentView : BasicView {

    fun navigateToFilters(filters: HashMap<String, Boolean>)
    fun setUpUI()
    fun setData(data: List<Any>)
}