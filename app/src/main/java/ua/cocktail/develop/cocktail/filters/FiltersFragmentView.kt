package ua.cocktail.develop.cocktail.filters

import ua.cocktail.develop.cocktail.mvp.BasicView

interface FiltersFragmentView : BasicView {

    fun setUpUI()
    fun getFilterMap(): HashMap<String, Boolean>
    fun goBackToCocktails(data: HashMap<String, Boolean>)
}