package ua.cocktail.develop.cocktail.network.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ua.cocktail.develop.cocktail.network.model.DrinksResponse
import ua.cocktail.develop.cocktail.network.model.FiltersResponse
import ua.cocktail.develop.cocktail.network.model.NumbersModel

interface Api {

    @GET("/api/json/v1/1/filter.php?")
     fun getDrinks(@Query("c") filter: String): Observable<DrinksResponse>

    @GET("api/json/v1/1/list.php?")
    fun getFilters(@Query("c") list: String): Observable<FiltersResponse>

    @GET("/posts")
    fun getNumbers (): Observable<List<NumbersModel>>

}