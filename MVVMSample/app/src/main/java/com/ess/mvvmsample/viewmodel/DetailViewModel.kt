package com.ess.mvvmsample.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ess.mvvmsample.data.model.StarWarsCharacter

class DetailViewModel(val character: StarWarsCharacter) : ViewModel(){


    var starWarsCharacter : StarWarsCharacter? = null

    private var _isLoading = MutableLiveData<Int>()
    val isLoading: LiveData<Int>
        get() = _isLoading

    init {
        _isLoading.value = View.VISIBLE
        starWarsCharacter = character
        _isLoading.value = View.GONE
    }
}