package com.example.brewery

import androidx.room.Room
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.brewery.Model.Brewery
import com.example.brewery.Persistence.BreweryDatabase
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class Db {
    private lateinit var database: BreweryDatabase

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

    @Test
    fun testBasicFunctions() = runBlocking {
        var berweryDatabase = database.breweryDao();
        val brewery = Brewery(name = "test_brewery");
        berweryDatabase.insertBrewery(brewery);

        val getBrewery = berweryDatabase.getBreweries();
        Assert.assertThat(getBrewery[0].name, CoreMatchers.`is`("test_brewery"))
    }
}