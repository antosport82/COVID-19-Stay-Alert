package com.example.android.covid_19_stay_alert.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.covid_19_stay_alert.R
import com.example.android.covid_19_stay_alert.database.Country

class CountryAdapter: RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    var data =  listOf<Country>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val country_name: TextView = itemView.findViewById(R.id.txt_countryname)
        val country_confirmedcase: TextView = itemView.findViewById(R.id.txt_confirmed)
        val country_recoveredcase: TextView = itemView.findViewById(R.id.txt_recovered)
        val country_deaths: TextView = itemView.findViewById(R.id.txt_death)
        val country_latestupdate: TextView = itemView.findViewById(R.id.txt_latestupdate)

        fun bind(item:Country){
            country_name.text = item.name
            country_confirmedcase.text= item.totalConfirmed.toString()

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_countrylist, parent, false)
                return ViewHolder(view)
            }
        }

    }



}