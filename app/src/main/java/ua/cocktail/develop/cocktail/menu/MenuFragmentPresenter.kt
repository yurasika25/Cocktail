package ua.cocktail.develop.cocktail.menu

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class MenuFragmentPresenter : BasicPresenter<MenuFragmentView?>(){


    fun onBillButtonClicked (){
        getView()?.navigateToRules()
    }
    fun onSupportBtnClicked (){
        getView()?.navigateToSupport()
    }

    fun onSharityBtnClicked (){
        getView()?.navigateToCharity()
    }

    fun onPayCardsInfoBtnClicked (){
        getView()?.navigateToNumber()
    }

    fun onOrdersInfoBtnClicked (){
        getView()?.navigateToShop()
    }

    fun onCashButtonClicked(){
        getView()?.navigateToCash()
    }

    fun onBaliButtonClicked(){
        getView()?.navigateToBali()
    }

    fun onPersonButtonClicked(){
        getView()?.navigateToPerson()
    }

    fun onSearchButtonClicked() {
        getView()?.navigateToSearch()
    }
}

