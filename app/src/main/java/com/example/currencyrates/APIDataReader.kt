package com.example.currencyrates

import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class APIDataReader {
    companion object {
        private const val url = ApiUrls.FLOATRATES_API_URL
        @Throws(IOException::class)
        fun getValuesFromApi(apiUrl: String) : String {
            var apiContextStream : InputStream? = null
            var result = ""
            try {
                when (apiUrl) {
                    url -> {
                        apiContextStream = downloadUrlContent(url)
                        result = APIRatesParser.getRates(apiContextStream)
                    }
                    else -> { }
                }
            }
            finally {
                apiContextStream?.close()
            }
            return result
        }

        @Throws(IOException::class)
        fun downloadUrlContent(urlString: String?): InputStream? {
            val url = URL(urlString)
            val conn = url.openConnection() as HttpURLConnection

            conn.readTimeout = 30000
            conn.connectTimeout = 60000
            conn.requestMethod = "GET"
            conn.doInput = true
            conn.connect()

            return conn.inputStream
        }
    }
}