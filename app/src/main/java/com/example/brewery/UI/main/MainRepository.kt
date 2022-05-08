package com.example.brewery.UI.main

import com.example.brewery.Network.BreweryService
import com.example.brewery.Persistence.BreweryDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    brweryService: BreweryService,
    breweryDao: BreweryDao
) {}