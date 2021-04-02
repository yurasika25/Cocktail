package ua.cocktail.develop.cocktail.delivery

import ua.cocktail.develop.cocktail.mvp.BasicPresenter

class DeliveryFragmentPresenter : BasicPresenter<RegisterFragmentView?>()

{
    override fun onEnterScope() {
        super.onEnterScope()
        getView()?.setUpUI()
    }
}