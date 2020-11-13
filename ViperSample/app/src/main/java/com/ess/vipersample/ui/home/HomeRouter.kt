package com.ess.vipersample.ui.home

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.ess.vipersample.app.model.StarWarsCharacter

class HomeRouter(private val fragment: HomeFragment) : HomeContract.Router{
    override fun goToDetail(character: StarWarsCharacter?) {
        character?.let {
            fragment.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
        }
    }

}