package com.example.currencyrates

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratesList = "Press the button to load the Currency Rates"

        val rvRates: RecyclerView = findViewById(R.id.rv_rates)
        val adapter = CurrencyAdapter(ratesList)

        rvRates.adapter = adapter
        rvRates.layoutManager = LinearLayoutManager(this)

        val updateRatesButton = findViewById<Button>(R.id.update_rates)
        updateRatesButton.setOnClickListener {
            getDataByAsyncTask(adapter)

            rvRates.adapter = adapter
            rvRates.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun getDataByAsyncTask(adapter: CurrencyAdapter) {
        object : AsyncDataLoader(adapter) {}.execute(ApiUrls.FLOATRATES_API_URL)
    }
}