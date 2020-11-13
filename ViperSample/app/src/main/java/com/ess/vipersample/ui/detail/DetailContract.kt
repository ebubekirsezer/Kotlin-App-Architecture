package com.ess.vipersample.ui.detail

interface DetailContract {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun displayDetail()
    }

    interface Presenter{
        fun onViewCreated()
        fun onDestroy()
    }

    interface Interactor{

    }

    interface Router{

    }
}

