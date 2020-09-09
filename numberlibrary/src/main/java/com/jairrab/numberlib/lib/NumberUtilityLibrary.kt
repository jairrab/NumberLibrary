package com.jairrab.numberlib.lib

import com.jairrab.numberlib.NumberUtility
import com.jairrab.numberlib.lib.currency.CurrencySymbolUtil
import com.jairrab.numberlib.lib.formatter.NumberFormatterUtility
import com.jairrab.numberlib.lib.params.NumberModel
import java.util.*

internal class NumberUtilityLibrary(
    override val maximumNumber: Double,
    private val numberFormatterUtility: NumberFormatterUtility,
    private val currencySymbolUtil: CurrencySymbolUtil,
    override var locale: Locale = Locale.getDefault(),
    override var currencyVisibility: Boolean,
    override var decimalPlaces: Int,
    override var currency: String,
    override var currencySymbol: String,
    override var decimalSeparator: Char,
    override var groupingSeparator: Char,
    override var negativePrefix: String,
    override var negativeSuffix: String,
) : NumberUtility {

    override fun updateCurrency(currency: String) {
        this.currency = currency
        currencySymbol = currencySymbolUtil.get(currency)
    }

    override fun getDefault(number: Double): String {
        val numberModel = NumberModel(
            locale = locale,
            maxDigits = decimalPlaces,
            minDigits = decimalPlaces,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getDefault(number: Double, showCurrency: Boolean, currency: String?): String {
        val numberModel = NumberModel(
            currencySymbol = if (showCurrency && currencyVisibility) {
                if (currency == null) currencySymbol else getCurrencySymbol(currency)
            } else "",
            locale = locale,
            maxDigits = decimalPlaces,
            minDigits = decimalPlaces,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
            showCurrency = showCurrency,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getDefault(number: Double, decimalPlaces: Int): String {
        val numberModel = NumberModel(
            locale = locale,
            maxDigits = decimalPlaces,
            minDigits = decimalPlaces,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getAmount(number: Double): String {
        val numberModel = NumberModel(
            currencySymbol = if (currencyVisibility) currencySymbol else "",
            locale = locale,
            maxDigits = decimalPlaces,
            minDigits = decimalPlaces,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
            showCurrency = true,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getAmount(number: Double, decimalPlaces: Int): String {
        val numberModel = NumberModel(
            currencySymbol = if (currencyVisibility) currencySymbol else "",
            locale = locale,
            maxDigits = decimalPlaces,
            minDigits = decimalPlaces,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
            showCurrency = true,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getAmount(number: Double, currency: String): String {
        val numberModel = NumberModel(
            currencySymbol = if (currencyVisibility) getCurrencySymbol(currency) else "",
            locale = locale,
            maxDigits = decimalPlaces,
            minDigits = decimalPlaces,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
            showCurrency = true,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getAmount(number: Double, currency: String, decimalPlaces: Int): String {
        val numberModel = NumberModel(
            currencySymbol = if (currencyVisibility) getCurrencySymbol(currency) else "",
            locale = locale,
            maxDigits = decimalPlaces,
            minDigits = decimalPlaces,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
            showCurrency = true,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getDecimalString(number: Double, decimalPlaces: Int): String {
        val numberModel = NumberModel(
            minDigits = decimalPlaces,
            maxDigits = 8,
            decimalSeparator = '.',
            groupingSeparator = ',',
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getFlexibleDecimal(number: Double): String {
        val numberModel = NumberModel(
            locale = locale,
            maxDigits = 6,
            minDigits = 0,
            decimalSeparator = decimalSeparator,
            groupingSeparator = groupingSeparator,
            negativePrefix = negativePrefix,
            negativeSuffix = negativeSuffix,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getPercentString(number: Double, decimal: Int): String {
        val numberModel = NumberModel(
            isFormatAsPercentage = true,
            percentDecimalPlace = decimal,
        )
        return numberFormatterUtility.getText(numberModel, getNumber(number))
    }

    override fun getCurrencySymbol(currency: String): String {
        return currencySymbolUtil.get(currency)
    }

    private fun getNumber(number: Double) = if (number > maximumNumber) maximumNumber else number
}