package com.example.currencyconverter.data

import com.example.domain.Currency
import com.example.currencyconverter.data.database.Currency as DomainCurrency
import com.example.currencyconverter.data.server.Currency as ServerCurrency

fun Currency.toRoomCurrency(): DomainCurrency =
    DomainCurrency(
        id,
        rates,
        base,
        date
    )

fun DomainCurrency.toDomainCurrency(): Currency =
    Currency(
        id,
        rates,
        base,
        date
    )

fun ServerCurrency.toDomainCurrency(): Currency =
    Currency(
        id,
        null,
        base,
        date
    )