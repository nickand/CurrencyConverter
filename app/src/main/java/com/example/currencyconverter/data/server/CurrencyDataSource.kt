package com.example.currencyconverter.data.server

import com.example.currencyconverter.data.toDomainCurrency
import com.example.currencyconverter.data.toDomainRate
import com.example.data.source.RemoteDataSource
import com.example.domain.Currency
import com.example.domain.Rate

class CurrencyDataSource : RemoteDataSource {

    override suspend fun getLatestCurrencies(base: String): Currency {
        return CurrencyDb.service
            .getAllCurrencies(base, "GBP,EUR,JPY,BRL").await()
            .toDomainCurrency()
    }
}