package com.example.currencyconverter.data.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(
    val id: Int,
    @SerializedName("rates")
    val rates: Rate?,
    val base: String,
    val date: String
) : Parcelable

@Parcelize
data class Rate(
    val rateId: Int,
    @SerializedName("EUR")
    val eur: Double,
    @SerializedName("JPY")
    val jpy: Double,
    @SerializedName("BRL")
    val brl: Double,
    @SerializedName("GBP")
    val gbp: Double
) : Parcelable