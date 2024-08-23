package com.medicare.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MusicViewModel : ViewModel() {
    private val _isMusicPlaying = MutableStateFlow(true) // Default to playing
    val isMusicPlaying: StateFlow<Boolean> = _isMusicPlaying

    fun toggleMusic() {
        _isMusicPlaying.value = !_isMusicPlaying.value
    }

    fun setMusicState(isPlaying: Boolean) {
        viewModelScope.launch {
            _isMusicPlaying.value = isPlaying
        }
    }
}
