package com.example.android.covid_19_stay_alert.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.covid_19_stay_alert.R
import com.example.android.covid_19_stay_alert.database.CovidDatabase
import com.example.android.covid_19_stay_alert.databinding.FragmentTitleBinding
import com.example.android.covid_19_stay_alert.viewmodels.TitleViewModel
import com.example.android.covid_19_stay_alert.viewmodels.TitleViewModelFactory

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    private lateinit var viewModel: TitleViewModel
    private lateinit var viewModelFactory: TitleViewModelFactory

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

        // viewModel creation
        val application = requireNotNull(this.activity).application
        val dataSource = CovidDatabase.getInstance(application).covidDao
        viewModelFactory = TitleViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(TitleViewModel::class.java)

        val adapter = CountryAdapter()
        binding.countryList.adapter = adapter

        binding.lifecycleOwner = this

        binding.titleViewModel = viewModel

        setHasOptionsMenu(true)
        viewModel.countries.observe(viewLifecycleOwner, Observer {

            it?.let {
                adapter.data = it
            }
        })
        return binding.root
    }
}