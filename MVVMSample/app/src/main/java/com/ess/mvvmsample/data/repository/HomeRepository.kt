package com.ess.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import com.ess.mvvmsample.data.model.StarWarsCharacter

interface HomeRepository{
    fun getAllCharacters(): LiveData<List<StarWarsCharacter>>
}