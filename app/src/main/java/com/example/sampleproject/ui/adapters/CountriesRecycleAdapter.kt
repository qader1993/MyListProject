package com.example.sampleproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.databinding.RawCountriesItemLayoutBinding
import com.example.sampleproject.network.model.Country
import com.example.sampleproject.utils.Const.Companion.COMMA_SEPARATOR

/**
 * List adapter for Countries List
 */
class CountriesRecyclerAdapter : RecyclerView.Adapter<CountriesRecyclerAdapter.CountriesViewHolder>() {

    private var countriesList: List<Country> = emptyList()

    inner class CountriesViewHolder(private val binding: RawCountriesItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            with(binding) {
                nameOfCountry.text = country.name + COMMA_SEPARATOR
                regionOfCountry.text = country.region
                codeOfCountry.text = country.code
                capitalOfCountry.text = country.capital
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val binding = RawCountriesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(countriesList[position])
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    fun updateData(newData: List<Country>) {
        countriesList = newData
        notifyDataSetChanged()
    }
}
