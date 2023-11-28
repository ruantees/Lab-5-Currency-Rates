package com.example.currencyrates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter(var ratesList: String): RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val currencyTV: TextView = itemView.findViewById(R.id.currency)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rateView = inflater.inflate(R.layout.rate_row, parent, false)
        return ViewHolder(rateView)
    }

    override fun onBindViewHolder(viewHolder: CurrencyAdapter.ViewHolder, position: Int) {
        val ratesListArray = ratesList.split("\n")
        val rate: String = ratesListArray[position]
        val currencyTextView = viewHolder.currencyTV
        currencyTextView.text = rate
    }

    override fun getItemCount(): Int {
        val ratesListArray = ratesList.split("\n")
        return ratesListArray.size
    }
}