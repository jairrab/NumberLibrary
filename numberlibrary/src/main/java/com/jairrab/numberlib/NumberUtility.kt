package com.jairrab.numberlib

import com.jairrab.numberlib.lib.NumberUtilityLibrary
import com.jairrab.numberlib.lib.currency.CurrencySymbolRepo
import com.jairrab.numberlib.lib.currency.CurrencySymbolUtil
import com.jairrab.numberlib.lib.formatter.NumberFormatterUtility
import java.util.*

interface NumberUtility {
    var locale: Locale
    var currencyVisibility: Boolean
    var decimalPlaces: Int
    var decimalSeparator: Char
    var groupingSeparator: Char
    var negativePrefix: String
    var negativeSuffix: String

    val currency: String
    val currencySymbol: String
    val maximumNumber: Double

    fun updateCurrency(currency: String)
    fun getCurrencySymbol(currency: String): String

    fun getDefault(number: Double): String
    fun getDefault(number: Double, showCurrency: Boolean, currency: String?): String
    fun getDefault(number: Double, decimalPlaces: Int): String
    fun getAmount(number: Double): String
    fun getAmount(number: Double, decimalPlaces: Int): String
    fun getAmount(number: Double, currency: String): String
    fun getAmount(number: Double, currency: String, decimalPlaces: Int): String
    fun getDecimalString(number: Double, decimalPlaces: Int): String
    fun getFlexibleDecimal(number: Double): String
    fun getPercentString(number: Double, decimal: Int): String

    companion object {
        fun getInstance(
            maximumNumber: Double = Double.MAX_VALUE,
            locale: Locale = Locale.getDefault(),
            currencyVisibility: Boolean = true,
            decimalPlaces: Int = 2,
            currency: String = "USD",
            decimalSeparator: Char = '.',
            groupingSeparator: Char = ',',
            negativePrefix: String = "-",
            negativeSuffix: String = "",
        ): NumberUtility {
            val currencySymbolUtil = CurrencySymbolUtil(CurrencySymbolRepo())
            return NumberUtilityLibrary(
                maximumNumber = maximumNumber,
                numberFormatterUtility = NumberFormatterUtility.getInstance(),
                currencySymbolUtil = currencySymbolUtil,
                locale = locale,
                currency = currency,
                currencySymbol = currencySymbolUtil.get(currency),
                currencyVisibility = currencyVisibility,
                decimalPlaces = decimalPlaces,
                decimalSeparator = decimalSeparator,
                groupingSeparator = groupingSeparator,
                negativePrefix = negativePrefix,
                negativeSuffix = negativeSuffix,
            )
        }
    }
}

