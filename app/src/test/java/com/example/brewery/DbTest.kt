package com.example.brewery

import com.example.brewery.Mock.MockDb
import com.example.brewery.Model.Brewery
import com.example.brewery.Persistence.BreweryDao
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class DbTest : MockDb() {
    private lateinit var breweryDao: BreweryDao

    @Before
    fun init(){
        breweryDao = database.breweryDao()
    }

    @Test
    fun insertAndLoadRecipeListTest() = runBlocking {
        var brewery = Brewery(name = "Test_Brewery");
        breweryDao.insertBrewery(brewery);

        val getBrwery = breweryDao.getBreweries()
        assertThat(getBrwery[0].name, `is`("Test_Brewery"))
    }
}