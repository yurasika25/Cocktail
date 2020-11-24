package ru.startandroid.develop.cocktail.drinks

import ru.startandroid.develop.cocktail.mvp.BasicPresenter

class DrinksFragmentPresenter : BasicPresenter<DrinksFragmentView?>(){
    fun onVectorButtonClicked(){
        getView()?.navigateToFilters()
    }
}