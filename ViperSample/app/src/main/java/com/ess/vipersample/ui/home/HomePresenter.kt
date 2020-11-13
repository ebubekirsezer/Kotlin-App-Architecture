package com.ess.vipersample.ui.home

import androidx.lifecycle.Observer
import com.ess.vipersample.app.model.StarWarsCharacter

class HomePresenter(
    private var view: HomeContract.View?,
    private var interactor: HomeContract.Interactor?,
    private val router: HomeContract.Router?
) : HomeContract.Presenter, HomeContract.InteractorOutput {

    override fun onViewCreated() {
        view?.showLoading()
        interactor?.loadCharacterList()?.observe((view as HomeFragment), Observer { characterList ->
            if(characterList != null)
                onQuerySuccess(characterList)
            else
                onQueryError()
        })
    }

    override fun onDestroy() {
        view = null
        interactor = null
    }

    override fun characterClicked(character: StarWarsCharacter?) {
        router?.goToDetail(character)
    }

    override fun onQuerySuccess(data: List<StarWarsCharacter>) {
        view?.hideLoading()
        view?.displayCharacters(data)
    }

    override fun onQueryError() {
        view?.hideLoading()
    }

}