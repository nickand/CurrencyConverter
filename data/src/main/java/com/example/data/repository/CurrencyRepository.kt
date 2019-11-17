package com.example.data.repository

import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.domain.Currency

class CurrencyRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val BASE_CURRENCY: String = "USD"
) {

    suspend fun getLatestCurrencies(): List<Currency> {
        if (localDataSource.isEmpty()) {
            val currencies =
                remoteDataSource.getLatestCurrencies(BASE_CURRENCY)
            localDataSource.saveCurrencies(currencies)
        }

        return localDataSource.getLatestCurrencies()
    }
}