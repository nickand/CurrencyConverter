package com.example.currencyconverter.data.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.Rate

@Entity
data class Currency(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Embedded val rates: Rate?,
    val base: String,
    val date: String
)