package ua.cocktail.develop.cocktail.network.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ua.cocktail.develop.cocktail.utils.Constants.Companion.BASE_URL
import ua.cocktail.develop.cocktail.utils.Constants.Companion.BASE_URL_TWO

object RetrofitInstance {

    private val retrofit by lazy {
       Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }
    val API_ONE: Api by lazy {
        retrofit.create(Api::class.java)
    }

    private val retrofitTwo by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_TWO)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API_TWO: Api by lazy {
        retrofitTwo.create(Api::class.java)
    }
}