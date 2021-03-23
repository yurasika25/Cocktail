package ua.cocktail.develop.cocktail.mainfragment

import android.view.MenuItem
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class MainFragmentPresenter : BasicPresenter<MainFragmentView?>(){

    override fun onEnterScope() {
        super.onEnterScope()
        getView()?.navigateToHome()
    }
    fun onNavigateToDrinksFragment(){
        getView()?.onNavigateToDrinksFragment()
    }

    fun onNavigationClicked(item: MenuItem) {
        when (item.itemId) {
            R.id.primaryHome -> {
                getView()?.navigateToHome()
            }

            R.id.primaryDelivery -> {
                getView()?.navigateToDelivery()
            }

            else -> getView()?.navigateToDelivery()
        }
    }
}