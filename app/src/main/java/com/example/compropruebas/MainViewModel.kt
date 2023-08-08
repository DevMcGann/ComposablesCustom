package com.example.compropruebas

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var showFullScreenModal = mutableStateOf(false)

    fun showFullScreen(){
        showFullScreenModal.value = true
    }

    fun hideFullScreen(){
        showFullScreenModal.value = false
    }
}