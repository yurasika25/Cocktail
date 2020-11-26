package ua.cocktail.develop.cocktail.network.repository

import io.reactivex.Observable
import ua.cocktail.develop.cocktail.network.api.RetrofitInstance
import ua.cocktail.develop.cocktail.network.model.DrinksResponse
import ua.cocktail.develop.cocktail.network.model.FiltersResponse

const val FILTER_KEY = "list"

class Repository {

    fun getDrinks(filter : String): Observable<DrinksResponse> {
        return RetrofitInstance.API.getDrinks(filter)

    }

    fun getFilters(): Observable<FiltersResponse> {
        return RetrofitInstance.API.getFilters(FILTER_KEY)
    }
}

