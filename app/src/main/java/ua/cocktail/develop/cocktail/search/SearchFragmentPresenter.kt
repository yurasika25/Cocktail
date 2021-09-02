package ua.cocktail.develop.cocktail.search

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class SearchFragmentPresenter : BasicPresenter<SearchFragmentView?>() {
    fun onClickBtnConfirm() {
        getView()?.changesToDo()
    }
}

