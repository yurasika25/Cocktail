package ua.cocktail.develop.cocktail.main

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class MainPresenter : BasicPresenter<MainView?>() {

    override fun onEnterScope() {
        super.onEnterScope()
        getView()?.onNavigateToMainFragment()
    }
}

