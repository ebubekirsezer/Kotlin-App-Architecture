package com.ess.vipersample.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.ess.vipersample.R
import com.ess.vipersample.app.model.StarWarsCharacter
import com.ess.vipersample.ui.home.adapter.HomeAdapter

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var adapter: HomeAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var starWarsCharacterList: RecyclerView
    lateinit var presenter: HomeContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        starWarsCharacterList = view?.findViewById(R.id.star_wars_character_list)!!
        progressBar = view?.findViewById(R.id.progressBar)!!
        presenter = HomePresenter(this, HomeInteractor(), HomeRouter(this))
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoading() {
        starWarsCharacterList.isEnabled = false
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        starWarsCharacterList.isEnabled = true
        progressBar.visibility = View.GONE
    }

    override fun displayCharacters(characterList: List<StarWarsCharacter>) {
        adapter = HomeAdapter(characterList){character ->
            presenter?.characterClicked(character)
        }
        starWarsCharacterList.adapter = adapter
    }
}