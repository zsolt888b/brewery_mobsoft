package com.example.brewery.UI.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brewery.Model.Brewery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
): ViewModel(){
    @Inject lateinit var mainRepository: MainRepository;

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    val breweryList: Flow<List<Brewery>?> =
        mainRepository.loadBreweries(
            onStart = { _isLoading.value = true },
            onCompletion = { _isLoading.value = false }
        )

    fun selectTab(tab: Int) {
        _selectedTab.value = tab
    }

    fun add(brewery: Brewery){
        mainRepository.add(brewery);
    }

    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }
}