package com.example.currencyconverter.data.server

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyDbService {

    @GET("latest")
    fun getAllCurrencies(@Query("base") base: String, @Query("symbols") symbols: String): Deferred<List<Currency>>
}