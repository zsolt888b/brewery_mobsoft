package com.example.brewery.DI

import com.example.brewery.Network.BreweryService
import com.example.brewery.Persistence.BreweryDao
import com.example.brewery.UI.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideRepository(
        breweryService: BreweryService,
        breweryDao: BreweryDao
    ): MainRepository {
        return MainRepository(breweryService, breweryDao)
    }
}