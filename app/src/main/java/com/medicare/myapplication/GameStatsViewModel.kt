package com.medicare.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameStatsViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferencesManager = SharedPreferencesManager(application)

    private val _totalWins = MutableStateFlow(sharedPreferencesManager.getTotalWins())
    val totalWins: StateFlow<Int> = _totalWins

    private val _totalLosses = MutableStateFlow(sharedPreferencesManager.getTotalLosses())
    val totalLosses: StateFlow<Int> = _totalLosses

    fun incrementWins() {
        _totalWins.value += 1
        saveData()
    }

    fun incrementLosses() {
        _totalLosses.value += 1
        saveData()
    }

    private fun saveData() {
        sharedPreferencesManager.saveTotalWins(_totalWins.value)
        sharedPreferencesManager.saveTotalLosses(_totalLosses.value)
    }
}
