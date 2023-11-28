package com.example.currencyrates

import android.os.AsyncTask
import java.io.IOException

open class AsyncDataLoader(private val adapter: CurrencyAdapter) : AsyncTask<String, Void, String>() {
    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: String): String {
        return try {
            APIDataReader.getValuesFromApi(params[0])
        } catch (e: IOException) {
            String.format("Error %s", e)
        }
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("super.onPostExecute(result)", "android.os.AsyncTask")
    )
    override fun onPostExecute(result: String) {
        adapter.ratesList = result
    }
}