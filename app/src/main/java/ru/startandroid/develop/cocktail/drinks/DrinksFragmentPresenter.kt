package ru.startandroid.develop.cocktail.drinks

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.startandroid.develop.cocktail.mvp.BasicPresenter
import ru.startandroid.develop.cocktail.network.model.DrinksModel
import ru.startandroid.develop.cocktail.network.model.FiltersModel
import ru.startandroid.develop.cocktail.network.repository.Repository

class DrinksFragmentPresenter : BasicPresenter<DrinksFragmentView?>() {

    private val drinksList = mutableListOf<DrinksModel>()
    private val filterList = mutableListOf<FiltersModel>()
    private var filtersMap : HashMap<String, Boolean> = HashMap()
    var reposit = Repository()

    override fun onEnterScope() {
        super.onEnterScope()
        fetchFiltersData()
        fetchDrinksData("Ordinary Drink")
    }

    fun onFilterButtonClicked() {
        filterList.forEach {
            filtersMap.put(it.strCategory, false)
        }
        getView()?.navigateToFilters(filtersMap)
    }

     fun fetchDrinksData(orderFilter : String) {
        drinksList.clear()
        reposit.getDrinks(orderFilter)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                drinksList.addAll(result.drinks)
                getView()?.setUpUI(drinksList)
                Log.d("Result", "Success")
            }, { error ->
                error.printStackTrace()
            })
    }

    private fun fetchFiltersData() {
        drinksList.clear()
        reposit.getFilters()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                filterList.addAll(result.drinks)
                getView()?.setUpUI(drinksList)
                Log.d("Result", "Success")
            }, { error ->
                error.printStackTrace()
            })
    }

    fun onApplyFiltersReceived(map : HashMap<String, Boolean>)
    {
        filtersMap.clear()
        filtersMap = map
    }
}

