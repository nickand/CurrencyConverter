package com.example.currencyconverter.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rate(
    @PrimaryKey(autoGenerate = true)
    val rateId: Int,
    val eur: Double,
    val jpy: Double,
    val brl: Double,
    val gbp: Double
)