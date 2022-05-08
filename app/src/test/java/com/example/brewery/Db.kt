package com.example.brewery

import androidx.room.Room
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.brewery.Persistence.BreweryDatabase

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class Db {
    lateinit var database: BreweryDatabase

    @Before
    fun initializeDatabase() {
        database = Room.inMemoryDatabaseBuilder(getApplicationContext(), BreweryDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDatabase() {
        database.close()
    }
}