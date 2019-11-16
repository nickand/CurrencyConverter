package com.example.currencyconverter.data.server

import com.example.currencyconverter.data.toDomainCurrency
import com.example.data.source.RemoteDataSource
import com.example.domain.Currency

class CurrencyDataSource : RemoteDataSource {
    override suspend fun getLatestCurrencies(base: String): List<Currency> {
        return CurrencyDb.service
            .getAllCurrencies(base, "GBP,EUR,JPY,BRL").await()
            .map { it.toDomainCurrency() }
    }
}