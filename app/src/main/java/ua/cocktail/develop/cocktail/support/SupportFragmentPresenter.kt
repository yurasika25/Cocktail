package ua.cocktail.develop.cocktail.support

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class SupportFragmentPresenter : BasicPresenter<SupportFragmentView?>(){


    override fun onEnterScope() {
        super.onEnterScope()
        getView()?.setUpUI()
    }
}

