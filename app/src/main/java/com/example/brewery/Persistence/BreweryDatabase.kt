package com.example.brewery.Persistence
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.brewery.Model.Brewery

@Database(entities = [Brewery::class], version = 1)
abstract class BreweryDatabase: RoomDatabase() {
    abstract fun breweryDao(): BreweryDao
}