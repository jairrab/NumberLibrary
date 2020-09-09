package com.jairrab.numberlib.lib.formatter.utilities.java

import com.jairrab.numberlib.lib.params.NumberModel
import com.jairrab.numberlib.lib.formatter.NumberFormatter
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

internal class JavaDecimalFormat(
    private val decimalFormatUtil: JavaDecimalFormatUtil
) : NumberFormatter() {
    override fun format(model: NumberModel, number: Double): String {
        val format: DecimalFormat

        when {
            model.showCurrency -> {
                format = decimalFormatUtil.getCurrencyInstanceJava(model.locale)

                val symbols = DecimalFormatSymbols(model.locale)
                symbols.currencySymbol = model.currencySymbol

                if (model.decimalSeparator.toInt() != 0)
                    symbols.monetaryDecimalSeparator = model.decimalSeparator

                if (model.groupingSeparator.toInt() != 0)
                    symbols.groupingSeparator = model.groupingSeparator

                format.decimalFormatSymbols = symbols
            }
            model.isFormatAsPercentage -> {
                format = decimalFormatUtil.getPercentInstanceJava(model.locale)
                format.applyPattern(getPercentagePattern(model.percentDecimalPlace))
            }
            else -> {
                format = decimalFormatUtil.getNumberInstanceJava(model.locale)

                val symbols = DecimalFormatSymbols(model.locale)

                if (model.decimalSeparator.toInt() != 0)
                    symbols.decimalSeparator = model.decimalSeparator

                if (model.groupingSeparator.toInt() != 0)
                    symbols.groupingSeparator = model.groupingSeparator

                format.decimalFormatSymbols = symbols
            }
        }

        format.isGroupingUsed = model.isGroupingUsed

        if (model.minDigits != -1) format.minimumFractionDigits = model.minDigits

        if (model.maxDigits != -1) format.maximumFractionDigits = model.maxDigits

        return if (number < 0 && model.negativePrefix == "(") {
            String.format(
                "%s%s%s",
                model.negativePrefix,
                format.format(number),
                model.negativeSuffix
            )
        } else {
            format.format(number)
        }
    }

    private fun getPercentagePattern(decimalPlaces: Int): String {
        if (decimalPlaces == 0) return "#%"

        val s = StringBuilder("#.")

        for (i in 0 until decimalPlaces) {
            s.append('#')
        }

        return s.append("%").toString()
    }
}