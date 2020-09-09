package com.jairrab.numberlib.lib.formatter.utilities.java

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class JavaDecimalFormatUtil {
    fun getCurrencyInstanceJava(locale: Locale): DecimalFormat {
        return NumberFormat.getCurrencyInstance(locale) as DecimalFormat
    }

    fun getPercentInstanceJava(locale: Locale): DecimalFormat {
        return NumberFormat.getPercentInstance(locale) as DecimalFormat
    }

    fun getNumberInstanceJava(locale: Locale): DecimalFormat {
        return NumberFormat.getNumberInstance(locale) as DecimalFormat
    }

}