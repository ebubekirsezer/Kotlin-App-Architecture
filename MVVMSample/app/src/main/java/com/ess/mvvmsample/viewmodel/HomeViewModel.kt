package com.ess.mvvmsample.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ess.mvvmsample.data.model.StarWarsCharacter
import com.ess.mvvmsample.data.repository.HomeRepository
import com.ess.mvvmsample.data.repository.HomeRepositoryImpl

class HomeViewModel (private val repository: HomeRepository = HomeRepositoryImpl()): ViewModel(){

    private var _isLoading = MutableLiveData<Int>()
    val isLoading: LiveData<Int>
        get() = _isLoading

    private val _navigateToDetail = MutableLiveData<Boolean>()
    val navigateToDetail : LiveData<Boolean>
        get() = _navigateToDetail

    var starWarsCharacter: StarWarsCharacter? = null

    init {
        getAllCharacters()
    }

    fun getAllCharacters(): LiveData<List<StarWarsCharacter>>{
        _isLoading.value = View.VISIBLE
        val data = repository.getAllCharacters()
        _isLoading.value = View.GONE
        return data
    }

    fun onCharacterClicked(character: StarWarsCharacter){
        _isLoading.value = View.VISIBLE
        starWarsCharacter = character
        _navigateToDetail.value = true
    }

    fun onCharacterDetailNavigated(){
        _isLoading.value= View.GONE
        _navigateToDetail.value = false
    }
}