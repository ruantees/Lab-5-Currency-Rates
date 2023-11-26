package com.example.currencyrates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter(private val myRates: List<Rate>): RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val currencyTextView: TextView = itemView.findViewById(R.id.currency)
        val rateTextView: TextView = itemView.findViewById(R.id.rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val rateView = inflater.inflate(R.layout.rate_row, parent, false)
        return ViewHolder(rateView)
    }

    override fun onBindViewHolder(viewHolder: CurrencyAdapter.ViewHolder, position: Int) {
        val rate: Rate = myRates[position]
        val currencyTextView = viewHolder.currencyTextView
        currencyTextView.text = rate.currencyId
        val rateTextView = viewHolder.rateTextView
        rateTextView.text = rate.currencyRate.toString()
    }

    override fun getItemCount(): Int {
        return myRates.size
    }
}