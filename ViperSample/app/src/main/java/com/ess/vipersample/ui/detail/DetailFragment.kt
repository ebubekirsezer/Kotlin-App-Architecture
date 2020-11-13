package com.ess.vipersample.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ess.vipersample.R
import kotlinx.android.synthetic.main.character_list_item.*
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(), DetailContract.View {

    lateinit var presenter: DetailContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = DetailPresenter(this,DetailInteractor(),DetailRouter())
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        presenter.onViewCreated()
        super.onResume()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showLoading() {
        detail_progressbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        detail_progressbar.visibility = View.GONE
    }

    override fun displayDetail() {
        val character = DetailFragmentArgs.fromBundle(requireArguments()).character
        detail_character_name.text = "Name: ${character.name}"
        detail_character_birthyear.text= "Birthyear: ${character.birth_year}"
        detail_character_gender.text = "Gender: ${character.gender}"
        detail_character_height.text = "Height: ${character.height}"

    }
}