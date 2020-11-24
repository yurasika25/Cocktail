package ru.startandroid.develop.cocktail.main

import ru.startandroid.develop.cocktail.mvp.BasicPresenter

class MainPresenter : BasicPresenter<MainView?>() {

    override fun onEnterScope() {
        super.onEnterScope()
        getView()?.onNavigateToDrinksFragment()
    }
}

