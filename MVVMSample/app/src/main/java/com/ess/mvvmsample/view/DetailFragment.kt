package com.ess.mvvmsample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ess.mvvmsample.R
import com.ess.mvvmsample.databinding.FragmentDetailBinding
import com.ess.mvvmsample.viewmodel.DetailViewModel
import com.ess.mvvmsample.viewmodel.DetailViewModelFactory


class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val character = DetailFragmentArgs.fromBundle(requireArguments()).character

        val binding = FragmentDetailBinding.inflate(inflater)

        val viewModelFactory = DetailViewModelFactory(character)
        viewModel = ViewModelProvider(this,viewModelFactory).get(DetailViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }
}