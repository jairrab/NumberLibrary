package com.jairrab.numberlib.lib.currency

import android.icu.util.Currency

internal class CurrencySymbolUtil(
    private val currencySymbolRepo: CurrencySymbolRepo
) {
    fun get(currency: String): String {
        return try {
            currencySymbolRepo.getSymbol(currency)
                ?: let {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        Currency.getInstance(currency).symbol
                    } else {
                        java.util.Currency.getInstance(currency).symbol
                    }
                }
        } catch (e: IllegalArgumentException) {
            currency
        }
    }
}