package com.ridwanproduction.learnandroidkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ridwanproduction.learnandroidkotlin.model.MuseumRepository

class ViewModelFactory(private val repository: MuseumRepository) : ViewModelProvider.Factory  {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MuseumViewModel(repository) as T
    }
}