package com.example.currencyrates

import java.io.InputStream
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

class APIRatesParser {
    fun getCRates(stream: InputStream): String {
        var result = ""
        try {
            val xmlDocFactory = DocumentBuilderFactory.newInstance()
            val xmlDocBuilder = xmlDocFactory.newDocumentBuilder()
            val doc = xmlDocBuilder.parse(stream)
            val rateNodes = doc.getElementsByTagName("item")

            for (i in 0 until rateNodes.length) {
                val rateNode = rateNodes.item(i) as Element
                val currencyName = rateNode.getElementsByTagName("targetCurrency").item(0).firstChild.nodeValue
                val rate = rateNode.getElementsByTagName("exchangeRate").item(0).firstChild.nodeValue
                result += String.format("Currency name: %s, rate %s \n", currencyName, rate)
            }
        } catch (_: Exception) { }

        return result
    }
}
