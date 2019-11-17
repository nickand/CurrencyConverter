package com.example.currencyconverter.data

import com.example.domain.Currency
import com.example.currencyconverter.data.database.Currency as DomainCurrency
import com.example.currencyconverter.data.server.Currency as ServerCurrency
import com.example.currencyconverter.data.server.Rate as ServerRate
import com.example.domain.Rate as DomainRate

fun Currency.toRoomCurrency(): DomainCurrency =
    DomainCurrency(
        id,
        getRateData(rates),
        base,
        date
    )

fun DomainCurrency.toDomainCurrency(): Currency =
    Currency(
        id,
        getRateData(this.rates),
        base,
        date
    )

fun ServerCurrency.toDomainCurrency(): Currency =
    Currency(
        id,
        getRateData(this.rates),
        base,
        date
    )

fun DomainRate.toRoomRate(): DomainRate {
    return DomainRate(rateId, eur, jpy, brl, gbp)
}

fun DomainRate.toDomainRate(): DomainRate {
    return DomainRate(rateId, eur, jpy, brl, gbp)
}

fun ServerRate.toDomainRate(): DomainRate {
    return DomainRate(rateId, eur, jpy, brl, gbp)
}

fun getRateData(rate: DomainRate?): DomainRate? {
    rate?.let {
        return DomainRate(
            it.rateId,
            it.eur,
            it.jpy,
            it.brl,
            it.gbp
        )
    }
    return null
}

fun getRateData(rate: ServerRate?): DomainRate? {
    rate?.let {
        return DomainRate(
            it.rateId,
            it.eur,
            it.jpy,
            it.brl,
            it.gbp
        )
    }
    return null
}