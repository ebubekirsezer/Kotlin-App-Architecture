package com.ess.vipersample.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import com.ess.vipersample.app.model.StarWarsCharacter

interface HomeContract {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun displayCharacters(characterList: List<StarWarsCharacter>)
    }

    interface Presenter{
        fun onViewCreated()
        fun onDestroy()
        fun characterClicked(character: StarWarsCharacter?)
    }

    interface Interactor{
        fun loadCharacterList() : LiveData<List<StarWarsCharacter>>
        fun getAllCharacters()
    }

    interface InteractorOutput{
        fun onQuerySuccess(data: List<StarWarsCharacter>)
        fun onQueryError()
    }

    interface Router{
        fun goToDetail(character: StarWarsCharacter?)
    }
}