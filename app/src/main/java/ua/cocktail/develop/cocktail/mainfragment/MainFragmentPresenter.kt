package ua.cocktail.develop.cocktail.mainfragment

import android.view.MenuItem
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class MainFragmentPresenter : BasicPresenter<MainFragmentView?>(){

    private var lastMenuItem : MenuItem? = null

    override fun onEnterScope() {
        super.onEnterScope()
        getView()?.navigateToHome()
        getView()?.setUpUI()
        lastMenuItem?.let { onNavigationClicked(it) }
    }

    fun onNavigateToDrinksFragment(){
        getView()?.onNavigateToDrinksFragment()
    }

    fun onNavigationClicked(item: MenuItem) {
        lastMenuItem = item
        when (item.itemId) {
            R.id.primaryHome -> {
                getView()?.navigateToHome()
            }
            R.id.primaryDelivery -> {
                getView()?.navigateToDelivery()
            }
            R.id.primaryShopping -> {
                getView()?.navigateToShop()
            }
            R.id.primaryMenu -> {
                getView()?.navigateToMenu()
            }
        }
    }
}