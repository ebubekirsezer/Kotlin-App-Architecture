package com.ess.vipersample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ess.vipersample.app.model.StarWarsCharacter
import com.ess.vipersample.ui.home.data.HomeRepositoryImpl

class HomeInteractor: HomeContract.Interactor{

    private val characterList = MediatorLiveData<List<StarWarsCharacter>>()
    private val repository: HomeRepositoryImpl = HomeRepositoryImpl()

    init {
        getAllCharacters()
    }

    override fun loadCharacterList(): LiveData<List<StarWarsCharacter>> = characterList

    override fun getAllCharacters() {
        characterList.addSource(repository.getAllCharacters()){characters ->
            println(characters)
            characterList.postValue(characters)
        }
    }

}