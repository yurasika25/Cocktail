package ua.cocktail.develop.cocktail.bonus

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class BonusFragmentPresenter : BasicPresenter<BonusFragmentView?>(){

    fun onNavigateClickRules(){
        getView()?.navigateToRules()
    }
}

