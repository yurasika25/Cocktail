package ua.cocktail.develop.cocktail.bonus

import ua.cocktail.develop.cocktail.mvp.BasicView

interface BonusFragmentView : BasicView {

    val info : String

    fun printInfo(user:BonusFragment){
        println(info)
    }


    fun navigateToRules()
}

