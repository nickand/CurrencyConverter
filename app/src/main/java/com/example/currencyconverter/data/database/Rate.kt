package com.example.currencyconverter.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rate(
    @PrimaryKey(autoGenerate = true)
    val rateId: Int? = 0,
    val eur: Double? = 0.0,
    val jpy: Double? = 0.0,
    val brl: Double? = 0.0,
    val gbp: Double? = 0.0
){
    constructor() : this(1,0.0,0.0,0.0,0.0)
}