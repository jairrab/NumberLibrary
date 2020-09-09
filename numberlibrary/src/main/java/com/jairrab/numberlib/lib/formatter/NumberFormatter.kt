package com.jairrab.numberlib.lib.formatter

import com.jairrab.numberlib.lib.params.NumberModel

abstract class NumberFormatter {
    internal abstract fun format(model: NumberModel, number: Double): String
}