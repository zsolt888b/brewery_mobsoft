package com.example.brewery.UI.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brewery.Model.Brewery
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
): ViewModel(){
    @Inject lateinit var mainRepository: MainRepository;
    private val firebaseAnalytics = Firebase.analytics;

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading

    private val _showBackButton: MutableState<Boolean> = mutableStateOf(false)
    val showBackButton: State<Boolean> get() = _showBackButton

    private val _showAddButton: MutableState<Boolean> = mutableStateOf(true)
    val showAddButton: State<Boolean> get() = _showAddButton

    private val _showSaveButton: MutableState<Boolean> = mutableStateOf(false)
    val showSaveButton: State<Boolean> get() = _showSaveButton

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    private val _selectedBrewery: MutableState<Brewery> = mutableStateOf(Brewery())
    val selectedBrewery: State<Brewery> get() = _selectedBrewery

    private val _title: MutableState<String> = mutableStateOf("Breweries")
    val title: State<String> get() = _title

    val breweryList: Flow<List<Brewery>?> =
        mainRepository.loadBreweries(
            onStart = { _isLoading.value = true },
            onCompletion = { _isLoading.value = false }
        )

    fun selectBrewery(tab: Int, brewery: Brewery) {
        _selectedTab.value = tab;
        _selectedBrewery.value = brewery;
        _title.value = brewery.name;
        _showBackButton.value = true;
        _showAddButton.value = false;
        if(tab == 2){
            _showSaveButton.value = true;
        }
        firebaseAnalytics.logEvent("Brewery_selected") {
            param("Brewery_name", _selectedBrewery.value.name)
            param("Brewery_country", _selectedBrewery.value.country?: "no_country")
        }
    }

    fun delete(brewery: Brewery){
        mainRepository.delete(brewery);
        firebaseAnalytics.logEvent("Delete_brewery") {
            param("Brewery_name", _selectedBrewery.value.name)
            param("Brewery_country", _selectedBrewery.value.country?: "no_country")
        }
    }

    fun backClicked(tab: Int){
        _selectedTab.value = tab;
        _title.value = "Breweries";
        _showBackButton.value = false;
        _showAddButton.value = true;
        _showSaveButton.value = false;
    }

    fun addClicked(tab: Int){
        _selectedTab.value = tab;
        _title.value = "Add new brewery";
        _selectedBrewery.value = Brewery();
        _showBackButton.value = true;
        _showAddButton.value = false;
        _showSaveButton.value = true;
    }

    fun saveClicked(tab: Int){
        mainRepository.add(_selectedBrewery.value);
        _title.value = "Breweries";
        _showBackButton.value = false;
        _showAddButton.value = true;
        _showSaveButton.value = false;
        _selectedTab.value = tab;
        firebaseAnalytics.logEvent("Brewery_saved") {
            param("Brewery_name", _selectedBrewery.value.name)
            param("Brewery_country", _selectedBrewery.value.country?: "no_country")
        }
    }

    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }
}