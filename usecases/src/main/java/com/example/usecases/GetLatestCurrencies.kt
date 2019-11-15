package com.example.usecases

import com.example.data.repository.CurrencyRepository
import com.example.domain.Currency

class GetLatestCurrencies(private val currenciesRepository: CurrencyRepository) {
    suspend fun invoke(): List<Currency> = currenciesRepository.getLatestCurrencies()
}