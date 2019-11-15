package com.example.data.source

import com.example.domain.Currency

interface RemoteDataSource {
    suspend fun getLatestCurrencies(region: String): List<Currency>
}