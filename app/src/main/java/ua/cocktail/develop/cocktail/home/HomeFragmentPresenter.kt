package ua.cocktail.develop.cocktail.home

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class HomeFragmentPresenter : BasicPresenter<HomeFragmentView?>(){

    fun onBonusButtonClicked (){
        getView()?.navigateToBonus()
    }

    fun pullToRefreshReceived(){
        getView()?.navigateToHome()
    }

    fun onCashButtonClicked(){
        getView()?.navigateToCash()
    }

    fun onBaliButtonClicked(){
        getView()?.navigateToBali()
    }
}
