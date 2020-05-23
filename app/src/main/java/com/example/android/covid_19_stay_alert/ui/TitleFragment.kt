package com.example.android.covid_19_stay_alert.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.covid_19_stay_alert.R
import com.example.android.covid_19_stay_alert.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding

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
            view.findNavController().navigate(R.id.action_titleFragment_to_detailFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}