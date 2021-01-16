package com.heliushouse.talkingfragment.with_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AwesomeViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AwesomeViewModel::class.java)) {
            return AwesomeViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}