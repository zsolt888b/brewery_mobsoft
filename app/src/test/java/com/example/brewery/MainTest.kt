package com.example.brewery

import com.example.brewery.DI.NetworkConfig
import com.example.brewery.Network.BreweryService
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MainTest@Inject constructor(
    private val breweryService: BreweryService
) {

    @Test
    fun getMainTest() = runBlockingTest {
        val apiResponse = breweryService.getBreweryList();
        val result = apiResponse.execute();
        assertTrue(result.isSuccessful);
    }
}