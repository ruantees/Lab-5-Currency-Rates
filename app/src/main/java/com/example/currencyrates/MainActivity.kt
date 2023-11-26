package com.example.currencyrates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var ratesList: ArrayList<Rate>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvRates = findViewById<View>(R.id.rv_rates) as RecyclerView

        // Create the list of rates taken from .json
        // ratesList =

        val adapter = CurrencyAdapter(ratesList)
        rvRates.adapter = adapter
        rvRates.layoutManager = LinearLayoutManager(this)
    }
}