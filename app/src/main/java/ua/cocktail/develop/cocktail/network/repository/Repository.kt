package ua.cocktail.develop.cocktail.network.repository

import io.reactivex.Observable
import ua.cocktail.develop.cocktail.network.api.RetrofitInstance
import ua.cocktail.develop.cocktail.network.model.DrinksResponse
import ua.cocktail.develop.cocktail.network.model.FiltersResponse
import ua.cocktail.develop.cocktail.network.model.NumbersModel

const val FILTER_KEY = "list"

class Repository {

    fun getDrinks(filter : String): Observable<DrinksResponse> {
        return RetrofitInstance.API_ONE.getDrinks(filter)
    }

    fun getFilters(): Observable<FiltersResponse> {
        return RetrofitInstance.API_ONE.getFilters(FILTER_KEY)
    }
    fun getNumbers (): Observable<List<NumbersModel>> {
        return RetrofitInstance.API_TWO.getNumbers()
    }
}



