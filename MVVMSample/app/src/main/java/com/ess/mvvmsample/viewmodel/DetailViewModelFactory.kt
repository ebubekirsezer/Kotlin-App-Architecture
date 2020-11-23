package com.ess.mvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ess.mvvmsample.data.model.StarWarsCharacter
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val character: StarWarsCharacter): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(character) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}