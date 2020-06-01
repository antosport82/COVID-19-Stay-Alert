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

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = CovidDatabase.getInstance(application).covidDao
        val viewModelFactory = TitleViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this,viewModelFactory).get(TitleViewModel::class.java)
        Timber.i("viewModel called")

        binding.titleViewModel = viewModel

        val adapter = CountryAdapter()
        binding.countryList.adapter=adapter

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)
        viewModel.countries.observe(viewLifecycleOwner, Observer {

            it?.let {
                adapter.data=it
            }
        })
        return binding.root
    }
}

