package com.example.brewery.UI.main

import androidx.annotation.WorkerThread
import com.example.brewery.Model.Brewery
import com.example.brewery.Network.BreweryService
import com.example.brewery.Persistence.BreweryDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val breweryService: BreweryService,
    private val breweryDao: BreweryDao
) {
    @WorkerThread
    fun loadBreweries(
        onStart: () -> Unit,
        onCompletion: () -> Unit
    ) = flow {
        val breweries: List<Brewery>? = breweryService.getBreweryList().execute().body()
        emit(breweries)
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)

    fun add(brewery: Brewery)
    {
        GlobalScope.launch{
            breweryDao.insertBrewery(brewery)
        }
    }
}