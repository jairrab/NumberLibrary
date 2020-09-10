package com.jairrab.github.numberlib.lib.formatter

import com.jairrab.github.numberlib.lib.params.NumberModel

abstract class NumberFormatter {
    internal abstract fun format(model: NumberModel, number: Double): String
}