package ua.cocktail.develop.cocktail.mainfragment

import ua.cocktail.develop.cocktail.mvp.BasicView

interface MainFragmentView : BasicView {

    fun navigateToDelivery()
    fun onNavigateToDrinksFragment()
    fun navigateToHome()
    fun navigateToShop()
    fun setUpUI()
    fun navigateToMenu()


}