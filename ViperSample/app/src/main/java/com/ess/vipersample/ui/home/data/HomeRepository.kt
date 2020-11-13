package com.ess.vipersample.ui.home.data

import androidx.lifecycle.LiveData
import com.ess.vipersample.app.model.StarWarsCharacter

interface HomeRepository{
    fun getAllCharacters(): LiveData<List<StarWarsCharacter>>
}