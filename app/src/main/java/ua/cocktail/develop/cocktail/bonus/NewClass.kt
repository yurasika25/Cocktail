package ua.cocktail.develop.cocktail.bonus

import android.util.Log

open class NewClass : BonusFragment() {

    override val db: String
        get() = "Not"


    override val info: String
        get() = "Новий метод"

    override fun printInfo(user: BonusFragment) {
        super.printInfo(user)
        Log.d("MyLog", "Test: $info")
    }


}

class Main : NewClass() {}