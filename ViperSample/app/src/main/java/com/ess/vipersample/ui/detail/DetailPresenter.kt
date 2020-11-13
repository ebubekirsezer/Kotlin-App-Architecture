package com.ess.vipersample.ui.detail

import com.ess.vipersample.app.model.StarWarsCharacter
import com.ess.vipersample.ui.home.HomeContract

class DetailPresenter(private var view: DetailContract.View?,
                      private var interactor: DetailContract.Interactor?,
                      private val router: DetailContract.Router?) : DetailContract.Presenter{

    override fun onViewCreated() {
        view?.showLoading()
        view?.displayDetail()
        view?.hideLoading()
    }

    override fun onDestroy() {
        view = null
        interactor = null
    }
}