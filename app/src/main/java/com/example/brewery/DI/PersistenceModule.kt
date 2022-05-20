package com.example.brewery.DI

import android.app.Application
import androidx.room.Room
import com.example.brewery.BreweryApp
import com.example.brewery.Persistence.BreweryDao
import com.example.brewery.Persistence.BreweryDatabase
import com.example.brewery.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): BreweryDatabase {
        return Room
            .databaseBuilder(
                application,
                BreweryDatabase::class.java,
                application.getString(R.string.database_name)
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePosterDao(database: BreweryDatabase): BreweryDao {
        return database.breweryDao()
    }
}