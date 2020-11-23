package com.ess.mvvmsample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ess.mvvmsample.R
import com.ess.mvvmsample.adapters.CharacterClickListener
import com.ess.mvvmsample.adapters.HomeAdapter
import com.ess.mvvmsample.databinding.FragmentHomeBinding
import com.ess.mvvmsample.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)

        binding.viewModel = viewModel

        viewModel.getAllCharacters().observe(viewLifecycleOwner, Observer { characters ->
            characters?.let {
                val adapter = HomeAdapter(
                    CharacterClickListener { character ->
                        viewModel.onCharacterClicked(character)
                    },
                    characters
                )
                binding.starWarsCharacterList.adapter = adapter
            }
        })

        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {
                viewModel.starWarsCharacter?.let {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                            it
                        )
                    )
                    viewModel.onCharacterDetailNavigated()
                }
            }
        })

        binding.setLifecycleOwner(this)

        return binding.root
    }

}