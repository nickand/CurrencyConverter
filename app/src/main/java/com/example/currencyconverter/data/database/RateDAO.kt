package com.example.currencyconverter.data.database

import androidx.room.*

@Dao
interface RateDAO {

    @Query("SELECT * FROM Rate")
    fun getAll(): MutableList<Rate>

    @Query("SELECT * FROM Rate WHERE rateId = :id")
    fun findById(id: Int): Rate

    @Query("SELECT COUNT(rateId) FROM Rate")
    fun rateCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRates(rates: List<Rate>)
}