package ua.cocktail.develop.cocktail.charity

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class CharityFragmentPresenter : BasicPresenter<CharityFragmentView?>() {

    fun onNavigateHelpChild() {
        getView()?.navigateToHelp()
    }
}