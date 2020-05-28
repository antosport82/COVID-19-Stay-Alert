package com.example.android.covid_19_stay_alert.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.covid_19_stay_alert.R
import com.example.android.covid_19_stay_alert.databinding.FragmentTitleBinding
import com.example.android.covid_19_stay_alert.viewmodels.TitleViewModel
import timber.log.Timber

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_title, container, false
        )

        binding.nextButton.setOnClickListener { view: View ->
            Toast.makeText(activity, "Button has just been clicked", Toast.LENGTH_SHORT).show()
            val countryCode = viewModel.countryCodeTest
            val action = TitleFragmentDirections.actionTitleFragmentToDetailFragment(countryCode)
            view.findNavController().navigate(action)
        }

        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        Timber.i("viewModel called")

        binding.titleViewModel = viewModel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)
        return binding.root
    }
}