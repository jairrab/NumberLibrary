package com.github.jairrab.numberlib.lib.formatter

import android.os.Build
import com.github.jairrab.numberlib.lib.formatter.utilities.android.AndroidDecimalFormat
import com.github.jairrab.numberlib.lib.formatter.utilities.android.AndroidDecimalFormatUtil
import com.github.jairrab.numberlib.lib.formatter.utilities.java.JavaDecimalFormat
import com.github.jairrab.numberlib.lib.formatter.utilities.java.JavaDecimalFormatUtil
import com.github.jairrab.numberlib.lib.params.NumberModel

internal class NumberFormatterUtility private constructor(
    private val numberFormatter: NumberFormatter
) {
    fun getText(model: NumberModel, number: Double): String {
        return numberFormatter.format(model, number)
    }

    companion object {
        fun getInstance() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NumberFormatterUtility(AndroidDecimalFormat(AndroidDecimalFormatUtil()))
        } else {
            NumberFormatterUtility(JavaDecimalFormat(JavaDecimalFormatUtil()))
        }
    }
}
