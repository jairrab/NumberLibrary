package com.jairrab.github.numberlib.lib.params

import java.util.*

internal class NumberModel(
    val currencySymbol: String = "xxx",
    val isFormatAsPercentage: Boolean = false,
    val isGroupingUsed: Boolean = true,
    val locale: Locale = Locale.getDefault(),
    val maxDigits: Int = -1,
    val minDigits: Int = -1,
    val decimalSeparator: Char = ' ',
    val groupingSeparator: Char = ' ',
    val negativePrefix: String = "",
    val negativeSuffix: String = "",
    val percentDecimalPlace: Int = 2,
    val showCurrency: Boolean = false,
)
