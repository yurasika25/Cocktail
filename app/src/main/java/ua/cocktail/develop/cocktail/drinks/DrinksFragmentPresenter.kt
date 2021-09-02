package ua.cocktail.develop.cocktail.drinks

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.cocktail.develop.cocktail.mvp.BasicPresenter
import ua.cocktail.develop.cocktail.network.model.FiltersModel
import ua.cocktail.develop.cocktail.network.model.HeaderModel
import ua.cocktail.develop.cocktail.network.repository.Repository
import java.util.ArrayList

class DrinksFragmentPresenter : BasicPresenter<DrinksFragmentView?>() {

    private val drinksList = mutableListOf<Any>()
    private val filterList = mutableMapOf<FiltersModel, Boolean>()
    private val repository = Repository()

    //Paging
    private var currentPage = 0
    private var isLoading = false

    override fun onEnterScope() {
        super.onEnterScope()
        getView()?.setUpUI()
        fetchFiltersData()
    }

    fun onFilterButtonClicked() {
        val filterMap = HashMap<String, Boolean>()
        filterList.forEach {
            filterMap[it.key.strCategory] = filterList[it.key] == true
        }
        getView()?.navigateToFilters(filterMap)
    }

    fun updatePageReceived() {
        val isLastPageReached = currentPage + 1 >= filterList.filter { it.value }.size
        if (isLoading || isLastPageReached || drinksList.isEmpty()) return
        currentPage++
        fetchDrinksData(currentPage)
    }

    @SuppressLint("CheckResult")
    private fun fetchDrinksData(page: Int) {
        isLoading = true
        if (page == 0) {
            drinksList.clear()
        }
        val filter = ArrayList<FiltersModel>()
        filterList.filter { it.value }.forEach {
            filter.add(it.key)
        }
        repository.getDrinks(filter[currentPage].strCategory)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                drinksList.add(HeaderModel(filter[currentPage].strCategory))
                drinksList.addAll(result.drinks)
                getView()?.setData(drinksList)
                isLoading = false
                Log.d("Result", "Success")
            }, { error ->
                isLoading = false
                error.printStackTrace()
            })
    }

    @SuppressLint("CheckResult")
    private fun fetchFiltersData() {
        repository.getFilters()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                result.drinks.forEach {
                    filterList[it] = true
                }
                fetchDrinksData(currentPage)
                Log.d("Result", "Success")
            }, { error ->
                error.printStackTrace()
            })
    }

    fun onApplyFiltersReceived(map: HashMap<String, Boolean>) {
        val filter = ArrayList(filterList.keys)
        filter.forEach {
            if (map.containsKey(it.strCategory)) {
                filterList[it] = map[it.strCategory] == true
            }
        }
        drinksList.clear()
        currentPage = 0
        fetchDrinksData(currentPage)
    }
}

