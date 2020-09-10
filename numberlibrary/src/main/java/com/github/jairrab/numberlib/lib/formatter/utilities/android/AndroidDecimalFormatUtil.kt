package com.github.jairrab.numberlib.lib.formatter.utilities.android

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
class AndroidDecimalFormatUtil {
    fun getCurrencyInstance(locale: Locale): DecimalFormat {
        return NumberFormat.getCurrencyInstance(locale) as DecimalFormat
    }

    fun getPercentInstance(locale: Locale): DecimalFormat {
        return NumberFormat.getPercentInstance(locale) as DecimalFormat
    }

    fun getNumberInstance(locale: Locale): DecimalFormat {
        return NumberFormat.getNumberInstance(locale) as DecimalFormat
    }
}