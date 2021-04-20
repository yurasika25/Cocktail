package ua.cocktail.develop.cocktail.menu

import ua.cocktail.develop.cocktail.mvp.BasicView

interface MenuFragmentView : BasicView {

    fun navigateToRules()
    fun navigateToSupport()
    fun navigateToCharity()
    fun navigateToNumber()
    fun navigateToShop()
    fun navigateToCash ()
    fun navigateToBali ()
    fun navigateToPerson ()



}