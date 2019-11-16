package com.example.currencyconverter.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Currency::class, Rate::class], version = 1, exportSchema = false)
abstract class CurrencyDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            CurrencyDatabase::class.java,
            "currency-db"
        ).build()
    }

    abstract fun currencyDao(): CurrencyDAO
    abstract fun rateDao(): RateDAO
}