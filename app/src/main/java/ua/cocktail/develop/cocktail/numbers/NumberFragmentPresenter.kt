package ua.cocktail.develop.cocktail.numbers

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.cocktail.develop.cocktail.mvp.BasicPresenter
import ua.cocktail.develop.cocktail.network.model.NumbersModel
import ua.cocktail.develop.cocktail.network.repository.Repository

class NumberFragmentPresenter : BasicPresenter<NumberFragmentView?>() {

    private val listItems = mutableListOf<NumbersModel>()
    var repo = Repository()

    override fun onEnterScope() {
        super.onEnterScope()
        fetchData()
    }

    @SuppressLint("CheckResult")
    private fun fetchData() {
        listItems.clear()
        repo.getNumbers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                result.forEach {
                    listItems.add(it)
                }
                getView()?.setUpUI(listItems)
            }, { error -> error.printStackTrace() })
    }
}