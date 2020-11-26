package ru.startandroid.develop.cocktail.network.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.startandroid.develop.cocktail.utils.Constants.Companion.BASE_URL

object RetrofitInstance {

    private val retrofit by lazy {
       Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }

    val API: Api by lazy {
        retrofit.create(Api::class.java)
    }
}