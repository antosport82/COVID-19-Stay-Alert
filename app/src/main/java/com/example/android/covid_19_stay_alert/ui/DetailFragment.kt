package com.example.android.covid_19_stay_alert.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.android.covid_19_stay_alert.R
import com.example.android.covid_19_stay_alert.databinding.FragmentDetailBinding
import com.example.android.covid_19_stay_alert.viewmodels.DetailViewModel
import com.example.android.covid_19_stay_alert.viewmodels.DetailViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var viewViewModelFactory: DetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail, container, false
        )

        val detailFragmentArgs by navArgs<DetailFragmentArgs>()

        viewViewModelFactory =
            DetailViewModelFactory(
                detailFragmentArgs.countryCode
            )
        viewModel = ViewModelProvider(this, viewViewModelFactory).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this

        binding.detailViewModel = viewModel

        setHasOptionsMenu(true)
        return binding.root
    }
}