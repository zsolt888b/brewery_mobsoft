package com.example.brewery.Persistence

import androidx.room.*
import com.example.brewery.Model.Brewery

@Dao
interface BreweryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBrewery(brewery: Brewery)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBrewery(brewery: Brewery)

    @Delete
    fun deleteBrewery(brewery: Brewery)

    @Query("SELECT * FROM Brewery")
    fun getBreweries(): List<Brewery>

    @Query("SELECT * FROM Brewery WHERE name = :id")
    fun findById(id: String): Brewery?
}

