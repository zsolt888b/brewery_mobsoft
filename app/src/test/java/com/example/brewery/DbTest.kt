package com.example.brewery

import com.example.brewery.Model.Brewery
import com.example.brewery.Persistence.BreweryDao
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class DbTest: Db() {
    private lateinit var breweryDao: BreweryDao

    @Before
    fun init() {
        breweryDao = database.breweryDao()
    }

    @Test
    fun testBasicFunctions() = runBlocking {
        val brewery = Brewery(name = "test_brewery");
        breweryDao.insertBrewery(brewery);

        val getBrewery = breweryDao.getBreweries();
        assertThat(getBrewery[0].name, `is`("test_brewery"))
    }

}